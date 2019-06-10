/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class ConsultServiceOrderUI1 implements Initializable {
    
    private ConsultServiceOrderUI consultServOrderUI;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private Button cancelButton;
    @FXML
    private Button searchButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setConsultServOrderUI(ConsultServiceOrderUI consultServOrderUI) {
        this.consultServOrderUI = consultServOrderUI;
    }

    /**
     * Allows the scene to go back to the main menu throw the ConsultServiceOrderUI
     * instance
     * @param event event generated from button
     */
    @FXML
    private void handleCancelBut(ActionEvent event) {
        this.consultServOrderUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleSearchBut(ActionEvent event) {
//        this.consultServOrderUI.getController().
        LocalDate sDate = startDate.getValue();
        LocalDate eDate = endDate.getValue();
        if (sDate.isBefore(eDate)) {
            
        }
    }

    public DatePicker getStartDate() {
        return startDate;
    }
    
    
}
