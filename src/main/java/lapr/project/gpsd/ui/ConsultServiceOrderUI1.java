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

    @FXML
    private void handleCancelBut(ActionEvent event) {
    }

    @FXML
    private void handleSearchBut(ActionEvent event) {
    }

    public DatePicker getStartDate() {
        return startDate;
    }
    
    
}
