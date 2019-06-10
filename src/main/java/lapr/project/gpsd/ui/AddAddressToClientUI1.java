package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddAddressToClientUI1 implements Initializable {

    private AddAddressToClientUI addAddressToClientUI;

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

    public void setAddAddressToClientUI(AddAddressToClientUI addAddressToClientUI) {
        this.addAddressToClientUI = addAddressToClientUI;
    }

    public TextField getAddressTxt() {
        return addressTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        addAddressToClientUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        addAddressToClientUI.toAddAddressToClientScene2();
    }

}
