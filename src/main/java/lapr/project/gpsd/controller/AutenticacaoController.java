/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.authentication.model.UserRole;

/**
 *
 * @author paulomaio
 */
public class AutenticacaoController
{
    private AplicacaoGPSD m_oApp;
    
    public AutenticacaoController()
    {
        this.m_oApp = AplicacaoGPSD.getInstance();
    }
    
    public boolean doLogin(String strId, String strPwd)
    {
        return this.m_oApp.doLogin(strId, strPwd);
    }
    
    public List<UserRole> getPapeisUtilizador()
    {
        if (this.m_oApp.getSessaoAtual().isLoggedIn())
        {
            return this.m_oApp.getSessaoAtual().getUserRoles();
        }
        return null;
    }

    public void doLogout()
    {
        this.m_oApp.doLogout();
    }
}