package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lapr.project.utils.UIUtils;

public class SubmitApplicationUI5 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button completeBtn;
    @FXML
    private ComboBox<?> categoryComboBox;
    @FXML
    private Button addCatBtn;

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
    private void handleCancelButton(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleCompleteBtn(ActionEvent event) {
        try {
            // get texts
        } catch (NullPointerException e) {
        }
        try {
            // create objects
            this.submitApplicationUI.toSubmitApplicationScene6();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "No dice bro", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void handleCategoryComboBox(ActionEvent event) {
    }

    @FXML
    private void handleAddCatBtn(ActionEvent event) {
    }

}
