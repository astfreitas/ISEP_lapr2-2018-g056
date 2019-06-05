/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import lapr.project.authentication.AuthenticationFacade;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Company;

/**
 *
 * @author paulomaio
 */
public class ApplicationGPSD
{
       
    private final Company m_oEmpresa;
    private final AuthenticationFacade m_oAutorizacao;
    
    private ApplicationGPSD()
    {
        Properties props = getProperties();
        this.m_oEmpresa = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION),
                        props.getProperty(Constants.PARAMS_COMPANY_NIF));
        this.m_oAutorizacao = this.m_oEmpresa.getAutorizacaoFacade();
        bootstrap();
    }
    
    public Company getEmpresa()
    {
        return this.m_oEmpresa;
    }
    

    public UserSession getCurrentSession()
    {
        return this.m_oAutorizacao.getCurrentSession();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
       return this.m_oAutorizacao.doLogin(strId,strPwd) != null;
    }
    
    public void doLogout()
    {
        this.m_oAutorizacao.doLogout();
    }
    
    private Properties getProperties()
    {
        Properties props = new Properties();
        
        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_NIF, "Default NIF");
        
        // Lê as propriedades e valores definidas 
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
            props.load(in);
            in.close();
        }
        catch(Exception ex)
        {
            
        }
        return props;
    }

    
    private void bootstrap()
    {
        this.m_oAutorizacao.registerUserRole(Constants.ROLE_ADMINISTRATIVE);
        this.m_oAutorizacao.registerUserRole(Constants.ROLE_CLIENT);
        this.m_oAutorizacao.registerUserRole(Constants.ROLE_HRO);
        this.m_oAutorizacao.registerUserRole(Constants.ROLE_SERVICE_PROVIDER);
        
        this.m_oAutorizacao.registerUserWithRole("Administrativo 1", "adm1@esoft.pt", "123456",Constants.ROLE_ADMINISTRATIVE);
        this.m_oAutorizacao.registerUserWithRole("Administrativo 2", "adm2@esoft.pt", "123456",Constants.ROLE_ADMINISTRATIVE);
        
        this.m_oAutorizacao.registerUserWithRole("FRH 1", "frh1@esoft.pt", "123456",Constants.ROLE_HRO);
        this.m_oAutorizacao.registerUserWithRole("FRH 2", "frh2@esoft.pt", "123456",Constants.ROLE_HRO);
        
        this.m_oAutorizacao.registerUserWithRoles("Martim", "martim@esoft.pt", "123456",new String[] {Constants.ROLE_HRO, Constants.ROLE_ADMINISTRATIVE});
    }
    
    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationGPSD singleton = null;
    public static ApplicationGPSD getInstance() 
    {
        if(singleton == null) 
        {
            synchronized(ApplicationGPSD.class) 
            { 
                singleton = new ApplicationGPSD();
            }
        }
        return singleton;
    }

    
}
