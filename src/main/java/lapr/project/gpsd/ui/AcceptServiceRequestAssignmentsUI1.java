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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.utils.UIUtils;

public class AcceptServiceRequestAssignmentsUI1 implements Initializable {

    private AcceptServiceRequestAssignmentsUI acceptServiceRequestAssignmentsUI;
    
    @FXML
    private Button cancelBtn;
    @FXML
    private Button rejectBtn;
    @FXML
    private Button acceptBtn;
    @FXML
    private ComboBox<Integer> serviceRequestComboBox;
    @FXML
    private Button checkAssignmentDetails;
    @FXML
    private TableView<ServiceAssignment> serviceAssignmentTbl;
    @FXML
    private TableColumn<ServiceAssignment, String> catCol;
    @FXML
    private TableColumn<ServiceAssignment, String> serviceCol;
    @FXML
    private TableColumn<ServiceAssignment, String> serviceProviderCol;
    @FXML
    private TableColumn<ServiceAssignment, String> meanRatingCol;
    @FXML
    private TableColumn<ServiceAssignment, String> classificationCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.acceptServiceRequestAssignmentsUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleRejectBtn(ActionEvent event) {
        if (serviceAssignmentTbl.getItems().size() > 0) {
            this.acceptServiceRequestAssignmentsUI.getController().rejectServiceAssignment();
            UIUtils.createAlertWait("Service Assignments were successfully rejected", "Reject Service Assignment", Alert.AlertType.INFORMATION);
        } else {
            UIUtils.createAlert("No Service Assignments Selected", "Reject Service Assignment Error", Alert.AlertType.ERROR);
        }
        if(!updateServiceRequestList()) {
            this.acceptServiceRequestAssignmentsUI.getMainMenu().backToMainMenu();
        }
    }

    @FXML
    private void handleAcceptBtn(ActionEvent event) {
        if (serviceAssignmentTbl.getItems().size() > 0) {
            List<Integer> serviceNumbers = this.acceptServiceRequestAssignmentsUI.getController().acceptServiceAssignment();
            String serviceNumbersTxt = "\n The following Service Order Numbers Were generated\n";
            for(Integer snumber : serviceNumbers) {
                serviceNumbersTxt += "Order nr : " + snumber + " \n";
            }
            if(serviceNumbers.size()>0) {
                UIUtils.createAlertWait("Service Assignments were successfully accepted"+serviceNumbersTxt, "Accept Service Assignment", Alert.AlertType.CONFIRMATION);
            } else {
                UIUtils.createAlert("No Service Orders were generated.", "Accept Service Assignment Error", Alert.AlertType.ERROR);
            }
        } else {
            UIUtils.createAlert("No Service Assignments Selected", "Accept Service Assignment Error", Alert.AlertType.ERROR);
        }
        if(!updateServiceRequestList()) {
            this.acceptServiceRequestAssignmentsUI.getMainMenu().backToMainMenu();
        }
    }
    
    @FXML
    private void handlecheckAssignmentDetailsBtn(ActionEvent event) {
        if (!serviceRequestComboBox.getSelectionModel().isEmpty()) {
            updateAssignmentList();
        } else {
            UIUtils.createAlert("Please select a service number", "List Service Assignment Error", Alert.AlertType.ERROR);
        }
    }
    
    public void setAcceptServiceRequestUI(AcceptServiceRequestAssignmentsUI acceptServiceRequestAssignmentsUI) {
        this.acceptServiceRequestAssignmentsUI = acceptServiceRequestAssignmentsUI;
    }

    public void setupAcceptServiceRequestAssignmentScene() {        
        catCol.setCellValueFactory(new PropertyValueFactory<>("propertyCat"));
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        serviceProviderCol.setCellValueFactory(new PropertyValueFactory<>("propertyServiceProviderName"));
        meanRatingCol.setCellValueFactory(new PropertyValueFactory<>("propertyMeanRating"));
        classificationCol.setCellValueFactory(new PropertyValueFactory<>("propertyClassification"));
        updateServiceRequestList();
    }

    
    public boolean updateServiceRequestList() {
        List<Integer> servicesFullyAssigned = this.acceptServiceRequestAssignmentsUI.getController().checkAssignedServiceRequests();
        serviceRequestComboBox.getItems().clear();
        serviceRequestComboBox.getItems().addAll(servicesFullyAssigned);
        if (serviceRequestComboBox.getItems().size() > 0) {
            serviceRequestComboBox.getSelectionModel().selectFirst();
            updateAssignmentList();
            return true;
        } else {
            return false;
        }
    }
    
    public void updateAssignmentList() {
        serviceAssignmentTbl.getItems().clear();
        if (!serviceRequestComboBox.getSelectionModel().isEmpty()) {
            int serviceRequestID = serviceRequestComboBox.getSelectionModel().getSelectedItem();
            List<ServiceAssignment> serviceAssignmentList = this.acceptServiceRequestAssignmentsUI.getController().checkServiceAssignments(serviceRequestID);
            for(ServiceAssignment serviceAssignment : serviceAssignmentList) {
                serviceAssignmentTbl.getItems().add(serviceAssignment);
            }
        }
    }
}
