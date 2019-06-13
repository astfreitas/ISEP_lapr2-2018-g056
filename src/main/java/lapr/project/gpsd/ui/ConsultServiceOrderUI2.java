/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.FileType;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.UIUtils;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class ConsultServiceOrderUI2 implements Initializable {

    private ConsultServiceOrderUI consultServOrderUI;
    /**
     * Stard Date for the search period
     */
    private LocalDate sDate;
    /**
     * End Date for the search period
     */
    private LocalDate eDate;
    @FXML
    private Button cancelButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button exportButton;
    @FXML
    private ListView<ServiceOrder> listViewServOrders;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Sets the class atributes sDate and eDate with the value from the
     * ConsultServideOrderCOntroller.
     */
    public void setDatesToScene() {
        this.sDate = consultServOrderUI.getController().getsDate();
        this.eDate = consultServOrderUI.getController().geteDate();
    }

    /**
     * Sets the new dates from Scene DatePickers to the local class LocalDate
     * atributes and to ConsultServideOrderController.
     */
    public void setDatesToController() {
        sDate = startDatePicker.getValue();
        eDate = endDatePicker.getValue();
        consultServOrderUI.getController().setDatesToSearch(sDate, eDate);
    }

    /**
     * Loads the ListView in scene with the servicer orders list returns by
     * Controller.
     */
    public void loadListView() {
        setDatesToScene();
        startDatePicker.setValue(sDate);
        endDatePicker.setValue(eDate);
        List<ServiceOrder> tmpServList = consultServOrderUI.getController().getServiceOrderByDateAndSP(sDate, eDate);
        listViewServOrders.getItems().addAll(tmpServList);
    }

    /**
     * Sets the local ConsultServiceOrderUI with the instance to the main UI.
     *
     * @param consultServOrderUI
     */
    public void setConsultServOrderUI(ConsultServiceOrderUI consultServOrderUI) {
        this.consultServOrderUI = consultServOrderUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        consultServOrderUI.getMainMenu().backToMainMenu();
    }

    /**
     * Method handles the event created from click the Refresh Button in scene
     * by cleaning the List View, sets the new dates and loads again the List
     * View.
     *
     * @param event event created from actuating the refresh button
     */
    @FXML
    private void handleRefreshBut(ActionEvent event) {
        listViewServOrders.getItems().clear();
        setDatesToController();
        loadListView();
    }

    /**
     * Method handles the event created from click the Export Button in scene by
     * getting the FileTypes from controller to a Choice Dialog to allow user to
     * choose FileType and executes the export data in controller.
     *
     * @param event event created from actuating the Export button
     */
    @FXML
    private void handleExportBut(ActionEvent event) {
        if (checkListViewHasContent()) {
            List<FileType> choices = consultServOrderUI.getController().getFileTypes();
            ChoiceDialog<FileType> dialog = new ChoiceDialog<>(choices.get(0), choices);
            dialog.setTitle("Export");
            dialog.setHeaderText("Exporting selected Service Orders List");
            dialog.setContentText("Please choose format for export:");
            dialog.showAndWait();

            if (dialog.getResult() == null) {
                event.consume();
            } else {
                FileType selectedFileType = (FileType) dialog.getResult();
                if (consultServOrderUI.getController().exportServiceOrdersByFileType(selectedFileType)) {
                    UIUtils.createAlertWait("Export Service Orders Completed", "Export Confirmation", Alert.AlertType.INFORMATION);
                    consultServOrderUI.getMainMenu().backToMainMenu();
                } else {
                    UIUtils.createAlert("Error occured during the export of Service Orders", "Export Error", Alert.AlertType.ERROR);
                }
            }
        }
    }

    /**
     * Checks the ServiceOrderList searched to ListView is empty and displays
     * alert if no records are found
     *
     * @return true if the listView is not empty, otherwise returns false
     */
    private boolean checkListViewHasContent() {
        if (listViewServOrders.getItems().isEmpty()) {
            UIUtils.createAlertWait("There are no Service Orders to Export", "No results found", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }

    /**
     * Returns the StarDatePicker
     *
     * @return DatePicker Start
     */
    public DatePicker getStartDatePicker() {
        return startDatePicker;
    }

}
