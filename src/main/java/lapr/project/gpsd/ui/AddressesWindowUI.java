/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class AddressesWindowUI implements Initializable {

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
    private Object parentController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     * Defines the controller which will control this window
     *
     * @param parentController Controller
     */
    public void setParentController(Object parentController) {
        this.parentController = parentController;
    }
}
