package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lapr.project.authentication.model.UserRole;
import lapr.project.gpsd.controller.ApplicationGPSD;
import lapr.project.gpsd.utils.Constants;
import lapr.project.utils.UIUtils;

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
        emailTxt.requestFocus();
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLoginButton(ActionEvent event) throws Exception {
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        String email = emailTxt.getText();
        String pwd = pwdTxt.getText();
        if (!app.doLogin(email, pwd)) {
            UIUtils.createAlert("", "The username and password that you entered did not match our records. Please double-check and try again.", Alert.AlertType.ERROR);
            emailTxt.clear();
            pwdTxt.clear();
            emailTxt.requestFocus();
        } else {
            List<UserRole> roleList = app.getCurrentSession().getUserRoles();
            String role = roleList.get(0).getRole();
            MainMenuUI mainMenu = new MainMenuUI(this.mainApp, this.mainApp.getStage());
            if (role.equals(Constants.ROLE_CLIENT)) {
                mainMenu.toMainMenuClient();
            } else if (role.equals(Constants.ROLE_ADMINISTRATIVE)) {
                mainMenu.toMainMenuAdmin();
            } else if (role.equals(Constants.ROLE_HRO)) {
                mainMenu.toMainMenuHRO();
            }
        }
    }

    @FXML
    private void handleClientRegisterButton(ActionEvent event) {
        RegisterClientUI registerEmployeesUI = new RegisterClientUI(this.mainApp);
        registerEmployeesUI.toRegisterClientScene1();
    }

    @FXML
    private void handleApplyForSPBtn(ActionEvent event) {
    }

    @FXML
    private void openAbout(MouseEvent event) {
        UIUtils.about();
    }

    @FXML
    private void onEnter(ActionEvent event) {
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        String email = emailTxt.getText();
        String pwd = pwdTxt.getText();
        if (!app.doLogin(email, pwd)) {
            UIUtils.createAlert("", "The username and password that you entered did not match our records. Please double-check and try again.", Alert.AlertType.ERROR);
            emailTxt.clear();
            pwdTxt.clear();
            emailTxt.requestFocus();
        } else {
            List<UserRole> roleList = app.getCurrentSession().getUserRoles();
            String role = roleList.get(0).getRole();
            MainMenuUI mainMenu = new MainMenuUI(this.mainApp, this.mainApp.getStage());
            if (role.equals(Constants.ROLE_CLIENT)) {
                mainMenu.toMainMenuClient();
            } else if (role.equals(Constants.ROLE_ADMINISTRATIVE)) {
                mainMenu.toMainMenuAdmin();
            } else if (role.equals(Constants.ROLE_HRO)) {
                mainMenu.toMainMenuHRO();
            }
        }
    }

}
