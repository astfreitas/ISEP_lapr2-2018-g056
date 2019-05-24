/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.ui;

import lapr.project.ui.console.MenuUI;

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
          
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
