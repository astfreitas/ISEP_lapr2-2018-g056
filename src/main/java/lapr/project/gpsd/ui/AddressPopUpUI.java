package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddressPopUpUI implements Initializable {

    private RegisterClientUI2 registerClient;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private TextField addressTxt;
    @FXML
    private TextField pcTxt;
    @FXML
    private TextField localTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    public void setParentUI(RegisterClientUI2 parentUI) {
        this.registerClient = parentUI;
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        String address = addressTxt.getText();
        String postalCode = pcTxt.getText();
        String local = localTxt.getText();
        registerClient.receiveAddress(address, postalCode,local);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
