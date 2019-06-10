package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.AddNewAddressToClientController;

public class AddAddressToClientUI {

    private MainMenuClientUI mainMenu;
    private Main mainApp;
    private AddNewAddressToClientController controller;

    public AddAddressToClientUI(MainMenuClientUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new AddNewAddressToClientController();
    }

    public MainMenuClientUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public AddNewAddressToClientController getController() {
        return this.controller;
    }

    public void toAddAddressToClientScene1() {
        try {
            AddAddressToClientUI1 addAddressToClientSceneUI1 = (AddAddressToClientUI1) this.mainApp.replaceSceneContent("/fxml/AddAddressToClient1.fxml");
            addAddressToClientSceneUI1.setAddAddressToClientUI(this);
            addAddressToClientSceneUI1.getAddressTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toAddAddressToClientScene2() {
        try {
            AddAddressToClientUI2 addAddressToClientSceneUI2 = (AddAddressToClientUI2) this.mainApp.replaceSceneContent("/fxml/AddAddressToClient2.fxml");
            addAddressToClientSceneUI2.setAddAddressToClientUI(this);
        } catch (Exception e) {
        }
    }

}