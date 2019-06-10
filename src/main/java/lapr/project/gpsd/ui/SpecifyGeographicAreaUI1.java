/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lapr.project.gpsd.controller.GeographicAreaSpecController;
import lapr.project.gpsd.model.PostalCode;

/**
 *
 * @author astfr
 */
public class SpecifyGeographicAreaUI1 implements Initializable {
    
//    private GeographicAreaSpecController controller;
    
    private SpecifyGeographicAreaUI specifyGeographicAreaUI;
    
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
    private Button newGeoAreaButton;
        
    private ObservableList<PostalCode> pcString = FXCollections.observableArrayList();
    
    @FXML
    private ListView<PostalCode> listViewCP = new ListView<>(pcString);
    @FXML
    private Button cancelButton;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
        String strPC = this.postalCodeText.getText();
        List<PostalCode> searchedPClist = specifyGeographicAreaUI.getController().searchMatchPostalCode(strPC);
        for (PostalCode postalCode : searchedPClist) {
            pcString.add(postalCode);
        }
        listViewCP.setItems(pcString);
        
        
    }

    @FXML
    private void handleNewGeoAreaButton(ActionEvent event) {
        String desigStr = designationText.getText();
        double radius = Double.parseDouble(radiusText.getText());
        double cost = Double.parseDouble(costText.getText());
        PostalCode selectedPC = listViewCP.getSelectionModel().getSelectedItem();
//        this.specifyGeographicAreaUI.getController().newGeographicArea(desigStr, cost, desigStr, radius);
        
    }
    
    public void setSpecifyGeographicAreaUI(SpecifyGeographicAreaUI specifyGeographicAreaUI){
        this.specifyGeographicAreaUI = specifyGeographicAreaUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.specifyGeographicAreaUI.getMainMenu().backToMainMenu();
    }
    
}
