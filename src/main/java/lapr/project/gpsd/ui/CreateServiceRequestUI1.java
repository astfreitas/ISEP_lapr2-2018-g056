package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lapr.project.gpsd.model.Address;

public class CreateServiceRequestUI1 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private ComboBox<Address> addressComboBox;

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
        if (setAddress()) {
            this.createServiceRequestUI.toCreateServiceRequestControllerScene2();
        }
    }

    public void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }

    public void showClientAddresses() {
        List<Address> clientAddresses = this.createServiceRequestUI.getController().newRequest();
        addressComboBox.getItems().clear();
        addressComboBox.getItems().addAll(clientAddresses);
        addressComboBox.getSelectionModel().selectFirst();
    }

    private boolean setAddress() {
        if(!addressComboBox.getSelectionModel().isEmpty()) {
            Address selectedAddress =  addressComboBox.getSelectionModel().getSelectedItem();
            this.createServiceRequestUI.getController().setAddress(selectedAddress);
            return true;
        }
        return false;
    }

}
