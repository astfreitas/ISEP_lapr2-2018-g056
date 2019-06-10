package lapr.project.gpsd.ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.EvaluateSPController;
import lapr.project.utils.UIUtils;

public class EvaluateSPUI {

    private MainMenuHROUI mainMenu;
    private Main mainApp;
    private EvaluateSPController controller;

    public EvaluateSPUI(MainMenuHROUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        try {
            this.controller = new EvaluateSPController();
        } catch (Exception e) {
            this.mainMenu.backToMainMenu();
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    public MainMenuHROUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public EvaluateSPController getController() {
        return this.controller;
    }

    public void toEvaluateSPScene1() {
        try {
            EvaluateSPUI1 evaluateSPSceneUI1 = (EvaluateSPUI1) this.mainApp.replaceSceneContent("/fxml/EvaluateSP1.fxml");
            evaluateSPSceneUI1.setEvaluateSPUI(this);
            evaluateSPSceneUI1.populateSPComboBox();
        } catch (Exception ex) {
        }
    }

    public void toEvaluateSPScene2() {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Service Provider's Statistics");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EvaluateSP2.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            EvaluateSPUI2 evaluateSPUI2 = fxmlLoader.getController();
            evaluateSPUI2.setEvaluateSPUI(this);
            evaluateSPUI2.populateFields();
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();
        }
    }

    public void toEvaluateSPScene3() {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.setTitle("Change SP's classification");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EvaluateSP3.fxml"));
        Parent root;
        try {
            root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            EvaluateSPUI3 evaluateSPUI3 = fxmlLoader.getController();
            evaluateSPUI3.setEvaluateSPUI(this);
            evaluateSPUI3.populateFields();
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            UIUtils.createAlert(ex.getMessage(), "Error:", Alert.AlertType.ERROR);
            mainMenu.backToMainMenu();        }
    }

}
