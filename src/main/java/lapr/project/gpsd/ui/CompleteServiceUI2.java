package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lapr.project.utils.UIUtils;

public class CompleteServiceUI2 implements Initializable {
    
    private CompleteServiceUI completeServiceUI;

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField servDateTxt;
    @FXML
    private TextField servTimeTxt;
    @FXML
    private TextField serviceTxt;
    @FXML
    private TextArea serviceCliTxt;
    @FXML
    private CheckBox issueToggle;
    @FXML
    private TextField issueTxt;
    @FXML
    private Button completeAnotherBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelBtn(ActionEvent event) {
        this.completeServiceUI.getMainMenu().backToMainMenu();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        if(issueToggle.isSelected()){
            this.completeServiceUI.getController().concludeServiceOrder();
        }else{
            if(issueTxt.getText().equals("")){
                UIUtils.createAlert("Please insert the issue description", "", Alert.AlertType.ERROR);
            }else{
                this.completeServiceUI.getController().concludeServiceOrderWithIssue(issueTxt.getText());
            }
        }
    }

    @FXML
    private void handleIssueToggle(ActionEvent event) {
        if(issueToggle.isSelected()){
            issueTxt.setDisable(true);
        }else{
            issueTxt.setDisable(false);
        }
    }
    
    public void setCompleteServiceUI(CompleteServiceUI completeServiceUI) {
       this.completeServiceUI = completeServiceUI;
    }
    
    public void showServiceInfo(){
        this.servDateTxt.setText(this.completeServiceUI.getController().getServOrder().getSchePref().getDate().toString());
        this.servTimeTxt.setText(this.completeServiceUI.getController().getServOrder().getSchePref().getTime().toString());
        this.serviceTxt.setText(this.completeServiceUI.getController().getServOrder().getServiceRequestDescription().getService().getBriefDescription());
        this.serviceCliTxt.setText(this.completeServiceUI.getController().getServOrder().getServiceRequestDescription().getDescription());
    }

    @FXML
    private void handleCompleteAnotherBtn(ActionEvent event) {
        this.completeServiceUI.toCompleteServiceScene1();
    }
}
