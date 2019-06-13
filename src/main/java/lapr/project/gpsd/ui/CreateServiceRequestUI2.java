package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.utils.UIUtils;

public class CreateServiceRequestUI2 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private Button addServiceBtn;
    @FXML
    private TableView<ServiceRequestDescription> addServiceTbl;
    @FXML
    private TableColumn<ServiceRequestDescription, String> categoryCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> serviceCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> durationCol;
    @FXML
    private TableColumn<ServiceRequestDescription, String> costCol;
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

        if (this.createServiceRequestUI.getController().getServiceRequest().getServiceRequestDescriptions().size() > 0) {
            this.createServiceRequestUI.toCreateServiceRequestControllerScene4();
        } else {
            UIUtils.createAlert("Please specify a service", "Add Service Error", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void handleAddServiceBtn(ActionEvent event) {
        this.createServiceRequestUI.toCreateServiceRequestControllerScene3();
    }

    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }

    public void setupServiceRequestDescriptionTable() {
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("propertyCategory"));
        serviceCol.setCellValueFactory(new PropertyValueFactory<>("propertyService"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("propertyDuration"));
        costCol.setCellValueFactory(new PropertyValueFactory<>("propertyCost"));
        addServiceTbl.getItems().clear();
        addServiceTbl.getItems().addAll(createServiceRequestUI.getController().getServiceRequest().getServiceRequestDescriptions());
    }

    /**
     * Handes the event created by clicking the Remove Button by removing the
     * Service Request from the Controller instance and if succefully removes
     * from the TableView
     *
     * @param event created by clicking the Remove Button
     */
    @FXML
    private void handleRemoveBtn(ActionEvent event) {
        try {
            if (createServiceRequestUI.getController().getServiceRequest().removeServiceRequestDescription(addServiceTbl.getSelectionModel().getSelectedItem())) {
                addServiceTbl.getItems().remove(addServiceTbl.getSelectionModel().getSelectedItem());
            }
        } catch (Exception e) {
            UIUtils.createAlert("An error ocurred trying to remove the selected Service Request", "Error removing", Alert.AlertType.ERROR);
        }

    }

}
