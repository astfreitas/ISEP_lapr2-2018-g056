package lapr.project.gpsd.ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.stage.*;
import lapr.project.gpsd.controller.RegisterServiceProviderController;
import lapr.project.utils.UIUtils;

public class RegisterServiceProviderUI {

    private Main mainApp;
    private RegisterServiceProviderController controller;
    private final MainMenuHROUI mainMenu;

    public RegisterServiceProviderUI(MainMenuHROUI mainMenu, Main mainApp) {
        this.mainApp = mainApp;
        this.mainMenu = mainMenu;
        try {
            this.controller = new RegisterServiceProviderController();
        } catch (Exception e) {
            this.mainMenu.backToMainMenu();
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }

    }

    public Main getMainApp() {
        return mainApp;
    }

    public RegisterServiceProviderController getController() {
        return controller;
    }

    public MainMenuHROUI getMainMenu() {
        return mainMenu;
    }
    
    

    public void toRegisterServiceProviderScene1() {
        try {
            RegisterServiceProviderUI1 registerServiceProviderUI1 = (RegisterServiceProviderUI1) this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider1.fxml");
            registerServiceProviderUI1.setRegisterServiceProviderUI(this);
            registerServiceProviderUI1.populateNifComboBox();
        } catch (Exception ex) {
        }
    }

    public void toRegisterServiceProviderScene2() {
        try {
            RegisterServiceProviderUI2 registerServiceProviderUI2 = (RegisterServiceProviderUI2) this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider2.fxml");
            registerServiceProviderUI2.setRegisterServiceProviderUI(this);
            registerServiceProviderUI2.updateList();
        } catch (Exception ex) {
        }
    }

    public void toRegisterServiceProviderScene3() {
        try {
            RegisterServiceProviderUI3 registerServiceProviderUI3 = (RegisterServiceProviderUI3) this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider3.fxml");
            registerServiceProviderUI3.setRegisterServiceProviderUI(this);
            registerServiceProviderUI3.updateList();
        } catch (Exception ex) {
        }
    }

    public void toRegisterServiceProviderScene4() {
        try {
            RegisterServiceProviderUI4 registerServiceProviderUI4 = (RegisterServiceProviderUI4) this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider4.fxml");
            registerServiceProviderUI4.setRegisterServiceProviderUI(this);
            registerServiceProviderUI4.displayText();
        } catch (Exception ex) {
        }
    }
    
        public void toRegisterServiceProviderScene5(RegisterServiceProviderUI2 parentUI) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Add category");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegisterServiceProvider5.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            RegisterServiceProviderUI5 registerServiceProviderUI5 = fxmlLoader.getController();
            registerServiceProviderUI5.setRegisterServiceProviderUI(this);
            registerServiceProviderUI5.setParentUI(parentUI);
            registerServiceProviderUI5.populateComboBox();
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();        }
    }

    public void toRegisterServiceProviderScene6(RegisterServiceProviderUI3 parentUI) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Add geographic area");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegisterServiceProvider6.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            RegisterServiceProviderUI6 registerServiceProviderUI6 = fxmlLoader.getController();
            registerServiceProviderUI6.setRegisterServiceProviderUI(this);
            registerServiceProviderUI6.setParentUI(parentUI);
            registerServiceProviderUI6.populateComboBox();
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();        }
    }


}
