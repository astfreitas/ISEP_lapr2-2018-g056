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
             MainMenuClientUI mainMenu = (MainMenuClientUI)this.mainApp.replaceSceneContent("/fxml/MainMenuClient.fxml");
        } catch (Exception ex) {
        }
    }
}
