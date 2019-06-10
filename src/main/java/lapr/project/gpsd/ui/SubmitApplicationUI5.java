package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lapr.project.gpsd.model.Category;
import lapr.project.utils.UIUtils;

public class SubmitApplicationUI5 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button completeBtn;
    @FXML
    private ComboBox<Category> categoryComboBox;
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
        submitApplicationUI.toSubmitApplicationScene6();
    }

    @FXML
    private void handleCategoryComboBox(ActionEvent event) {
    }

    @FXML
    private void handleAddCatBtn(ActionEvent event) {
        try {
            submitApplicationUI.getController().addCategory(categoryComboBox.getValue().toString());
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
        submitApplicationUI.toSubmitApplicationScene5();
    }

    void populateCategory() {
        try {
            List<Category> categories = submitApplicationUI.getController().getCategories();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
            submitApplicationUI.toSubmitApplicationScene6();
        }
    }

}
