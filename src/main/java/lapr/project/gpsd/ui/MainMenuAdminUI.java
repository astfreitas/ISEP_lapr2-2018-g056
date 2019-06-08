/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class MainMenuAdminUI implements Initializable {
    
    private Main mainApp;
    @FXML
    private MenuItem specCatBtn;
    @FXML
    private MenuItem specServBtn;
    @FXML
    private MenuItem specGABtn;
    @FXML
    private MenuItem aboutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    @FXML
    private void handleSpecCatBtn(ActionEvent event) {
    }

    @FXML
    private void handleSpecServBtn(ActionEvent event) {
    }

    @FXML
    private void handleSpecGABtn(ActionEvent event) {
    }

    @FXML
    private void handleAboutBtn(ActionEvent event) {
    }
}
