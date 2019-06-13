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
import javafx.scene.text.Text;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI1 implements Initializable {

    RegisterServiceProviderUI registerServiceProviderUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private Text acceptLabel;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField postalCodeTxt;
    @FXML
    private TextField localTxt;
    @FXML
    private ComboBox<String> nifComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        continueBtn.setDisable(true);
        nameTxt.setDisable(true);
        addressTxt.setDisable(true);
        postalCodeTxt.setDisable(true);
        localTxt.setDisable(true);

    }

    public void setRegisterServiceProviderUI(RegisterServiceProviderUI registerServiceProviderUI) {
        this.registerServiceProviderUI = registerServiceProviderUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        registerServiceProviderUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        try {
            String name = nameTxt.getText();
            String address = addressTxt.getText();
            String postalCode = postalCodeTxt.getText();
            String local = localTxt.getText();
            registerServiceProviderUI.getController().newServiceProvider(name, local, postalCode, address);
            registerServiceProviderUI.toRegisterServiceProviderScene2();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void handleNifComboBox(ActionEvent event) {
        String nif = nifComboBox.getValue();
        if (registerServiceProviderUI.getController().getApplicationData(nif)) {
            continueBtn.setDisable(false);
            nameTxt.setDisable(false);
            addressTxt.setDisable(false);
            postalCodeTxt.setDisable(false);
            localTxt.setDisable(false);
            updateFields();
            nifComboBox.setDisable(true);
        } else {
            UIUtils.createAlert("Application not found.", "Fatal error:", Alert.AlertType.ERROR);
            registerServiceProviderUI.getMainMenu().backToMainMenu();
        }
    }

    public void populateNifComboBox() {
        List<String> nifs = registerServiceProviderUI.getController().getApplications();
        nifComboBox.getItems().addAll(nifs);
        if (nifs.isEmpty()) {
            UIUtils.createAlert("Unable to register Service Provider.", "No applications found.", Alert.AlertType.ERROR);
            registerServiceProviderUI.getMainMenu().backToMainMenu();
        }
    }

    private void updateFields() {
        String name = registerServiceProviderUI.getController().getSPName();
        String address = registerServiceProviderUI.getController().getSPAddress();
        String postalCode = registerServiceProviderUI.getController().getSPPostalCode();
        String local = registerServiceProviderUI.getController().getSPLocal();
        nameTxt.setText(name);
        addressTxt.setText(address);
        postalCodeTxt.setText(postalCode);
        localTxt.setText(local);
    }

}
