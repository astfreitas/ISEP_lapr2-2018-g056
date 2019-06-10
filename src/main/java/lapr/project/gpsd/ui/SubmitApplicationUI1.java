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

public class SubmitApplicationUI1 implements Initializable {

    private SubmitApplicationUI submitApplicationUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField telephoneTxt;

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

    public TextField getNameTxt() {
        return nameTxt;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        submitApplicationUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
//        String name = null;
//        String nif = null;
//        String telephone = null;
//        String email = null;
        try {
            // get texts
        } catch (NullPointerException e) {
            System.out.println("Missing data");
        }
        try {
            // create objects
            this.submitApplicationUI.toSubmitApplicationScene2();
//            this.submitApplicationUI.getController().newSPApplication(
//                    nameTxt.getText(), nifTxt.getText(),
//                    telephoneTxt.getText(), emailTxt.getText());
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "No dice bro", Alert.AlertType.ERROR);
        }
    }

}
