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
        try {
            // get texts
        } catch (NullPointerException e) {
        }
        try {
            // create objects
            this.submitApplicationUI.toSubmitApplicationScene3();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "No dice bro", Alert.AlertType.ERROR);
        }

    }

}
