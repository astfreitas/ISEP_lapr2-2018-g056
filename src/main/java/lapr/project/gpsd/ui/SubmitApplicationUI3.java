package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

public class SubmitApplicationUI3 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button addQualificationBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField courseTxt;
    @FXML
    private ComboBox<String> levelComboBox;
    @FXML
    private ComboBox<Double> gradeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] levels = {"High school", "Undergraduate", "Graduate", "Doctor"};
        levelComboBox.getItems().addAll(levels);
        for (int i = 1; i < 20; i++) {
            gradeComboBox.getItems().add((double) i);
        }

    }

    public void setSubmitApplicationUI(SubmitApplicationUI submitApplicationUI) {
        this.submitApplicationUI = submitApplicationUI;
    }

    public TextField getCourseTxt() {
        return courseTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleAddQualificationBtn(ActionEvent event) {
        String course = null;
        String level = null;
        double grade = 0;
        try {
            course = courseTxt.getText();
            level = levelComboBox.getValue();
            grade = gradeComboBox.getValue();
        } catch (Exception e) {
        }
        try {
            submitApplicationUI.getController().addAcademicCompetence(course, level, grade);
            UIUtils.createAlert("Academic competence added successfuly.", "", Alert.AlertType.INFORMATION);
            submitApplicationUI.toSubmitApplicationScene3();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        submitApplicationUI.toSubmitApplicationScene4();
    }

}
