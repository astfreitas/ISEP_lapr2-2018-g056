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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author mdias
 */
public class RegisterServiceProviderUI2 implements Initializable {

    private RegisterServiceProviderUI registerServiceProviderUI;
    private RegisterServiceProviderUI1 parentUI;

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

    public void setParentUI(RegisterServiceProviderUI1 parentUI) {
        this.parentUI = parentUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String address = null;
        String postalCode = null;
        String local = null;
        try {
            address = addressTxt.getText();
            postalCode = postalCodeTxt.getText();
            local = localTxt.getText();
        } catch (NullPointerException e) {
        }
        try {
            registerServiceProviderUI.getController().newAddress(local, postalCode, address);
            parentUI.updateAddress();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

}
