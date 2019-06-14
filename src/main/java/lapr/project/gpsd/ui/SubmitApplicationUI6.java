package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import lapr.project.utils.UIUtils;

public class SubmitApplicationUI6 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

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

    public void setSubmitApplicationUI(SubmitApplicationUI submitApplicationUI) {
        this.submitApplicationUI = submitApplicationUI;
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        try {
            submitApplicationUI.getController().validateApplication();
            if (submitApplicationUI.getController().registerApplication()) {
                UIUtils.createAlertWait("Application successful!", "", Alert.AlertType.INFORMATION);
                submitApplicationUI.getMainApp().toMainScene();
            } else {
                UIUtils.createAlertWait("Problems occurred during submission of your application. Aborting operation", "Error:", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm submit application");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Proceed anyway?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                if (submitApplicationUI.getController().registerApplication()) {
                    UIUtils.createAlertWait("Application successful!", "", Alert.AlertType.INFORMATION);
                    submitApplicationUI.getMainApp().toMainScene();
                } else {
                    UIUtils.createAlertWait("Problems occurred during submission of your application. Aborting operation", "Error:", Alert.AlertType.ERROR);
                }
            } else {
                submitApplicationUI.toSubmitApplicationScene3();
                UIUtils.createAlertWait("Please insert the missing data.", "", Alert.AlertType.INFORMATION);
            }
        }
    }

    void showApplication() {
        String text = submitApplicationUI.getController().getApplication().toString();
        confirmTxt.setText(text);
    }

}
