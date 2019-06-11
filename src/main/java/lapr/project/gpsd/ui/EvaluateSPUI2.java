package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EvaluateSPUI2 implements Initializable {

    private EvaluateSPUI evaluateSPUI;

    @FXML
    private Button closeBtn;
    @FXML
    private BarChart<String, Number> ratingsBarChart;
    @FXML
    private TextField popAverageTxt;
    @FXML
    private TextField popStdDevTxt;
    @FXML
    private TextField spAverageTxt;
    @FXML
    private TextField spDevTxt;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        popAverageTxt.setDisable(true);
        popStdDevTxt.setDisable(true);
        spAverageTxt.setDisable(true);
        spDevTxt.setDisable(true);

    }

    public void setEvaluateSPUI(EvaluateSPUI evaluateSPUI) {
        this.evaluateSPUI = evaluateSPUI;
    }

    public void populateFields() {
        double par = evaluateSPUI.getController().getPopulationMeanAverageRating();
        double pstd = evaluateSPUI.getController().getPopulationStdDeviation();
        double ar = evaluateSPUI.getController().getSpAverageRating();
        double std = evaluateSPUI.getController().getSpAbsoluteDifference();
        List<Integer> ratings = evaluateSPUI.getController().getSpRatings();
        popAverageTxt.setText(String.valueOf(par));
        popStdDevTxt.setText(String.valueOf(pstd));
        spAverageTxt.setText(String.valueOf(ar));
        spDevTxt.setText(String.valueOf(std));
        fillBarChart(ratings);
    }

    @FXML
    private void handleCloseBtn(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void fillBarChart(List<Integer> ratings) {
        yAxis.setLabel("Frequency");
        xAxis.setLabel("Rating");
        XYChart.Series<String, Number> series = new XYChart.Series();

        System.out.println(Collections.max(ratings));
        int[] bins = new int[5];
        if (Collections.max(ratings) > 5) {
            bins = new int[Collections.max(ratings)];
        }

        for (Integer rating : ratings) {
            bins[rating - 1] += 1;
        }

        for (int i = 0; i < bins.length; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(i), bins[i]));
        }

        ratingsBarChart.getData().add(series);
    }

}
