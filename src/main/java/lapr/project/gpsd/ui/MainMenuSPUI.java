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
public class MainMenuSPUI implements Initializable {
    
    private Main mainApp;
    private MainMenuUI mainMenuUI;
    @FXML
    private MenuItem rateSPBtn;
    @FXML
    private MenuItem aboutBtn;
    @FXML
    private MenuItem addDailyAvaiBtn;
    @FXML
    private MenuItem consultServiceOrders;
    @FXML
    private MenuItem completeServiceBtn;

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
    private void handleAboutBtn(ActionEvent event) {
        UIUtils.about();
    }

    @FXML
    private void handleAddDailyAvaiBtn(ActionEvent event) {
    }

    @FXML
    private void handleConsultServiceOrdersBtn(ActionEvent event) {
        ConsultServiceOrderUI consultServiceOrderUI = new ConsultServiceOrderUI(this, mainApp);
        consultServiceOrderUI.toConsultServiceOrderScene1();
    }

    @FXML
    private void handleCompleteServiceBtn(ActionEvent event) {
    }

    @FXML
    private void handleRateSPBtn(ActionEvent event) {
    }
}
