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

public class SubmitApplicationUI4 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button addQualificationBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextArea descriptionTxt;

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

    public TextArea getDescriptionTxt() {
        return descriptionTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleAddQualificationBtn(ActionEvent event) {
        String description = null;
        try {
            description = descriptionTxt.getText();
        } catch (Exception e) {
        }
        try {
            submitApplicationUI.getController().addProfessionalCompetence(description);
            submitApplicationUI.toSubmitApplicationScene4();
            UIUtils.createAlert("Professional competence added successfuly.", "", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        submitApplicationUI.toSubmitApplicationScene5();
    }

}
