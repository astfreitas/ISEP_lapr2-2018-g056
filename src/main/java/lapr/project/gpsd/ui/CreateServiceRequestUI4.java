package lapr.project.gpsd.ui;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.utils.UIUtils;

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
    @FXML
    private Button removeSelected;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.createServiceRequestUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        if (!this.createServiceRequestUI.getController().validate()) {
            UIUtils.createAlert("You must have atleast 1 Schedule Preference", "SchedulePreference Error", Alert.AlertType.ERROR);
        } else {
            this.createServiceRequestUI.toCreateServiceRequestControllerScene5();
        }
    }

    @FXML
    private void handleAddSchedulePrefBtn(ActionEvent event) {
        LocalDate scheduleDay = datePicker.getValue();
        int hour = Integer.parseInt(hourComboBox.getSelectionModel().getSelectedItem());
        int min = Integer.parseInt(minuteComboBox.getSelectionModel().getSelectedItem());
        LocalTime scheduleTime = LocalTime.of(hour, min, 0);
        try {
            this.createServiceRequestUI.getController().addSchedulePreference(scheduleDay, scheduleTime);
        } catch (Exception e) {
            UIUtils.createAlert( e.getMessage(), "SchedulePreference Error", Alert.AlertType.ERROR);
        }
        updateScheduleList();
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
        for (int i = 0; i < 60; i += 5) {
            String min = "";
            if (i < 10) {
                min = "0";
            }
            minuteComboBox.getItems().add(min + i);
        }
        minuteComboBox.getSelectionModel().selectFirst();
    }

    private void updateScheduleList() {
        scheduleLst.getItems().clear();
        List<SchedulePreference> schedulePreferences = this.createServiceRequestUI.getController().getServiceRequest().getSchedulePreferences();
        scheduleLst.getItems().addAll(schedulePreferences);
    }

    /**
     * Handles the Remove Slected button action event by removing the selected
     * instance in the schedule list
     *
     * @param event RemoveSelected button click
     */
    @FXML
    private void handleRemoveSelected(ActionEvent event) {
        try {
            if (createServiceRequestUI.getController().getServiceRequest().removeSchedulePreferenceFromList(scheduleLst.getSelectionModel().getSelectedItem())) {
                scheduleLst.getItems().remove(scheduleLst.getSelectionModel().getSelectedItem());
            }
        } catch (Exception e) {
            UIUtils.createAlert("An error ocurred trying to remove the selected Schedule Preference", "Error removing", Alert.AlertType.ERROR);
        }
    }

}
