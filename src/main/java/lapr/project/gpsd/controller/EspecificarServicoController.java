/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarServicoController
{
    private Company m_oEmpresa;
    private Service m_oServico;
    public EspecificarServicoController()
    {
        if(!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oEmpresa = ApplicationGPSD.getInstance().getEmpresa();
    }
    
    public List<Category> getCategorias()
    {
        return this.m_oEmpresa.getCategorias();
    }
    
    public boolean novoServico(String strId, String strDescricaoBreve, String strDescricaoCompleta, double dCustoHora, String categoriaId)
    {
        try
        {
            Category cat = this.m_oEmpresa.getCategoriaById(categoriaId);
            this.m_oServico = this.m_oEmpresa.novoServico(strId, strDescricaoBreve,strDescricaoCompleta,dCustoHora,cat);
            return this.m_oEmpresa.validaServico(this.m_oServico);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oServico = null;
            return false;
        }
    }
   
    
    public boolean registaServico()
    {
        return this.m_oEmpresa.registaServico(this.m_oServico);
    }

    public String getServicoString()
    {
        return this.m_oServico.toString();
    }
}
