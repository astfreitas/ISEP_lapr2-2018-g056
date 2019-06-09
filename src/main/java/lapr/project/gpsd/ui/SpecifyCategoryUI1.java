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
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author joaoferreira
 */
public class SpecifyCategoryUI1 implements Initializable {

    private SpecifyCategoryUI specifyCategoryUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField catCodeTxt;
    @FXML
    private TextArea catDescTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setSpecifyCategoryUI(SpecifyCategoryUI specifyCategoryUI) {
        this.specifyCategoryUI = specifyCategoryUI;
    }

    public TextField getCatCodeTxt() {
        return catCodeTxt;
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.specifyCategoryUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String catCode = catCodeTxt.getText();
        String catDesc = catDescTxt.getText();
        try {
            if (this.specifyCategoryUI.getController().newCategory(catCode, catDesc)) {
                this.specifyCategoryUI.toSpecifyCategoryScene2();
            } else {
                UIUtils.createAlert("Category code already in use.", "", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            UIUtils.createAlert("All the fields must be filled", "Missing data", Alert.AlertType.ERROR);
        }
    }
}
