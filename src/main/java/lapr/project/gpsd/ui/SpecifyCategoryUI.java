package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.SpecifyCategoryController;

public class SpecifyCategoryUI {

    private MainMenuAdminUI mainMenu;
    private Main mainApp;
    private SpecifyCategoryController controller;

    public SpecifyCategoryUI(MainMenuAdminUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new SpecifyCategoryController();
    }

    public MainMenuAdminUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public SpecifyCategoryController getController() {
        return this.controller;
    }

    public void toSpecifyCategoryScene1() {
        try {
            SpecifyCategoryUI1 specifyCategorySceneUI1 = (SpecifyCategoryUI1) this.mainApp.replaceSceneContent("/fxml/SpecifyCategory1.fxml");
            specifyCategorySceneUI1.setSpecifyCategoryUI(this);
            specifyCategorySceneUI1.getCatCodeTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toSpecifyCategoryScene2() {
        try {
            SpecifyCategoryUI2 specifyCategorySceneUI2 = (SpecifyCategoryUI2) this.mainApp.replaceSceneContent("/fxml/SpecifyCategory2.fxml");
            specifyCategorySceneUI2.setSpecifyCategoryUI(this);
            specifyCategorySceneUI2.showCategory();
        } catch (Exception e) {
        }
    }

}
