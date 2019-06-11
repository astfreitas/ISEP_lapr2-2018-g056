package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.utils.UIUtils;

public class CompleteServiceUI1 implements Initializable {

    private CompleteServiceUI completeServiceUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ListView<ServiceOrder> serviceList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.completeServiceUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        if (serviceList.getSelectionModel().getSelectedItem() == null) {
            UIUtils.createAlert("To continue please select a Service", "", Alert.AlertType.ERROR);
        } else {
            ServiceOrder servOrder = serviceList.getSelectionModel().getSelectedItem();
            this.completeServiceUI.getController().setServOrder(servOrder);
            this.completeServiceUI.toCompleteServiceScene2();
        }
    }

    public void setCompleteServiceUI(CompleteServiceUI completeServiceUI) {
        this.completeServiceUI = completeServiceUI;
    }

    public void populateServiceList() {
        this.serviceList.getItems().addAll(this.completeServiceUI.getController().getPendingServiceOrders());
    }
}
