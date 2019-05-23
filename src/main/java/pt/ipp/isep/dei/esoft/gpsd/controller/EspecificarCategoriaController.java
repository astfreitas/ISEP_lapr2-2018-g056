/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.gpsd.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.gpsd.model.Categoria;
import pt.ipp.isep.dei.esoft.gpsd.model.Constantes;
import pt.ipp.isep.dei.esoft.gpsd.model.Empresa;
import pt.ipp.isep.dei.esoft.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarCategoriaController
{
    private Empresa m_oEmpresa;
    private Categoria m_oCategoria;
    public EspecificarCategoriaController()
    {
        if(!AplicacaoGPSD.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
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
