package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.AcceptServiceRequestController;


public class AcceptServiceRequestAssignmentsUI {
    private MainMenuClientUI mainMenu;
    private Main mainApp;
    private AcceptServiceRequestController controller;

    public AcceptServiceRequestAssignmentsUI(MainMenuClientUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new AcceptServiceRequestController();
    }

    public MainMenuClientUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public AcceptServiceRequestController getController() {
        return this.controller;
    }

    public void toAcceptServiceRequestScene1() {
        try {
            AcceptServiceRequestAssignmentsUI1 acceptServiceRequestAssignmentsUI1 = 
                    (AcceptServiceRequestAssignmentsUI1) this.mainApp.replaceSceneContent("/fxml/AcceptServiceRequest1.fxml");
            acceptServiceRequestAssignmentsUI1.setAcceptServiceRequestUI(this);
            acceptServiceRequestAssignmentsUI1.setupAcceptServiceRequestAssignmentScene();
        } catch (Exception ex) {
        }
    }
    
}
