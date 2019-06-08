package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.RegisterClientController;

public class RegisterClientUI {

    private Main mainApp;
    private RegisterClientController controller;

    public RegisterClientUI(Main mainApp) {
        this.mainApp = mainApp;
        this.controller = new RegisterClientController();
    }

    public Main getMainApp() {
        return this.mainApp;
    }

    public RegisterClientController getController() {
        return this.controller;
    }

    public void toRegisterClientScene1() {
        try {
            RegisterClientUI1 registerClientScene1UI = (RegisterClientUI1)this.mainApp.replaceSceneContent("/fxml/RegisterClient1.fxml");
            registerClientScene1UI.setRegisterClientUI(this);
            registerClientScene1UI.getNameTxt().requestFocus();
        } catch (Exception ex) {
        }
    }

    public void toRegisterClientScene2() {
        try {
            RegisterClientUI2 registerClientScene2UI
                    = (RegisterClientUI2) this.mainApp.
                            replaceSceneContent("/fxml/RegisterClient2.fxml");
            registerClientScene2UI.setRegisterClientUI(this);
        } catch (Exception ex) {
        }
    }

    public void toRegisterClientScene3() {
        try {
            RegisterClientUI3 registerClientSceneUI3
                    = (RegisterClientUI3) this.mainApp.
                            replaceSceneContent("/fxml/RegisterClient3.fxml");
            registerClientSceneUI3.setRegisterClientUI(this);
            registerClientSceneUI3.showClient();
        } catch (Exception ex) {
        }
    }
}
