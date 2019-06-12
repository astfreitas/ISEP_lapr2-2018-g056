package lapr.project.gpsd.ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.ServiceDefinitionController;
import lapr.project.utils.UIUtils;

public class ServiceDefinitionUI {

    private MainMenuAdminUI mainMenu;
    private Main mainApp;
    private ServiceDefinitionController controller;

    public ServiceDefinitionUI(MainMenuAdminUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        try {
            this.controller = new ServiceDefinitionController();
        } catch (Exception e) {
            this.mainMenu.backToMainMenu();
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    public MainMenuAdminUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public ServiceDefinitionController getController() {
        return this.controller;
    }

    public void toServiceDefinitionScene1() {
        try {
            ServiceDefinitionUI1 serviceDefinitionSceneUI1 = (ServiceDefinitionUI1) this.mainApp.replaceSceneContent("/fxml/ServiceDefinition1.fxml");
            serviceDefinitionSceneUI1.setServiceDefinitionUI(this);
            serviceDefinitionSceneUI1.populateServiceTypeComboBox();
        } catch (Exception ex) {
        }
    }

    public void toServiceDefinitionScene2(ServiceDefinitionUI1 parentUI) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Add aditional information");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ServiceDefinition2.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            ServiceDefinitionUI2 serviceDefinitionUI2 = fxmlLoader.getController();
            serviceDefinitionUI2.setServiceDefinitionUI(this);
            serviceDefinitionUI2.setParentUI(parentUI);
            serviceDefinitionUI2.populateFields();
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();
        }
    }

    public void toServiceDefinitionScene3() {
        try {
            ServiceDefinitionUI3 serviceDefinitionSceneUI3 = (ServiceDefinitionUI3) this.mainApp.replaceSceneContent("/fxml/ServiceDefinition3.fxml");
            serviceDefinitionSceneUI3.setServiceDefinitionUI(this);
            serviceDefinitionSceneUI3.displayText();
        } catch (Exception ex) {
        }
    }

}
