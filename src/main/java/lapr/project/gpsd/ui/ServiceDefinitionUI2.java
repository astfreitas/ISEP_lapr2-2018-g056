package lapr.project.gpsd.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import lapr.project.utils.UIUtils;

public class ServiceDefinitionUI2 {

    private ServiceDefinitionUI serviceDefinitionUI;
    private ServiceDefinitionUI1 parentUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button confirmBtn;
    @FXML
    private Text aditionalInformationLabel;
    @FXML
    private TextArea informationTxt;

    public void setServiceDefinitionUI(ServiceDefinitionUI serviceDefinitionUI) {
        this.serviceDefinitionUI = serviceDefinitionUI;
    }

    public void setParentUI(ServiceDefinitionUI1 serviceDefinitionUI1) {
        this.parentUI = serviceDefinitionUI1;
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleConfirmBtn(ActionEvent event) {
        String data = null;
        try {
            data = informationTxt.getText();
        } catch(Exception e) {}
        try {
            serviceDefinitionUI.getController().setAdditionalData(data);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            serviceDefinitionUI.toServiceDefinitionScene3();
        } catch (Exception e) {
            UIUtils.createAlert(e.getMessage(), "Error:", Alert.AlertType.ERROR);
        }
    }

    /**
     * currently only supports one aditional attribute
     */
    void populateFields() {
        String text = serviceDefinitionUI.getController().getOtherAttributes().get(0);
        aditionalInformationLabel.setText(text);
    }

}
