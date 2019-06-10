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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private ListView<?> scheduleLst;
    @FXML
    private Button confirmBtn;
    @FXML
    private TableView<?> addServiceTbl;
    @FXML
    private TableColumn<?, ?> categoryCol;
    @FXML
    private TableColumn<?, ?> serviceCol;
    @FXML
    private TableColumn<?, ?> durationCol;
    @FXML
    private TableColumn<?, ?> costCol;
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
        
    }

    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }
    
}
