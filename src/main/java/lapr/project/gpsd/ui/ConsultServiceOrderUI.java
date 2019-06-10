package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.ConsultServiceOrderController;

/**
 * FXML Controller class
 *
 * @author astfr
 */
public class ConsultServiceOrderUI {

    private MainMenuSPUI mainMenu;
    private Main mainApp;
    private ConsultServiceOrderController controller;

    public ConsultServiceOrderUI(MainMenuSPUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new ConsultServiceOrderController();
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

    public void toConsultServiceOrderScene1() {
        try {
            ConsultServiceOrderUI1 consultServOrderUI1 = (ConsultServiceOrderUI1) this.mainApp.replaceSceneContent("/fxml/ConsultServiceOrderUI1.fxml");
            consultServOrderUI1.setConsultServOrderUI(this);
            consultServOrderUI1.getStartDate().requestFocus();
        } catch (Exception e) {
        }

    }

    public void toConsultServiceOrderScene2() {

    }

}
