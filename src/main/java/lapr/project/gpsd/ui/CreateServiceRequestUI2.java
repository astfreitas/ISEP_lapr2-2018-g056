package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.gpsd.model.ServiceRequestDescription;

public class CreateServiceRequestUI2 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;
    
    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private Button addServiceBtn;
    @FXML
    private TableView<ServiceRequestDescription> addServiceTbl;
    @FXML
    private TableColumn<ServiceRequestDescription, String> categoryCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> serviceCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> durationCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> costCol;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.createServiceRequestUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        this.createServiceRequestUI.toCreateServiceRequestControllerScene3();
    }

    @FXML
    private void handleAddServiceBtn(ActionEvent event) {
        
    }
    
    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }
    
    public void setupServiceRequestDescriptionTable() {
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("propertyCategory"));
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("propertyDuration"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("propertyCost"));
    }

}
