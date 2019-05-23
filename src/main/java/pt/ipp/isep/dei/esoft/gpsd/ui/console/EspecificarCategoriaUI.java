/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.gpsd.ui.console;

import pt.ipp.isep.dei.esoft.gpsd.controller.EspecificarCategoriaController;
import pt.ipp.isep.dei.esoft.gpsd.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarCategoriaUI
{
    private EspecificarCategoriaController m_controller;
    public EspecificarCategoriaUI()
    {
        m_controller = new EspecificarCategoriaController();
    }

    public void run()
    {
        System.out.println("\nEspecificar Categoria:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCategoria()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    
    private boolean introduzDados() {
        String strCodigo = Utils.readLineFromConsole("Código: ");
        String strDescricao = Utils.readLineFromConsole("Descrição: ");
        
        return m_controller.novaCategoria(strCodigo, strDescricao);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\nCategoria:\n" + m_controller.getCategoriaString());
    }
}
