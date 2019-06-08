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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class LoginScreenUI implements Initializable {
    
    private Main mainApp;

    @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField pwdTxt;
    @FXML
    private Button LoginBtn;
    @FXML
    private Button clientRegisterBtn;
    @FXML
    private Button spApplicationBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLoginButton(ActionEvent event) {
    }

    @FXML
    private void handleClientRegisterButton(ActionEvent event) {
        RegisterClientUI registerEmployeesUI = new RegisterClientUI(this.mainApp);
        registerEmployeesUI.toRegisterClientScene1();
    }

    @FXML
    private void handleApplyForSPBtn(ActionEvent event) {
    }
    
}
