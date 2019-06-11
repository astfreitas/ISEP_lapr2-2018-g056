package lapr.project.gpsd.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.SchedulePreference;

public class CreateServiceRequestUI4 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;
    
    @FXML
    private Button cancelBtn;
    @FXML
    private ComboBox<String> hourComboBox;
    @FXML
    private ComboBox<String> minuteComboBox;
    @FXML
    private Button continueBtn;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button addSchedulePrefBtn;
    @FXML
    private ListView<SchedulePreference> scheduleLst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.createServiceRequestUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        this.createServiceRequestUI.toCreateServiceRequestControllerScene5();
    }
    
    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }
    
    public void setupSchedulePreferenceScene() {        
        datePicker.setValue(LocalDate.now());
        for (int i = 6; i < 24; i++) {
            String hour = "";
            if (i < 10) {
                hour = "0";
            }
            hourComboBox.getItems().add(hour + i);
        }
        hourComboBox.getSelectionModel().selectFirst();
        for (int i = 0; i < 60; i += 30) {
            String min = "";
            if (i < 10) {
                min = "0";
            }
            minuteComboBox.getItems().add(min + i);
        }
        minuteComboBox.getSelectionModel().selectFirst();
    }
    
}
