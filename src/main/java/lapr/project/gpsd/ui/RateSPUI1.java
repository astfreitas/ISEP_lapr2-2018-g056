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
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.ServiceOrder;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class RateSPUI1 implements Initializable {
    
    private RateSPUI rateSPUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ListView<ServiceOrder> servOrderList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.rateSPUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        this.rateSPUI.getController().setServOrder(this.servOrderList.getSelectionModel().getSelectedItem());
        this.rateSPUI.getController().setServiceProvider();
        this.rateSPUI.toSpecifyCategoryScene2();
    }
    
    public void populateServOrderList(){
        this.servOrderList.getItems().addAll(this.rateSPUI.getController().getClientServices());
    }

    void setRateSPUI(RateSPUI rateSPUI) {
        this.rateSPUI = rateSPUI;
    }

}
