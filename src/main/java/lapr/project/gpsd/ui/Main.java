/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.gpsd.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import lapr.project.gpsd.ui.console.MenuUI;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Main extends Application
{
    public static void main(String[] args)
    {
        try
        {System.out.println("Hello World");
            MenuUI uiMenu = new MenuUI();

            uiMenu.run();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
