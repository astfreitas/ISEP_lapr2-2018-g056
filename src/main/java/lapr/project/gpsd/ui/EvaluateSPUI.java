package lapr.project.gpsd.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.EvaluateSPController;

public class EvaluateSPUI {

    private MainMenuHROUI mainMenu;
    private Main mainApp;
    private EvaluateSPController controller;
    private EvaluateSPUI1 evaluateSPSceneUI1;

    public EvaluateSPUI(MainMenuHROUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new EvaluateSPController();
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
            this.evaluateSPSceneUI1 = (EvaluateSPUI1) this.mainApp.replaceSceneContent("/fxml/EvaluateSP1.fxml");
            evaluateSPSceneUI1.setEvaluateSPUI(this);
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
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(EvaluateSPUI.class.getName()).log(Level.SEVERE, null, ex);
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
            newStage.setScene(newScene);
            newStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(EvaluateSPUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
