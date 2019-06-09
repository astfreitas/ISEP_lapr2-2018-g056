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
import javafx.scene.control.TextArea;
import lapr.project.gpsd.model.Category;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class SpecifyCategoryUI2 implements Initializable {

    private SpecifyCategoryUI specifyCategoryUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private TextArea confirmTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    public void setSpecifyCategoryUI(SpecifyCategoryUI specifyCategoryUI) {
        this.specifyCategoryUI = specifyCategoryUI;
    }
    
    public void showCategory(){
        Category cat = this.specifyCategoryUI.getController().getCategory();
        confirmTxt.setText(cat.toString());
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.specifyCategoryUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        if(this.specifyCategoryUI.getController().registerCategory()){
            specifyCategoryUI.getMainMenu().backToMainMenu();
        }else{
            this.specifyCategoryUI.getController().registerCategory();
            UIUtils.createAlert("Error creating category.", "", Alert.AlertType.ERROR);
        }
    }

}
