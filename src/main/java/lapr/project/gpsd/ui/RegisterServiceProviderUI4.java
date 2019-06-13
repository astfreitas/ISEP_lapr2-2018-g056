package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI4 implements Initializable {

    RegisterServiceProviderUI registerServiceProviderUI;

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
        // TODO
    }

    public void setRegisterServiceProviderUI(RegisterServiceProviderUI registerServiceProviderUI) {
        this.registerServiceProviderUI = registerServiceProviderUI;
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        registerServiceProviderUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        try {
            // validate + register
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
        registerServiceProviderUI.getMainMenu().backToMainMenu();
    }

    void displayText() {
        String text = registerServiceProviderUI.getController().getServiceProvider().toString();
        confirmTxt.setText(text);
    }

}
