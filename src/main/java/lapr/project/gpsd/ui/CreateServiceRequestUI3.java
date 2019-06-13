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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;
import lapr.project.utils.UIUtils;

public class CreateServiceRequestUI3 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button addServiceBtn;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private ListView<Service> serviceListView;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ComboBox<String> hourComboBox;
    @FXML
    private ComboBox<String> minuteComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.createServiceRequestUI.toCreateServiceRequestControllerScene2();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        if (validate()) {
            addServiceRequestDescription();
            this.createServiceRequestUI.toCreateServiceRequestControllerScene2();
        }
    }

    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }

    public void setupServiceDescriptionScene() {
        List<Category> categories = this.createServiceRequestUI.getController().getCategories();
        categoryComboBox.getItems().clear();
        categoryComboBox.getItems().addAll(categories);
        categoryComboBox.getSelectionModel().selectFirst();
        refreshServiceList();
        for (int i = 0; i < 24; i++) {
            String hour = "";
            if (i < 10) {
                hour = "0";
            }
            hourComboBox.getItems().add(hour + i);
        }
        hourComboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < 60; i += 30) {
            String min = "";
            if (i < 10) {
                min = "0";
            }
            minuteComboBox.getItems().add(min + i);
        }
        minuteComboBox.getSelectionModel().selectFirst();
    }

    private void refreshServiceList() {
        serviceListView.getItems().clear();
        Category cat = categoryComboBox.getSelectionModel().getSelectedItem();
        if (cat != null) {
            List<Service> services = this.createServiceRequestUI.getController().getServicesFromCategory(cat.getCode());
            serviceListView.getItems().addAll(services);
        }
    }

    private void addServiceRequestDescription() {
        if (validate()) {
            Service selectedService = serviceListView.getSelectionModel().getSelectedItem();
            this.createServiceRequestUI.getController().addServiceRequestDescription(selectedService.getId(), descriptionTextArea.getText(), getSelectedDuration());
        }
    }
    
    private int getSelectedDuration() {
        int hour = Integer.parseInt(hourComboBox.getSelectionModel().getSelectedItem());
        int min = Integer.parseInt(minuteComboBox.getSelectionModel().getSelectedItem());        
        return hour * 60 + min;
    }
    
    private boolean validate() {
        if(serviceListView.getSelectionModel().isEmpty()) {
            UIUtils.createAlert("You need to select a service from the list", "Add Service Error", Alert.AlertType.ERROR);
            return false;
        } else if(getSelectedDuration() <= 0) {
            UIUtils.createAlert("Duration of the service must be more then 0 minutes", "Add Service Error", Alert.AlertType.ERROR);
            return false;
        } 
        return true;
    }
    
}
