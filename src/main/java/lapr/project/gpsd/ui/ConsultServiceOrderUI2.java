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

    public void setDatesToScene() {
        this.sDate = consultServOrderUI.getController().getsDate();
        this.eDate = consultServOrderUI.getController().geteDate();
    }

    public void loadListView() {
        setDatesToScene();
        startDatePicker.setValue(sDate);
        endDatePicker.setValue(eDate);
        List<ServiceOrder> tmpServList = consultServOrderUI.getController().getServiceOrderByDateAndSP(sDate, eDate);
        listViewServOrders.getItems().addAll(tmpServList);
    }

    public void setConsultServOrderUI(ConsultServiceOrderUI consultServOrderUI) {
        this.consultServOrderUI = consultServOrderUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        consultServOrderUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleRefreshBut(ActionEvent event) {
        listViewServOrders.getItems().clear();
        sDate = startDatePicker.getValue();
        eDate = endDatePicker.getValue();
        loadListView();
    }
    
    @FXML
    private void handleExportBut(ActionEvent event) {
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

    public DatePicker getStartDatePicker() {
        return startDatePicker;
    }

}
