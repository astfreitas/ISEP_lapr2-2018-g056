package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EvaluateSPUI2 implements Initializable {

    private EvaluateSPUI evaluateSPUI;

    @FXML
    private Button closeBtn;
    @FXML
    private BarChart<?, ?> ratingsBarChart;
    @FXML
    private TextField popAverageTxt;
    @FXML
    private TextField popStdDevTxt;
    @FXML
    private TextField spAverageTxt;
    @FXML
    private TextField spDevTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setEvaluateSPUI(EvaluateSPUI evaluateSPUI) {
        this.evaluateSPUI = evaluateSPUI;
    }

    @FXML
    private void handleCloseBtn(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}