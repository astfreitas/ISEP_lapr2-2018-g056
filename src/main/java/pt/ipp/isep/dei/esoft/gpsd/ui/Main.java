/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipp.isep.dei.esoft.gpsd.ui;

import pt.ipp.isep.dei.esoft.gpsd.ui.console.MenuUI;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            MenuUI uiMenu = new MenuUI();

            uiMenu.run();
            System.out.println("teste");
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
