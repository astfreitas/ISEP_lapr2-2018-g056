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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lapr.project.gpsd.controller.GeographicAreaSpecController;

/**
 *
 * @author astfr
 */
public class GeographicAreaSpecification implements Initializable {
    
    private Main mainApp;
    private GeographicAreaSpecController controller;
    
    
    @FXML
    private TextField designationText;
    @FXML
    private TextField radiusText;
    @FXML
    private TextField costText;
    @FXML
    private TextField postalCodeText;
    @FXML
    private Button searchPostalCodeButton;
    @FXML
    private AnchorPane postalCodeList;
    @FXML
    private Button newGeoAreaButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
        String strPC = this.postalCodeText.getText();
        controller.searchMatchPostalCode(strPC);
        
    }

    @FXML
    private void handleNewGeoAreaButton(ActionEvent event) {
    }
    
}
