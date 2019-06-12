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

public class ServiceDefinitionUI3 implements Initializable {

    private ServiceDefinitionUI serviceDefinitionUI;

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

    public void setServiceDefinitionUI(ServiceDefinitionUI serviceDefinitionUI) {
        this.serviceDefinitionUI = serviceDefinitionUI;
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        serviceDefinitionUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        if (serviceDefinitionUI.getController().validate()
                && serviceDefinitionUI.getController().registerService()) {
            UIUtils.createAlert("New Service registered successfully!", "", Alert.AlertType.INFORMATION);
        } else {
            UIUtils.createAlert("An error has ocurred during validation.", "Fatal error:", Alert.AlertType.ERROR);
        }
        serviceDefinitionUI.getMainMenu().backToMainMenu();
    }

    void displayText() {
        String text = serviceDefinitionUI.getController().getService().toString();
        confirmTxt.setText(text);
    }

}
