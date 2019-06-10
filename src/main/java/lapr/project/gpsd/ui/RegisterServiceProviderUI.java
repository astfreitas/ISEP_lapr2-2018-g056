
package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.RegisterServiceProviderController;


public class RegisterServiceProviderUI {
    
    private Main mainApp;
    private RegisterServiceProviderController controller;

    public RegisterServiceProviderUI(Main mainApp) {
        this.mainApp = mainApp;
        this.controller = new RegisterServiceProviderController();
    }

    public Main getMainApp() {
        return mainApp;
    }

    public RegisterServiceProviderController getController() {
        return controller;
    }
    
    public void toRegisterServiceProviderScene1() {
        try {
            RegisterServiceProviderUI1 registerServiceProviderUI1 = (RegisterServiceProviderUI1)this.mainApp.replaceSceneContent("/fxml/RegisterServiceProvider1.fxml");
            registerServiceProviderUI1.setRegisterServiceProviderUI(this);
            registerServiceProviderUI1.getNameTxt().requestFocus();
        } catch (Exception ex) {
        }
    }
    
    public void toRegisterServiceProviderScene2() {
        try {
            RegisterServiceProviderUI2 registerServiceProviderScene2UI
                    = (RegisterServiceProviderUI2) this.mainApp.
                            replaceSceneContent("/fxml/RegisterServiceProvider2.fxml");
            registerServiceProviderScene2UI.setRegisterServiceProviderUI(this);
        } catch (Exception ex) {
        }
    }
    
}
