package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

public class SubmitApplicationUI2 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField postalCodeTxt;
    @FXML
    private TextField localTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setSubmitApplicationUI(SubmitApplicationUI submitApplicationUI) {
        this.submitApplicationUI = submitApplicationUI;
    }

    public TextField getAddressTxt() {
        return addressTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        String address = null;
        String postalCode = null;
        String local = null;
        try {
            address = addressTxt.getText();
            postalCode = postalCodeTxt.getText();
            local = localTxt.getText();
        } catch (NullPointerException e) {
        }
        try {
            submitApplicationUI.getController().newAddress(local, postalCode, address);
            submitApplicationUI.toSubmitApplicationScene3();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

}
