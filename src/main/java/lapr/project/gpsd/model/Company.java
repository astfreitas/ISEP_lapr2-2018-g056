/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lapr.project.autorizacao.AutorizacaoFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company
{
    private String m_strDesignacao;
    private String m_strNIF;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<Client> m_lstClientes;
    private final Set<Category> m_lstCategorias;
    private final Set<Service> m_lstServicos;
    

    public Company(String strDesignacao, String strNIF)
    {
        if ( (strDesignacao == null) || (strNIF == null) ||
                (strDesignacao.isEmpty())|| (strNIF.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strDesignacao = strDesignacao;
        this.m_strNIF = strNIF;
        
        this.m_oAutorizacao = new AutorizacaoFacade();
        
        this.m_lstClientes = new HashSet<>();
        this.m_lstCategorias = new HashSet<>();
        this.m_lstServicos = new HashSet<>();
    }
    
    public AutorizacaoFacade getAutorizacaoFacade()
    {
        return this.m_oAutorizacao;
    }
    
    // Clientes
    
    // <editor-fold defaultstate="collapsed">
    public Client getClienteByEmail(String strEMail)
    {
        for(Client cliente : this.m_lstClientes)
        {
            if (cliente.hasEmail(strEMail))
            {
                return cliente;
            }
        }
        
        return null;
    }

    public Client novoCliente(String strNome, String strNIF, String strTelefone, String strEmail, Address morada)
    {
        return new Client(strNome, strNIF, strTelefone, strEmail, morada);
    }

    public boolean registaCliente(Client oCliente, String strPwd)
    {
        if (this.validaCliente(oCliente,strPwd))
        {
            if (this.m_oAutorizacao.registaUtilizadorComPapel(oCliente.getNome(),oCliente.getEmail(), strPwd, Constants.PAPEL_CLIENTE))
                return addCliente(oCliente);
        }
        return false;
    }

    private boolean addCliente(Client oCliente)
    {
        return m_lstClientes.add(oCliente);
    }
    
    public boolean validaCliente(Client oCliente,String strPwd)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        if (this.m_oAutorizacao.existeUtilizador(oCliente.getEmail()))
            bRet = false;
        if (strPwd == null)
            bRet = false;
        if (strPwd.isEmpty())
            bRet = false;
        //
      
        return bRet;
    }

    // </editor-fold>
    
    
    // Serviços
    
    // <editor-fold defaultstate="collapsed">
    
    public Service getServicoById(String strId)
    {
        for(Service serv : this.m_lstServicos)
        {
            if (serv.hasId(strId))
            {
                return serv;
            }
        }
        
        return null;
    }

    public Service novoServico(String strId, String strDescricaoBreve, String strDescricaoCompleta, double dCustoHora, Category oCategoria)
    {
        return new Service(strId, strDescricaoBreve,strDescricaoCompleta,dCustoHora,oCategoria);
    }

    public boolean registaServico(Service oServico)
    {
        if (this.validaServico(oServico))
        {
            return addServico(oServico);
        }
        return false;
    }

    private boolean addServico(Service oServico)
    {
        return m_lstServicos.add(oServico);
    }
    
    public boolean validaServico(Service oServico)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        
        //
      
        return bRet;
    }
    // </editor-fold>
    
    // Categorias 
    // <editor-fold defaultstate="collapsed">
            
    public Category getCategoriaById(String strId)
    {
        for(Category cat : this.m_lstCategorias)
        {
            if (cat.hasId(strId))
            {
                return cat;
            }
        }
        
        return null;
    }

    public Category novaCategoria(String strCodigo, String strDescricao)
    {
        return new Category(strCodigo, strDescricao);
    }

    public boolean registaCategoria(Category oCategoria)
    {
        if (this.validaCategoria(oCategoria))
        {
            return addCategoria(oCategoria);
        }
        return false;
    }

    private boolean addCategoria(Category oCategoria)
    {
        return m_lstCategorias.add(oCategoria);
    }
    
    public boolean validaCategoria(Category oCategoria)
    {
        boolean bRet = true;
        
        // Escrever aqui o código de validação
        
        //
      
        return bRet;
    }
    
    public List<Category> getCategorias()
    {
        List<Category> lc = new ArrayList<>();
        lc.addAll(this.m_lstCategorias);
        return lc;
    }
    
    // </editor-fold>


}
    
    
