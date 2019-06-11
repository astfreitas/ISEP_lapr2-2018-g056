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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lapr.project.gpsd.model.Address;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author mdias
 */
public class RegisterServiceProviderUI1 implements Initializable {

    private RegisterServiceProviderUI registerServiceProviderUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private Button editBtn;
    @FXML
    private Button getAppBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        continueBtn.setDisable(true);
        editBtn.setDisable(true);
    }

    public void setRegisterServiceProviderUI(RegisterServiceProviderUI registerServiceProviderUI) {
        this.registerServiceProviderUI = registerServiceProviderUI;
    }

    public TextField getNameTxt() {
        return nameTxt;
    }

    @FXML
    private void handleGetAppBtn(ActionEvent event) {
        String nif = null;
        try {
            nif = nifTxt.getText();
        } catch (Exception e) {
        }
        if (registerServiceProviderUI.getController().getApplicationData(nif)) {
            nameTxt.setText(registerServiceProviderUI.getController().getName());
            addressTxt.setText(registerServiceProviderUI.getController().getAddress().toString());
            editBtn.setDisable(false);
            continueBtn.setDisable(false);
            getAppBtn.setDisable(true);
            nifTxt.setDisable(true);
        } else {
            UIUtils.createAlert("Service Provider's application not found!", "Incorrect NIF", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void handleEditBtn(ActionEvent event) {
        registerServiceProviderUI.toRegisterServiceProviderScene2(this);
        addressTxt.setDisable(true);
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {

        String name = null;

        try {
            name = nameTxt.getText();
        } catch (NullPointerException e) {
        }
        try {
            Address address = this.registerServiceProviderUI.getController().getAddress();
            this.registerServiceProviderUI.getController().newServiceProvider(name, address);
            this.registerServiceProviderUI.toRegisterServiceProviderScene3();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "No dice bro:", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        registerServiceProviderUI.getMainApp().toMainScene();
    }

    void updateAddress() {
        addressTxt.setText(registerServiceProviderUI.getController().getAddress().toString());
    }

}
