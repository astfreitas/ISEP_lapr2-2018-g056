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
import lapr.project.gpsd.model.SPApplication;
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

    public TextField getNameTxt() {
        return nameTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        registerServiceProviderUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String nif = nifTxt.getText();
        SPApplication application = this.registerServiceProviderUI.getController().getApplicationData(nif);
        try {
            if (!application.equals(null)) {
                String name = application.getName();
                Address address = application.getAddress();
                // confirmar como permitir editar estes campos !!!
                this.registerServiceProviderUI.getController().newServiceProvider(name, address);
                // avançar para a cena 3
            } else {
                UIUtils.createAlert("Application not found!", "", Alert.AlertType.WARNING);
            }
        } catch (IllegalArgumentException e) {
            UIUtils.createAlert("All the fields must be filled", "Missing data", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void handleEditBtn(ActionEvent event) {
        this.registerServiceProviderUI.toRegisterServiceProviderScene2();
    }

}
