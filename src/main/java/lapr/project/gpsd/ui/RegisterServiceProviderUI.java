
package lapr.project.gpsd.ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.RegisterServiceProviderController;
import lapr.project.utils.UIUtils;


public class RegisterServiceProviderUI {
    
    private Main mainApp;
    private RegisterServiceProviderController controller;
    private final MainMenuHROUI mainMenu;

    public RegisterServiceProviderUI(MainMenuHROUI mainMenu, Main mainApp) {
        this.mainApp = mainApp;
        this.mainMenu = mainMenu;
        this.controller = new RegisterServiceProviderController();
    }

    public Main getMainApp() {
        return mainApp;
    }

    public RegisterServiceProviderController getController() {
        return controller;
    }
    
    public void toRegisterServiceProviderScene1() {
        try {
            RegisterServiceProviderUI1 registerServiceProviderUI1 = (RegisterServiceProviderUI1)this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider1.fxml");
            registerServiceProviderUI1.setRegisterServiceProviderUI(this);
            registerServiceProviderUI1.getNameTxt().requestFocus();
        } catch (Exception ex) {
        }
    }
    
    public void toRegisterServiceProviderScene2(RegisterServiceProviderUI1 parentUI) {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Modify address");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/RegisterServiceProvider2.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            RegisterServiceProviderUI2 registerServiceProviderUI2 = fxmlLoader.getController();
            registerServiceProviderUI2.setRegisterServiceProviderUI(this);
            registerServiceProviderUI2.setParentUI(parentUI);
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();        }
        
        
    }
    
    public void toRegisterServiceProviderScene3() {
        try {
            RegisterServiceProviderUI3 registerServiceProviderScene3UI
                    = (RegisterServiceProviderUI3) this.mainApp.
                            replaceSceneContent("/fxml/RegisterServiceProvider3.fxml");
            registerServiceProviderScene3UI.setRegisterServiceProviderUI(this);
        } catch (Exception ex) {
        }
    }
    
}
