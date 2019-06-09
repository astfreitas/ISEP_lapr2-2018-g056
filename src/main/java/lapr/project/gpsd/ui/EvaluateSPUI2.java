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
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author breno
 */
public class EvaluateSPUI2 implements Initializable {

    @FXML
    private Button closeBtn;
    @FXML
    private BarChart<?, ?> ratingsBarChart;
    @FXML
    private TextField popAverageTxt;
    @FXML
    private TextField popStdDevTxt;
    @FXML
    private TextField spAverageTxt;
    @FXML
    private TextField spDevTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCloseBtn(ActionEvent event) {
    }
    
}
