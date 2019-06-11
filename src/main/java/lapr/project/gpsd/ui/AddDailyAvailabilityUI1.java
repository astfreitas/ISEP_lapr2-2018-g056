package lapr.project.gpsd.ui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import lapr.project.gpsd.utils.Constants;
import lapr.project.utils.UIUtils;

public class AddDailyAvailabilityUI1 implements Initializable {

    private AddDailyAvailabilityUI addDailyAvailabilityUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private DatePicker avalDatePicker;
    @FXML
    private ComboBox<String> frequencyComboBox;
    @FXML
    private ComboBox<Integer> bHourPicker;
    @FXML
    private ComboBox<Integer> bMinPicker;
    @FXML
    private ComboBox<Integer> eHourPicker;
    @FXML
    private ComboBox<Integer> eMinPicker;
    @FXML
    private DatePicker endDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        if (avalDatePicker.getValue() == null
                || bHourPicker.getValue() == null || bMinPicker.getValue() == null
                || eHourPicker.getValue() == null || eMinPicker.getValue() == null) {
            UIUtils.createAlert("Missing data", "", Alert.AlertType.ERROR);
        } else {
            LocalTime bTime = LocalTime.of(bHourPicker.getValue(), bMinPicker.getValue(), 0, 0);
            LocalTime eTime = LocalTime.of(eHourPicker.getValue(), eMinPicker.getValue(), 0, 0);
            if (frequencyComboBox.getSelectionModel().getSelectedItem().equals("")) {
                this.addDailyAvailabilityUI.getController().newAvailability(avalDatePicker.getValue(), bTime, eTime);
            } else {
                this.addDailyAvailabilityUI.getController().newAvailability(avalDatePicker.getValue(), bTime, eTime, endDatePicker.getValue(), frequencyComboBox.getValue());
            }

        }
    }

    public void setAddDailyAvailabilityUI(AddDailyAvailabilityUI addDailyAvailabilityUI) {
        this.addDailyAvailabilityUI = addDailyAvailabilityUI;
    }

    public void populateFreqCombobox() {
        frequencyComboBox.getItems().add(Constants.REPETITION_PATTERN_DAILY);
        frequencyComboBox.getItems().add(Constants.REPETITION_PATTERN_WEEKLY);
        frequencyComboBox.getItems().add(Constants.REPETITION_PATTERN_FORTNIGHTLY);
        frequencyComboBox.getItems().add(Constants.REPETITION_PATTERN_MONTHLY);
    }

    public void populateTimeComboboxes() {
        for (int i = 0; i < 24; i++) {
            bHourPicker.getItems().add(i);
            eHourPicker.getItems().add(i);
        }
        for (int i = 0; i < 60; i++) {
            bMinPicker.getItems().add(i);
            eMinPicker.getItems().add(i);
        }
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.addDailyAvailabilityUI.getMainMenu().backToMainMenu();
    }

}
