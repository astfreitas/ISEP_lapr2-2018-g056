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
import lapr.project.gpsd.utils.Constants;
import lapr.project.gpsd.model.Company;

/**
 *
 * @author paulomaio
 */
public class ApplicationGPSD {

    private final Company company;
    private final AuthenticationFacade authentication;

    public ApplicationGPSD() {
        Properties props = getProperties();
        this.company = new Company(props);
        this.authentication = this.company.getAuthenticationFacade();
        bootstrap();
    }

    public Company getCompany() {
        return this.company;
    }

    public UserSession getCurrentSession() {
        return this.authentication.getCurrentSession();
    }

    public boolean doLogin(String id, String pwd) {
        return this.authentication.doLogin(id, pwd) != null;
    }

    public void doLogout() {
        this.authentication.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Default Lda.");
        props.setProperty(Constants.PARAMS_COMPANY_NIF, "Default NIF");

        // Lê as propriedades e valores definidas 
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILE);
            props.load(in);
            in.close();
        } catch (Exception ex) {

        }
        return props;
    }

    private void bootstrap() {
        this.authentication.registerUserRole(Constants.ROLE_ADMINISTRATIVE);
        this.authentication.registerUserRole(Constants.ROLE_CLIENT);
        this.authentication.registerUserRole(Constants.ROLE_HRO);
        this.authentication.registerUserRole(Constants.ROLE_SERVICE_PROVIDER);

        this.authentication.registerUserWithRole("Adminstrative 1", "adm1", "123456", Constants.ROLE_ADMINISTRATIVE);
        this.authentication.registerUserWithRole("Adminstrative 2", "adm2", "123456", Constants.ROLE_ADMINISTRATIVE);

        this.authentication.registerUserWithRole("HRO 1", "hro1", "123456", Constants.ROLE_HRO);
        this.authentication.registerUserWithRole("HRO 2", "hro2", "123456", Constants.ROLE_HRO);

        this.authentication.registerUserWithRole("Client 1", "cli1", "123", Constants.ROLE_CLIENT);

    }

    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static ApplicationGPSD singleton = null;

    public static ApplicationGPSD getInstance() {
        if (singleton == null) {
            synchronized (ApplicationGPSD.class) {
                singleton = new ApplicationGPSD();
            }
        }
        return singleton;
    }

}
