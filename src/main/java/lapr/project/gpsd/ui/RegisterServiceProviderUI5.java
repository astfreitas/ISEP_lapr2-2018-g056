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
import javafx.stage.Stage;
import lapr.project.gpsd.model.Category;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI5 implements Initializable {

    RegisterServiceProviderUI registerServiceProviderUI;
    RegisterServiceProviderUI2 parentUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private ComboBox<Category> categoryComboBox;

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

    public void setParentUI(RegisterServiceProviderUI2 parentUI) {
        this.parentUI = parentUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Stage) cancelBtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        String catId = categoryComboBox.getValue().getCode();
        if (registerServiceProviderUI.getController().addCategory(catId)) {
            ((Stage) cancelBtn.getScene().getWindow()).close();
            parentUI.updateList();
        } else {
            UIUtils.createAlert("Category already added.", "Error:", Alert.AlertType.ERROR);
        }
    }

    void populateComboBox() {
        List<Category> categories = registerServiceProviderUI.getController().getCategories();
        categoryComboBox.getItems().addAll(categories);
        if (categories.isEmpty()) {
            UIUtils.createAlert("Unable to register Service Provider.", "No categories found.", Alert.AlertType.ERROR);
            ((Stage) cancelBtn.getScene().getWindow()).close();
            registerServiceProviderUI.getMainMenu().backToMainMenu();
        }
    }

}
