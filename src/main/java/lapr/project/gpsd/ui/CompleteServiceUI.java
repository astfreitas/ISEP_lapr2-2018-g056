package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.CompleteServiceController;

public class CompleteServiceUI {

    private MainMenuSPUI mainMenu;
    private Main mainApp;
    private CompleteServiceController controller;

    public CompleteServiceUI(MainMenuSPUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new CompleteServiceController();
    }

    /**
     * Returns the reference for instance to the main menu for SP
     *
     * @return instance of MainMenuSPUI
     */
    public MainMenuSPUI getMainMenu() {
        return this.mainMenu;
    }

    /**
     * Returns the reference for the MainApp instance
     *
     * @return reference for the MainApp instance
     */
    public Main getMainApp() {
        return mainApp;
    }

    public void toCompleteServiceScene1() {
        try {
            CompleteServiceUI1 consultServOrderUI1 = (CompleteServiceUI1) this.mainApp.replaceSceneContent("/fxml/CompleteService1.fxml");
            consultServOrderUI1.setCompleteServiceUI(this);
            consultServOrderUI1.populateServiceList();
        } catch (Exception e) {
        }
    }

    public void toCompleteServiceScene2() {
        try {
            CompleteServiceUI2 consultServOrderUI2 = (CompleteServiceUI2) this.mainApp.replaceSceneContent("/fxml/CompleteService2.fxml");
            consultServOrderUI2.setCompleteServiceUI(this);
            consultServOrderUI2.showServiceInfo();
        } catch (Exception e) {

        }
    }

    /**
     * Returns ConsulServiceOrder Controller instance
     *
     * @return ConsulServiceOrder Controller instance
     */
    public CompleteServiceController getController() {
        return controller;
    }
}
