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
public class RegisterServiceProviderUI2 implements Initializable {

    private RegisterServiceProviderUI registerServiceProviderUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField postalCodeTxt;
    @FXML
    private TextField localTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setRegisterServiceProviderUI(RegisterServiceProviderUI registerServiceProviderUI) {
        this.registerServiceProviderUI = registerServiceProviderUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
    }

}