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
import javafx.scene.control.TextArea;
import lapr.project.gpsd.model.Client;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class RegisterClientUI3 implements Initializable {

    private RegisterClientUI registerClientUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private TextArea confirmTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setRegisterClientUI(RegisterClientUI registerClientUI) {
        this.registerClientUI = registerClientUI;
    }

    public void showClient() {
        Client cli = this.registerClientUI.getController().getClient();
        confirmTxt.setText(cli.toString());
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        registerClientUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        this.registerClientUI.getController().registerCliente();
        registerClientUI.getMainApp().toMainScene();
    }
}
