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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import javafx.util.StringConverter;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.utils.Constants;
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
    private TextArea descriptionTextArea;
    @FXML
    private ComboBox<String> hourComboBox;
    @FXML
    private ComboBox<String> minuteComboBox;
    @FXML
    private ComboBox<Service> serviceComboBox;
    @FXML
    private Label servDescLbl;
    
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
        categoryComboBox.setCellFactory(new Callback<ListView<Category>,ListCell<Category>>(){
            @Override
            public ListCell<Category> call(ListView<Category> l){
                return new ListCell<Category>(){
                    @Override
                    protected void updateItem(Category cat, boolean empty) {
                        super.updateItem(cat, empty);
                        if (cat == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(cat.getDescription());
                        }
                    }
                } ;
            }
        });
        //selected value showed in combo box
        categoryComboBox.setConverter(new StringConverter<Category>() {
              @Override
              public String toString(Category cat) {
                if (cat == null){
                  return null;
                } else {
                  return cat.getDescription();
                }
              }
            @Override
            public Category fromString(String userId) {
                return null;
            }
        });
        
        serviceComboBox.setCellFactory(new Callback<ListView<Service>,ListCell<Service>>(){
            @Override
            public ListCell<Service> call(ListView<Service> l){
                return new ListCell<Service>(){
                    @Override
                    protected void updateItem(Service serv, boolean empty) {
                        super.updateItem(serv, empty);
                        if (serv == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(serv.getBriefDescription());
                        }
                    }
                } ;
            }
        });
        //selected value showed in combo box
        serviceComboBox.setConverter(new StringConverter<Service>() {
              @Override
              public String toString(Service service) {
                if (service == null){
                  return null;
                } else {
                  return service.getBriefDescription();
                }
              }
            @Override
            public Service fromString(String string) {
                return null;
            }
        });
        
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

    /**
     * Method refreshes the ServiceList by getting the selected category from
     * the combo box and getting the service list from Controller
     */
    private void refreshServiceList() {
        serviceComboBox.getItems().clear();
        Category cat = categoryComboBox.getSelectionModel().getSelectedItem();
        if (cat != null) {
            List<Service> services = this.createServiceRequestUI.getController().getServicesFromCategory(cat.getCode());
            serviceComboBox.getItems().addAll(services);
        }
    }

    private void addServiceRequestDescription() {
        if (validate()) {
            Service selectedService = serviceComboBox.getSelectionModel().getSelectedItem();
            this.createServiceRequestUI.getController().addServiceRequestDescription(selectedService.getId(), descriptionTextArea.getText(), getSelectedDuration());
        }
    }

    private int getSelectedDuration() {
        int hour = Integer.parseInt(hourComboBox.getSelectionModel().getSelectedItem());
        int min = Integer.parseInt(minuteComboBox.getSelectionModel().getSelectedItem());
        return hour * 60 + min;
    }

    private boolean validate() {
        if (serviceComboBox.getSelectionModel().isEmpty()) {
            UIUtils.createAlert("You need to select a service from the list", "Add Service Error", Alert.AlertType.ERROR);
            return false;
        } else if (getSelectedDuration() <= 0 && !serviceHasDeterminedDuration()) {
            UIUtils.createAlert("Duration of the service must be more then 0 minutes", "Add Service Error", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    /**
     * Handles the evento created when the Category ComboBox is clicked or
     * changed. This initiates the RefreshServiceList method.
     *
     * @param event comboBox selection action
     */
    @FXML
    private void handleCategoryComBox(ActionEvent event) {
        refreshServiceList();
        servDescLbl.setText("");
    }

    @FXML
    private void handleServiceComboBox(ActionEvent event) {
        if(serviceHasDeterminedDuration()) {
            hourComboBox.setDisable(true);
            minuteComboBox.setDisable(true);
        } else {
            hourComboBox.setDisable(false);
            minuteComboBox.setDisable(false);
        }
        if(!serviceComboBox.getSelectionModel().isEmpty()) {
            Service service = serviceComboBox.getSelectionModel().getSelectedItem();
            servDescLbl.setText(service.getFullDescription());
        }
    }
    
    private boolean serviceHasDeterminedDuration() {
        if(!serviceComboBox.getSelectionModel().isEmpty()) {
            Service s = serviceComboBox.getSelectionModel().getSelectedItem();
            return s.hasAttribute(Constants.OTHER_SERV_ATRIB_PREDETERMINED_DURATION);
        }
        return false;
    }

}
