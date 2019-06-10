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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mdias
 */
public class RegisterServiceProviderUI6 implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField telephoneTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
    }
    
}
