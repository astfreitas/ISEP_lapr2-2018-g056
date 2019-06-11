/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author Josué Mota
 */
public class CreateServiceRequestUI5 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;
    
    @FXML
    private Button cancelBtn;
    @FXML
    private ListView<SchedulePreference> scheduleLst;
    @FXML
    private Button confirmBtn;
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
    @FXML
    private Label travelExpensesLbl;
    @FXML
    private Label totalCostLbl;

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
    private void handleConfirmBtn(ActionEvent event) {
        int serviceRequestNumber = this.createServiceRequestUI.getController().registerRequest();
        if(serviceRequestNumber>0) {
            UIUtils.createAlert("Service Request Created with success", "Service order was successfully created, register number : " + serviceRequestNumber, Alert.AlertType.INFORMATION);
        } else {
            UIUtils.createAlert("Error occured during the export of Service Orders", "Create New Service Order Error", Alert.AlertType.ERROR);
        }
        
    }

    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }
    
    
    public void setupConfirmationScene() {
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("propertyCategory"));
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("propertyDuration"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("propertyCost"));
        ServiceRequest so = this.createServiceRequestUI.getController().validate();
        addServiceTbl.getItems().clear();
        addServiceTbl.getItems().addAll(so.getServiceRequestDescriptions());        
        scheduleLst.getItems().clear();
        scheduleLst.getItems().addAll(so.getSchedulePreferences());
        double travelExpenses = this.createServiceRequestUI.getController().getTravelExpenses();
        double total = this.createServiceRequestUI.getController().getTotalCost();
        travelExpensesLbl.setText(String.format("%.1f €", travelExpenses));
        totalCostLbl.setText(String.format("%.1f €", total));
    }
    
}
