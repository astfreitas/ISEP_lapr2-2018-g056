package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EvaluateSPUI1 implements Initializable {

    private EvaluateSPUI evaluateSPUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Button viewStatisticsBtn;
    @FXML
    private Button changeClassificationBtn;
    @FXML
    private TextField classificationTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setEvaluateSPUI(EvaluateSPUI evaluateSPUI) {
        this.evaluateSPUI = evaluateSPUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        evaluateSPUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        evaluateSPUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleViewStatisticsBtn(ActionEvent event) {
    }

    @FXML
    private void handleChangeClassificationBtn(ActionEvent event) {
    }

}
