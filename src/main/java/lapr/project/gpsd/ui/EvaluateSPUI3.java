package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class EvaluateSPUI3 implements Initializable {

    private EvaluateSPUI evaluateSPUI;
    private EvaluateSPUI1 parentUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private ComboBox<String> labelComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        confirmBtn.setDisable(true);
    }

    public void setEvaluateSPUI(EvaluateSPUI evaluateSPUI) {
        this.evaluateSPUI = evaluateSPUI;
    }

    public void setParentUI(EvaluateSPUI1 parentUI) {
        this.parentUI = parentUI;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        evaluateSPUI.getController().setLabel(labelComboBox.getValue());
        parentUI.updateLabel();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleLabelComboBox(ActionEvent event) {
        confirmBtn.setDisable(false);
    }

    void populateFields() {
        List<String> labels = evaluateSPUI.getController().getLabels();
        labelComboBox.getItems().addAll(labels);
    }

}
