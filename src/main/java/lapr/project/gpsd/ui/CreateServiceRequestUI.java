package lapr.project.gpsd.ui;

import javafx.stage.Stage;
import lapr.project.gpsd.controller.CreateServiceRequestController;

public class CreateServiceRequestUI {
    private Main mainApp;
    private CreateServiceRequestController controller;

    public CreateServiceRequestUI(Main mainApp) {
        this.mainApp = mainApp;
        this.controller = new CreateServiceRequestController();
    }

    public Main getMainApp() {
        return this.mainApp;
    }

    public CreateServiceRequestController getController() {
        return this.controller;
    }

    public void toCreateServiceRequestControllerScene1() {
        try {
            CreateServiceRequestUI1 createServiceRequestScene1UI 
                    = (CreateServiceRequestUI1)this.mainApp.replaceSceneContent("/fxml/CreateServiceRequest1.fxml");
            createServiceRequestScene1UI.setCreateServiceRequestSceneUI (this);
            createServiceRequestScene1UI.showClientAddresses();
        } catch (Exception ex) {
        }
    }

    public void toCreateServiceRequestControllerScene2() {
        try {
            CreateServiceRequestUI2 createServiceRequestScene2UI
                    = (CreateServiceRequestUI2) this.mainApp.replaceSceneContent("/fxml/CreateServiceRequest2.fxml");
            createServiceRequestScene2UI.setCreateServiceRequestSceneUI (this);
            createServiceRequestScene2UI.setupServiceRequestDescriptionTable();
        } catch (Exception ex) {
        }
    }

    public void toCreateServiceRequestControllerScene3() {
        try {
            CreateServiceRequestUI3 createServiceRequestScene3UI
                    = (CreateServiceRequestUI3) this.mainApp.
                            replaceSceneContent("/fxml/CreateServiceRequest3.fxml");
            createServiceRequestScene3UI.setCreateServiceRequestSceneUI (this);
            //createServiceRequestScene3UI.showClient();
        } catch (Exception ex) {
        }
    }
    
    public void toCreateServiceRequestControllerScene4() {
        try {
            CreateServiceRequestUI4 createServiceRequestScene4UI
                    = (CreateServiceRequestUI4) this.mainApp.
                            replaceSceneContent("/fxml/CreateServiceRequest4.fxml");
            createServiceRequestScene4UI.setCreateServiceRequestSceneUI (this);
            //createServiceRequestScene3UI.showClient();
        } catch (Exception ex) {
        }
    }
    
    public void toCreateServiceRequestControllerScene5() {
        try {
            CreateServiceRequestUI5 createServiceRequestScene5UI
                    = (CreateServiceRequestUI5) this.mainApp.
                            replaceSceneContent("/fxml/CreateServiceRequest5.fxml");
            createServiceRequestScene5UI.setCreateServiceRequestSceneUI (this);
            //createServiceRequestScene3UI.showClient();
        } catch (Exception ex) {
        }
    }
    
    
}
