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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.utils.UIUtils;

public class ServiceDefinitionUI1 implements Initializable {

    private ServiceDefinitionUI serviceDefinitionUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ComboBox<ServiceType> serviceTypeComboBox;
    @FXML
    private TextField idTxt;
    @FXML
    private TextField briefDescTxt;
    @FXML
    private TextArea completeDescTxt;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private TextField costTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idTxt.setDisable(true);
        briefDescTxt.setDisable(true);
        completeDescTxt.setDisable(true);
        continueBtn.setDisable(true);
        categoryComboBox.setDisable(true);
        costTxt.setDisable(true);
    }

    public void setServiceDefinitionUI(ServiceDefinitionUI serviceDefinitionUI) {
        this.serviceDefinitionUI = serviceDefinitionUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        serviceDefinitionUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String id = null;
        String briefDesc = null;
        String completeDesc = null;
        double costHour = 0;
        String catId = null;
        try {
            id = idTxt.getText();
            briefDesc = briefDescTxt.getText();
            completeDesc = completeDescTxt.getText();
            catId = categoryComboBox.getValue().getCode();
            costHour = Double.parseDouble(costTxt.getText());
        } catch (Exception e) {
        }
        try {
            boolean batrbs = serviceDefinitionUI.getController().newService(
                    id, briefDesc, completeDesc, costHour, catId);
            if (batrbs) {
                serviceDefinitionUI.toServiceDefinitionScene2(this);
            } else {
                serviceDefinitionUI.toServiceDefinitionScene3();
            }
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleServiceTypeComboBox(ActionEvent event) {
        String typeId = serviceTypeComboBox.getValue().getId();
        if (serviceDefinitionUI.getController().setServiceType(typeId)) {
            idTxt.setDisable(false);
            briefDescTxt.setDisable(false);
            completeDescTxt.setDisable(false);
            continueBtn.setDisable(false);
            costTxt.setDisable(false);
            serviceTypeComboBox.setDisable(true);
            populateCategoryComboBox();
        } else {
            UIUtils.createAlert("Service Type is invalid", "Fatal error:", Alert.AlertType.ERROR);
            serviceDefinitionUI.getMainMenu().backToMainMenu();
        }

    }

    /**
     * Populates service combobox. if error is thrown catches it and goes back
     * to main menu
     */
    void populateServiceTypeComboBox() {

        List<ServiceType> types = serviceDefinitionUI.getController().getServiceTypes();
        serviceTypeComboBox.getItems().addAll(types);
        if (types.isEmpty()) {
            UIUtils.createAlert("It was not possible to create a new Service", "No Service types found.", Alert.AlertType.ERROR);
            serviceDefinitionUI.getMainMenu().backToMainMenu();
        }
    }

    private void populateCategoryComboBox() {
        List<Category> categories = serviceDefinitionUI.getController().getCategories();
        if (categories != null || categories.isEmpty()) {
            categoryComboBox.getItems().addAll(categories);
            categoryComboBox.setDisable(false);
        } else {
            UIUtils.createAlert("It is impossible to complete the Service specification.", "No categories found:", Alert.AlertType.ERROR);
            serviceDefinitionUI.getMainMenu().backToMainMenu();
        }

    }

}
