package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.gpsd.model.ServiceRequest;

public class AcceptServiceRequestAssignmentsUI1 implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button rejectBtn;
    @FXML
    private Button acceptBtn;
    @FXML
    private ListView<ServiceRequest> serviceRequestLstView;
    @FXML
    private ListView<ServiceAssignment> assignmentLstView;

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
        
    }

    @FXML
    private void handleAcceptBtn(ActionEvent event) {
        
    }
    
}
