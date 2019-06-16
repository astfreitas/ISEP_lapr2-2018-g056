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
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class SpecifyGeographicAreaUI2 implements Initializable {

    private SpecifyGeographicAreaUI specifyGeographicAreaUI;

    @FXML
    private Button cancelButton;
    @FXML
    private Button confirmButton;
    @FXML
    private TextArea newGeoAreaTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setSpecifyGeographicAreaUI(SpecifyGeographicAreaUI specifyGeographicAreaUI) {
        this.specifyGeographicAreaUI = specifyGeographicAreaUI;
    }

    public void showGeographicArea() {
        GeographicArea geoA = this.specifyGeographicAreaUI.getController().getGeoA();
        newGeoAreaTextArea.setText(geoA.display());
    }

    @FXML
    private void handleCancelBut(ActionEvent event) {
        this.specifyGeographicAreaUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBut(ActionEvent event) {
        try {
            if (this.specifyGeographicAreaUI.getController().registerGeographicArea()) {
                UIUtils.createAlertWait("The new Geographic Area was registed with sucess.\n", "Success", Alert.AlertType.INFORMATION);
                specifyGeographicAreaUI.getMainMenu().backToMainMenu();
            } else {
                UIUtils.createAlert("Error creating Geographic Area", "", Alert.AlertType.ERROR);

            }
        } catch (Exception e) {
            UIUtils.createAlert("GeographicArea already exists!", "", Alert.AlertType.ERROR);
        }
    }

}
