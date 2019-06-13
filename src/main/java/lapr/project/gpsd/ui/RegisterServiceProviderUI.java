package lapr.project.gpsd.ui;

import javafx.scene.control.Alert;
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
            registerServiceProviderUI2.populateCatList();
        } catch (Exception ex) {
        }
    }

    public void toRegisterServiceProviderScene3() {
        try {
            RegisterServiceProviderUI3 registerServiceProviderUI3 = (RegisterServiceProviderUI3) this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider3.fxml");
            registerServiceProviderUI3.setRegisterServiceProviderUI(this);
            registerServiceProviderUI3.populateAreasList();
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

}
