/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.model.Address;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class RegisterClientUI2 implements Initializable {
    
    private RegisterClientUI registerClientUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ListView<Address> addressList;
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
    
    public void setRegisterClientUI(RegisterClientUI registerClientUI) {      
        this.registerClientUI = registerClientUI;
    }

    @FXML
    private void handleAddAddressBtn(ActionEvent event) throws IOException {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Add New Address");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddressPopUp.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        
        Scene newScene = new Scene(root);
        
        AddressPopUpUI addressPopUp = fxmlLoader.getController();
        addressPopUp.setParentUI(this);
        
        newStage.setScene(newScene);
        newStage.showAndWait();
    }
    
    public void receiveAddress(String address, String postalCode, String local){
        Address oAddress = this.registerClientUI.getController().addAddress(local, postalCode, address);
        this.addressList.getItems().add(oAddress);
    }

    @FXML
    private void handleRemoveAddressBtn(ActionEvent event) {
        Address oAddress = this.addressList.getSelectionModel().getSelectedItem();
        this.addressList.getItems().remove(oAddress);
        this.registerClientUI.getController().removeAddress(oAddress);
    }
    
}
