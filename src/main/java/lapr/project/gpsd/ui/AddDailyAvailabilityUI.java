package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.AddDailyAvailabilityController;

public class AddDailyAvailabilityUI {

    private MainMenuSPUI mainMenu;
    private Main mainApp;
    private AddDailyAvailabilityController controller;

    public AddDailyAvailabilityUI(MainMenuSPUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new AddDailyAvailabilityController();
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

    public void toAddAvailabilityScene1() {
        try {
            AddDailyAvailabilityUI1 addDailyAvailabilityUI1 = (AddDailyAvailabilityUI1) this.mainApp.replaceSceneContent("/fxml/AddDailyAvailability1.fxml");
            addDailyAvailabilityUI1.setAddDailyAvailabilityUI(this);
            addDailyAvailabilityUI1.populateFreqCombobox();
            addDailyAvailabilityUI1.populateTimeComboboxes();
        } catch (Exception e) {
        }

    }

    public void toAddAvailabilityScene2() {
        try {
            AddDailyAvailabilityUI2 addDailyAvailabilityUI2 = (AddDailyAvailabilityUI2) this.mainApp.replaceSceneContent("/fxml/AddDailyAvailability2.fxml");
            addDailyAvailabilityUI2.setAddDailyAvailabilityUI(this);
            addDailyAvailabilityUI2.showConfirmTxt();
        } catch (Exception e) {
        }
    }

    /**
     * Returns AddDailyAvailability Controller instance
     *
     * @return AddDailyAvailability Controller instance
     */
    public AddDailyAvailabilityController getController() {
        return controller;
    }
}
