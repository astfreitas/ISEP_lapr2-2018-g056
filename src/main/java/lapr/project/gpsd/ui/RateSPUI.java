package lapr.project.gpsd.ui;

import lapr.project.gpsd.controller.RatingServiceProviderController;

public class RateSPUI {

    private MainMenuClientUI mainMenu;
    private Main mainApp;
    private RatingServiceProviderController controller;

    public RateSPUI(MainMenuClientUI mainMenu, Main mainApp) {
        this.mainMenu = mainMenu;
        this.mainApp = mainApp;
        this.controller = new RatingServiceProviderController();
    }

    public MainMenuClientUI getMainMenu() {
        return this.mainMenu;
    }

    public Main getMainApp() {
        return mainApp;
    }

    public RatingServiceProviderController getController() {
        return this.controller;
    }

    public void toSpecifyCategoryScene1() {
        try {
            RateSPUI1 rateSPUI1 = (RateSPUI1) this.mainApp.replaceSceneContent("/fxml/RateSP1.fxml");
            rateSPUI1.setRateSPUI(this);
            rateSPUI1.populateServOrderList();
        } catch (Exception ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void toSpecifyCategoryScene2() {
        try {
            RateSPUI2 rateSPUI2 = (RateSPUI2) this.mainApp.replaceSceneContent("/fxml/RateSP2.fxml");
            rateSPUI2.setRateSPUI(this);
        } catch (Exception ex) {
            
        }
    }
    
    public void toSpecifyCategoryScene3() {
        try {
            RateSPUI3 rateSPUI3 = (RateSPUI3) this.mainApp.replaceSceneContent("/fxml/RateSP3.fxml");
            rateSPUI3.setRateSPUI(this);
            rateSPUI3.showInvoice();
        } catch (Exception ex) {
            
        }
    }
}
