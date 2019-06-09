package lapr.project.gpsd.ui;

import javafx.stage.Stage;

public class MainMenuUI {

    private Main mainApp;
    private Stage stage;

    public MainMenuUI(Main mainApp, Stage stage) {
        this.mainApp = mainApp;
        this.stage = stage;
    }

    public void toMainMenuClient() {
        try {
            MainMenuClientUI mainMenu = (MainMenuClientUI) this.mainApp.replaceSceneContent("/fxml/MainMenuClient.fxml");
            mainMenu.setMainApp(mainApp);
            mainMenu.setMainMenuUI(this);
        } catch (Exception ex) {
        }
    }

    public void toMainMenuAdmin() {
        try {
            MainMenuAdminUI mainMenu = (MainMenuAdminUI) this.mainApp.replaceSceneContent("/fxml/MainMenuAdmin.fxml");
            mainMenu.setMainApp(mainApp);
            mainMenu.setMainMenuUI(this);
        } catch (Exception ex) {
        }
    }

    public void toMainMenuHRO() {
        try {
            MainMenuHROUI mainMenu = (MainMenuHROUI) this.mainApp.replaceSceneContent("/fxml/MainMenuHRO.fxml");
            mainMenu.setMainApp(mainApp);
            mainMenu.setMainMenuUI(this);
        } catch (Exception ex) {
        }
    }
}
