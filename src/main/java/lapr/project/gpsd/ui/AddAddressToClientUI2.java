package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
        // TODO
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
        addAddressToClientUI.getMainMenu().backToMainMenu();
    }

}
