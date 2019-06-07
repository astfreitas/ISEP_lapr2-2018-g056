package lapr.project.gpsd.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lapr.project.gpsd.controller.RegisterClientController;

public class RegisterClientUI implements Initializable {

    @FXML
    private Button cancelBtn;
    @FXML
    private Button continueBtn;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nifTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private TextField telephoneTxt;
    @FXML
    private PasswordField pwdTxt;
    private RegisterClientController registerClientController;
    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.registerClientController = new RegisterClientController();
    }

    /**
     * 
     * Sets the Stage that comes as a parameter
     * 
     * @param stage Dtage being defined
     */
    public void setStage(Stage stage) {
        this.stage = stage;
        this.scene = stage.getScene();
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
        
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) throws IOException {
        String name = nameTxt.getText();
        String NIF = nifTxt.getText();
        String telephone = telephoneTxt.getText();
        String email = emailTxt.getText();
        String pwd = pwdTxt.getText();
        
        this.registerClientController.newClient(name, NIF, telephone, email, pwd);
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AddressesWindow.fxml"));
        AddressesWindowUI addressesWindow = fxmlLoader.getController();
        Parent root = (Parent) fxmlLoader.load();
        Scene newScene = new Scene(root);
        addressesWindow.setParentController(registerClientController);
        stage.setScene(newScene);
    }
    
}
