package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI6 implements Initializable {

    RegisterServiceProviderUI registerServiceProviderUI;
    RegisterServiceProviderUI3 parentUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private ComboBox<GeographicArea> areaComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setRegisterServiceProviderUI(RegisterServiceProviderUI registerServiceProviderUI) {
        this.registerServiceProviderUI = registerServiceProviderUI;
    }

    public void setParentUI(RegisterServiceProviderUI3 parentUI) {
        this.parentUI = parentUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Stage) cancelBtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        String areaId = areaComboBox.getValue().getGeoId();
        if (registerServiceProviderUI.getController().addGeographicArea(areaId)) {
            ((Stage) cancelBtn.getScene().getWindow()).close();
            parentUI.updateList();
        } else {
            UIUtils.createAlert("Geographic area already added.", "Error:", Alert.AlertType.ERROR);
        }
    }

    void populateComboBox() {
        List<GeographicArea> areas = registerServiceProviderUI.getController().getGeographicAreas();
        areaComboBox.getItems().addAll(areas);
        if (areas.isEmpty()) {
            UIUtils.createAlert("Unable to register Service Provider.", "No geographic areas found.", Alert.AlertType.ERROR);
            ((Stage) cancelBtn.getScene().getWindow()).close();
            registerServiceProviderUI.getMainMenu().backToMainMenu();
        }
    }

}
