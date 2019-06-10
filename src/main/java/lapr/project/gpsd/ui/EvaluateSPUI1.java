package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.utils.UIUtils;

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
    @FXML
    private ComboBox<ServiceProvider> spComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        confirmBtn.setDisable(true);
        viewStatisticsBtn.setDisable(true);
        classificationTxt.setDisable(true);
        changeClassificationBtn.setDisable(true);
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
        evaluateSPUI.toEvaluateSPScene2();
    }

    @FXML
    private void handleChangeClassificationBtn(ActionEvent event) {
        evaluateSPUI.toEvaluateSPScene3();
    }

    public void populateSPComboBox() {
        try {
            List<ServiceProvider> serviceProviders = evaluateSPUI.getController().getServiceProviders();
            spComboBox.getItems().addAll(serviceProviders);
        } catch (RuntimeException e) {
            evaluateSPUI.getMainMenu().backToMainMenu();
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleSPComboBox(ActionEvent event) {
        try {
            evaluateSPUI.getController().newSPStatistics(spComboBox.getValue().getEmail());
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
        spComboBox.setDisable(true);
        confirmBtn.setDisable(false);
        viewStatisticsBtn.setDisable(false);
        changeClassificationBtn.setDisable(false);
    }

}
