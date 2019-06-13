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
import lapr.project.gpsd.model.Category;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI2 implements Initializable {

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
    private ListView<Category> catList;

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
        registerServiceProviderUI.toRegisterServiceProviderScene3();
    }

    @FXML
    private void handleAddBtn(ActionEvent event) {
        registerServiceProviderUI.toRegisterServiceProviderScene5(this);
    }

    @FXML
    private void handleRemoveBtn(ActionEvent event) {
        try {
            String catId = catList.getSelectionModel().getSelectedItem().getCode();
            registerServiceProviderUI.getController().removeSPCategory(catId);
            updateList();
        } catch(Exception e) {}
    }

    void updateList() {
        catList.getItems().clear();
        List<Category> categories = registerServiceProviderUI.getController().getSPCategories();
        catList.getItems().addAll(categories);
    }

}
