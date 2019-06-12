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
import lapr.project.gpsd.controller.ApplicationGPSD;
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
    private MenuItem aboutBtn;
    @FXML
    private MenuItem addDailyAvaiBtn;
    @FXML
    private MenuItem consultServiceOrders;
    @FXML
    private MenuItem completeServiceBtn;
    @FXML
    private MenuItem logoutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setMainMenuUI(MainMenuUI mainMenuUI) {
        this.mainMenuUI = mainMenuUI;
    }

    public void backToMainMenu() {
        this.mainMenuUI.toMainMenuSP();
    }

    @FXML
    private void handleAboutBtn(ActionEvent event) {
        UIUtils.about();
    }

    @FXML
    private void handleAddDailyAvaiBtn(ActionEvent event) {
        AddDailyAvailabilityUI addDailyAvailabilityUI = new AddDailyAvailabilityUI(this, mainApp);
        addDailyAvailabilityUI.toAddAvailabilityScene1();
    }

    @FXML
    private void handleConsultServiceOrdersBtn(ActionEvent event) {
        ConsultServiceOrderUI consultServiceOrderUI = new ConsultServiceOrderUI(this, mainApp);
        consultServiceOrderUI.toConsultServiceOrderScene1();
    }

    @FXML
    private void handleCompleteServiceBtn(ActionEvent event) {
        CompleteServiceUI completeServiceUI = new CompleteServiceUI(this, mainApp);
        completeServiceUI.toCompleteServiceScene1();
    }

    @FXML
    private void handleLogoutBtn(ActionEvent event) {
        ApplicationGPSD.getInstance().doLogout();
        mainApp.toMainScene();
    }
}
