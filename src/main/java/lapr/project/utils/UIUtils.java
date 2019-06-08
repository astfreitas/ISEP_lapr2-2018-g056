package lapr.project.utils;

import javafx.scene.control.Alert;

public class UIUtils {

    /**
     *
     * Creats an alert based on the data that comes as parameters
     *
     * @param message Alert message
     * @param header Alert header
     * @param alertType Type of Alert
     */
    public static void createAlert(String message, String header, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }

    public static void about() {
        Alert about = new Alert(Alert.AlertType.INFORMATION);

        about.setTitle("ApplicationGPSD");
        about.setHeaderText("About");
        about.setContentText("Laboratory/Project 2"
                + "\nAcademic Year 2018/2019"
                + "\nMade by:"
                + "\nAntónio Freitas - 1141729"
                + "\nBreno Pacheco - 1180005"
                + "\nMaria João Dias - 1171865"
                + "\nJoão Ferreira - 1181436"
                + "\nJosué Mota - 1171668");

        about.show();

    }
}
