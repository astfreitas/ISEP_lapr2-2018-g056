package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.EvaluateSPController;

public class EvaluateSPUI {

    private MainMenuAdminUI mainMenu;
    private Main mainApp;
    private EvaluateSPController controller;

    public EvaluateSPUI(MainMenuAdminUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new EvaluateSPController();
    }

    public MainMenuAdminUI getMainMenu() {
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
        } catch (Exception ex) {
        }
    }

    public void toEvaluateSPScene2() {
        try {
            EvaluateSPUI2 evaluateSPSceneUI2 = (EvaluateSPUI2) this.mainApp.replaceSceneContent("/fxml/EvaluateSP2.fxml");
            evaluateSPSceneUI2.setEvaluateSPUI(this);
        } catch (Exception e) {
        }
    }

    public void toEvaluateSPScene3() {
        try {
            EvaluateSPUI3 evaluateSPSceneUI3 = (EvaluateSPUI3) this.mainApp.replaceSceneContent("/fxml/EvaluateSP3.fxml");
            evaluateSPSceneUI3.setEvaluateSPUI(this);
        } catch (Exception e) {
        }
    }

}
