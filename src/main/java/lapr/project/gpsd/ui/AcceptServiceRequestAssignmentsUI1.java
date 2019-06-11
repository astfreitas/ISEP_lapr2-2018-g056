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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.gpsd.model.ServiceRequest;
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
    private ListView<ServiceAssignment> assignmentDetailsLstView;
    @FXML
    private Button checkAssignmentDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {

    }

    @FXML
    private void handleRejectBtn(ActionEvent event) {
        if (assignmentDetailsLstView.getItems().size() > 0) {
            this.acceptServiceRequestAssignmentsUI.getController().rejectServiceAssignment(assignmentDetailsLstView.getItems());
            UIUtils.createAlert("Service Assignments were successfully rejected", "Reject Service Assignment", Alert.AlertType.INFORMATION);
        } else {
            UIUtils.createAlert("No Service Assignments Selected", "Reject Service Assignment Error", Alert.AlertType.ERROR);
        }
        setupAcceptServiceRequestAssignmentScene();
        updateAssignmentList();
    }

    @FXML
    private void handleAcceptBtn(ActionEvent event) {
        if (assignmentDetailsLstView.getItems().size() > 0) {
            List<Integer> serviceNumbers = this.acceptServiceRequestAssignmentsUI.getController().acceptServiceAssignment(assignmentDetailsLstView.getItems());
            String serviceNumbersTxt = "\n The following Service Order Numbers Were generated\n";
            for(Integer snumber : serviceNumbers) {
                serviceNumbersTxt += "Order nr : " + snumber + " \n";
            }
            UIUtils.createAlert("Service Assignments were successfully accepted"+serviceNumbersTxt, "Accept Service Assignment", Alert.AlertType.INFORMATION);
        } else {
            UIUtils.createAlert("No Service Assignments Selected", "Accept Service Assignment Error", Alert.AlertType.ERROR);
        }
        setupAcceptServiceRequestAssignmentScene();
        updateAssignmentList();
    }

    public void setAcceptServiceRequestUI(AcceptServiceRequestAssignmentsUI acceptServiceRequestAssignmentsUI) {
        this.acceptServiceRequestAssignmentsUI = acceptServiceRequestAssignmentsUI;
    }

    public void setupAcceptServiceRequestAssignmentScene() {
        List<Integer> servicesFullyAssigned = this.acceptServiceRequestAssignmentsUI.getController().checkAssignedServiceRequests();
        serviceRequestComboBox.getItems().clear();
        serviceRequestComboBox.getItems().addAll(servicesFullyAssigned);
        serviceRequestComboBox.getItems().addAll(servicesFullyAssigned);
        if (serviceRequestComboBox.getItems().size() > 0) {
            serviceRequestComboBox.getSelectionModel().selectFirst();
            //check first assignment by default.
            updateAssignmentList();
        }
    }

    public void updateAssignmentList() {
        assignmentDetailsLstView.getItems().clear();
        if (!serviceRequestComboBox.getSelectionModel().isEmpty()) {
            int serviceRequestID = serviceRequestComboBox.getSelectionModel().getSelectedItem();
            List<ServiceAssignment> serviceAssignmentList = this.acceptServiceRequestAssignmentsUI.getController().checkServiceAssignments(serviceRequestID);
            assignmentDetailsLstView.getItems().addAll(serviceAssignmentList);
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

}
