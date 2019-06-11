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
    private MainMenuUI mainMenuUI;
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

    public void setMainMenuUI(MainMenuUI mainMenuUI) {
        this.mainMenuUI = mainMenuUI;
    }

    public void backToMainMenu(){
        this.mainMenuUI.toMainMenuClient();
    }

    @FXML
    private void handleServiceRequestBtn(ActionEvent event) {
        CreateServiceRequestUI createServiceRequestUI = new CreateServiceRequestUI(this, mainApp);
        createServiceRequestUI.toCreateServiceRequestControllerScene1();
    }

    @FXML
    private void handleAddAddressBtn(ActionEvent event) {
        AddAddressToClientUI addAddressUI = new AddAddressToClientUI(this, mainApp);
        addAddressUI.toAddAddressToClientScene1();
    }

    @FXML
    private void handleAcceptServiceReqAssignmentBtn(ActionEvent event) {
        AcceptServiceRequestAssignmentsUI acceptServiceRequestAssignmentsUI = new AcceptServiceRequestAssignmentsUI(this, mainApp);
        acceptServiceRequestAssignmentsUI.toAcceptServiceRequestScene1();
    }

    @FXML
    private void handleRateSPBtn(ActionEvent event) {

    }

    @FXML
    private void handleAboutBtn(ActionEvent event) {
        UIUtils.about();
    }
}
