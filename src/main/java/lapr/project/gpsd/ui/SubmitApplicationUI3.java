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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author breno
 */
public class SubmitApplicationUI3 implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button addQualificationBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField courseTxt;
    @FXML
    private ComboBox<?> levelComboBox;
    @FXML
    private ComboBox<?> gradeComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
    }

    @FXML
    private void handleAddQualificationBtn(ActionEvent event) {
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
    }
    
}
