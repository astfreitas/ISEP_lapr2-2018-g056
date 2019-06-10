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
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
        submitApplicationUI.getMainApp().toMainScene();
    }

    void showApplication() {
        String text = submitApplicationUI.getController().getApplication().toString();
        confirmTxt.setText(text);
    }

}
