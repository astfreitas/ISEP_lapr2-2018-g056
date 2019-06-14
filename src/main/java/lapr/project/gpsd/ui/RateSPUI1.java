/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lapr.project.gpsd.controller.RatingServiceProviderController;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.UIUtils;

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
    private ListView<ServiceOrder> serviceList;

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
        if (this.serviceList.getSelectionModel().getSelectedItem() == null) {
            UIUtils.createAlert("Please select one service", "", Alert.AlertType.ERROR);
        } else {
            this.rateSPUI.getController().setServOrder(this.serviceList.getSelectionModel().getSelectedItem());
            this.rateSPUI.getController().setServiceProvider();
            this.rateSPUI.toSpecifyCategoryScene2();
        }
    }

    public void populateServOrderList() {
        RatingServiceProviderController controller = this.rateSPUI.getController();
        ArrayList<ServiceOrder> servOrders = controller.getClientServices();
        this.serviceList.getItems().addAll(servOrders);
    }

    void setRateSPUI(RateSPUI rateSPUI) {
        this.rateSPUI = rateSPUI;
    }

}
