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

/**
 * FXML Controller class
 *
 * @author mdias
 */
public class RegisterServiceProviderUI5 implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ListView<?> addressList;
    @FXML
    private Button addAddressBtn;
    @FXML
    private Button removeAddressBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelBtn(ActionEvent event) {
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
    }

    @FXML
    private void handleAddAddressBtn(ActionEvent event) {
    }

    @FXML
    private void handleRemoveAddressBtn(ActionEvent event) {
    }
    
}
