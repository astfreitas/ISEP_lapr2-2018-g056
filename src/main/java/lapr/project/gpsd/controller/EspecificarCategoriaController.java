/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarCategoriaController
{
    private Company m_oEmpresa;
    private Category m_oCategoria;
    public EspecificarCategoriaController()
    {
        if(!AplicacaoGPSD.getInstance().getSessaoAtual().isLoggedInWithRole(Constants.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oEmpresa = AplicacaoGPSD.getInstance().getEmpresa();
    }
    
    
    public boolean novaCategoria(String strCodigo, String strDescricao)
    {
        try
        {
            this.m_oCategoria = this.m_oEmpresa.novaCategoria(strCodigo, strDescricao);
            return this.m_oEmpresa.validaCategoria(this.m_oCategoria);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCategoria = null;
            return false;
        }
    }
   
    
    public boolean registaCategoria()
    {
        return this.m_oEmpresa.registaCategoria(this.m_oCategoria);
    }

    public String getCategoriaString()
    {
        return this.m_oCategoria.toString();
    }
}