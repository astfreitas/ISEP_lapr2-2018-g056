package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import lapr.project.gpsd.model.Availability;

public class AddDailyAvailabilityUI2 implements Initializable {
    
    private AddDailyAvailabilityUI addDailyAvailabilityUI;

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
    
     public void setAddDailyAvailabilityUI(AddDailyAvailabilityUI addDailyAvailabilityUI) {
        this.addDailyAvailabilityUI = addDailyAvailabilityUI;
    }
    
    public void showConfirmTxt(){
        ArrayList<Availability> avalList = this.addDailyAvailabilityUI.getController().getAvalList();
        confirmTxt.setText(avalList.toString());
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.addDailyAvailabilityUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        this.addDailyAvailabilityUI.getController().registerAvailability();
        this.addDailyAvailabilityUI.getMainMenu().backToMainMenu();
    }
}
