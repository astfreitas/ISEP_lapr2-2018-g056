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
import javafx.scene.control.MenuItem;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class MainMenuClientUI implements Initializable {
    
    private Main mainApp;
    @FXML
    private MenuItem serviceRequestBtn;
    @FXML
    private MenuItem addAddressBtn;
    @FXML
    private MenuItem acceptServiceReqAssignmentBtn;
    @FXML
    private MenuItem rateSPBtn;
    @FXML
    private MenuItem aboutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }
    
    public void toMainMenu() {
        try {
            MainMenuClientUI loginScreenUI = (MainMenuClientUI) this.mainApp.replaceSceneContent("/fxml/MainMenuClient.fxml");
        } catch (Exception ex) {

        }
    }

    @FXML
    private void handleServiceRequestBtn(ActionEvent event) {
    }

    @FXML
    private void handleAddAddressBtn(ActionEvent event) {
    }

    @FXML
    private void handleAcceptServiceReqAssignmentBtn(ActionEvent event) {
    }

    @FXML
    private void handleRateSPBtn(ActionEvent event) {
    }

    @FXML
    private void handleAboutBtn(ActionEvent event) {
        UIUtils.about();
    }
}
