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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class RateSPUI2 implements Initializable {
    
    private RateSPUI rateSPUI;

    @FXML
    private Button cancelBrn;
    @FXML
    private Button continueBtn;
    @FXML
    private RadioButton rate0;
    @FXML
    private RadioButton rate1;
    @FXML
    private RadioButton rate2;
    @FXML
    private RadioButton rate3;
    @FXML
    private RadioButton rate4;
    @FXML
    private RadioButton rate5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleCancelBtn(ActionEvent event) {
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        int rate = getRate();
        if(rate == -1){
            UIUtils.createAlert("Please select a rating", "", Alert.AlertType.ERROR);
        }else{
            this.rateSPUI.getController().setRating(rate);
            this.rateSPUI.toSpecifyCategoryScene3();
        }
    }
    
    void setRateSPUI(RateSPUI rateSPUI) {
        this.rateSPUI = rateSPUI;
    }
    
    private int getRate(){
        int rate = -1;        
        if(rate0.isSelected()){
            rate = 0;
        }else if(rate1.isSelected()){
            rate = 1;
        }else if(rate2.isSelected()){
            rate = 2;
        }else if(rate3.isSelected()){
            rate = 3;
        }else if(rate4.isSelected()){
            rate = 4;
        }else if(rate5.isSelected()){
            rate = 5;
        }    
        return rate;
    }
    
}
