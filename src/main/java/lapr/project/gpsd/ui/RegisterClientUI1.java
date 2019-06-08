package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

public class RegisterClientUI1 implements Initializable {

    private RegisterClientUI registerClientUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField telephoneTxt;
    @FXML
    private PasswordField pwdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setRegisterClientUI(RegisterClientUI registerClientUI) {
        this.registerClientUI = registerClientUI;
    }

    public TextField getNameTxt() {
        return nameTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        registerClientUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String name = nameTxt.getText();
        String nif = nifTxt.getText();
        String telephone = telephoneTxt.getText();
        String email = emailTxt.getText();
        String password = pwdTxt.getText();
        
        try {
            this.registerClientUI.getController().newClient(name, nif, telephone, email, password);
        } catch (IllegalArgumentException e) {
            UIUtils.createAlert("All the fields must be filled", "Missing data", Alert.AlertType.ERROR);
        }    
        this.registerClientUI.toRegisterClientScene2();
    }

}
