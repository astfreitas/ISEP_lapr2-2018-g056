package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI3 implements Initializable {

    RegisterServiceProviderUI registerServiceProviderUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private ListView<GeographicArea> areasList;

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

    @FXML
    private void handleCancelButton(ActionEvent event) {
        registerServiceProviderUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        registerServiceProviderUI.toRegisterServiceProviderScene4();
    }

    @FXML
    private void handleAddBtn(ActionEvent event) {
        registerServiceProviderUI.toRegisterServiceProviderScene6(this);
    }

    @FXML
    private void handleRemoveBtn(ActionEvent event) {
        try {
            String areaId = areasList.getSelectionModel().getSelectedItem().getGeoId();
            registerServiceProviderUI.getController().removeSPArea(areaId);
            updateList();
        } catch(Exception e) {}
    }

    void updateList() {
        areasList.getItems().clear();
        List<GeographicArea> areas = registerServiceProviderUI.getController().getSPGeographicAreas();
        areasList.getItems().addAll(areas);
        if (areas.isEmpty()) {
            UIUtils.createAlert("Unable to register Service Provider.", "No geographic areas found.", Alert.AlertType.ERROR);
            ((Stage) cancelBtn.getScene().getWindow()).close();
            registerServiceProviderUI.getMainMenu().backToMainMenu();
        }
    }
}

