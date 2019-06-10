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
            specifyGeographicAreaUI1.getDesignationText().requestFocus();
            
        } catch (Exception ex) {
        }
    }

    public void toSpecifyCategoryScene2() {
        try {
            SpecifyGeographicAreaUI2 specifyCategorySceneUI2 = (SpecifyGeographicAreaUI2) this.mainApp.replaceSceneContent("/fxml/SpecifyGeographicAreaUI2.fxml");
            specifyCategorySceneUI2.setSpecifyGeographicAreaUI(this);
            specifyCategorySceneUI2.showGeographicArea();
        } catch (Exception e) {
        }
    }

}
