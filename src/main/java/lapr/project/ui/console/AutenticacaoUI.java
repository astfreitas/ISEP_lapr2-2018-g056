/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.console;

import java.util.List;
import lapr.project.modelAuto.PapelUtilizador;
import lapr.project.controllerAuto.AutenticacaoController;
import lapr.project.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class AutenticacaoUI
{
    private AutenticacaoController m_controller;

    public AutenticacaoUI()
    {
        m_controller = new AutenticacaoController();
    }

    public boolean run()
    {
        System.out.println("\nEfetuar Login/Autenticação:");
     
        int maxTentativas = 3;
        boolean sucesso = false;
        do
        {
            maxTentativas--;
            String sId = Utils.readLineFromConsole("Introduza Id/Email: ");
            String sPwd = Utils.readLineFromConsole("Introduza Palavra-Passe: ");
            
            sucesso = m_controller.doLogin(sId, sPwd);
            if (!sucesso)
            {
                System.out.println("Utilizador ou Palavra-Passe erradas. \n Possui mais " + maxTentativas + " tentativas");
            }
        
        } while (!sucesso && maxTentativas > 0);
        return sucesso;
    }
    
    public List<PapelUtilizador> getPapeisUtilizador()
    {
        return this.m_controller.getPapeisUtilizador();
    }

    public void logout()
    {
        m_controller.doLogout();
    }
}
