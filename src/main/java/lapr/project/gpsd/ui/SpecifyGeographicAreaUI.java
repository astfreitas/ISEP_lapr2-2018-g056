package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.GeographicAreaSpecController;

public class SpecifyGeographicAreaUI {

    private MainMenuAdminUI mainMenu;
    private Main mainApp;
    private GeographicAreaSpecController controller;

    public SpecifyGeographicAreaUI(MainMenuAdminUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new GeographicAreaSpecController();
    }

    public MainMenuAdminUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public GeographicAreaSpecController getController() {
        return this.controller;
    }

    public void toSpecifyCategoryScene1() {
        try {
            SpecifyGeographicAreaUI1 specifyGeographicAreaUI1 = (SpecifyGeographicAreaUI1) this.mainApp.replaceSceneContent("/fxml/SpecifyGeographicAreaUI1.fxml");
            specifyGeographicAreaUI1.setSpecifyGeographicAreaUI(this);
        } catch (Exception ex) {
        }
    }

//    public void toSpecifyCategoryScene2() {
//        try {
//            SpecifyCategoryUI2 specifyCategorySceneUI2 = (SpecifyCategoryUI2) this.mainApp.replaceSceneContent("/fxml/SpecifyCategory2.fxml");
//            specifyCategorySceneUI2.setSpecifyCategoryUI(this);
//            specifyCategorySceneUI2.showCategory();
//        } catch (Exception e) {
//        }
//    }

}
