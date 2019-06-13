package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lapr.project.utils.UIUtils;

public class AddAddressToClientUI2 implements Initializable {

    private AddAddressToClientUI addAddressToClientUI;

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

    public void setAddAddressToClientUI(AddAddressToClientUI addAddressToClientUI) {
        this.addAddressToClientUI = addAddressToClientUI;
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        addAddressToClientUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        try {
            addAddressToClientUI.getController().registerAddress();
            UIUtils.createAlert("The new Address was added to your profile!", "Success!", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
        addAddressToClientUI.getMainMenu().backToMainMenu();
    }

    void displayAddress() {
        this.confirmTxt.setText(addAddressToClientUI.getController().getAddress().toString());
    }

}
