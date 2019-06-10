package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;


public class CreateServiceRequestUI3 implements Initializable {

    private CreateServiceRequestUI createServiceRequestUI;
    
    @FXML
    private Button cancelBtn;
    @FXML
    private Button addServiceBtn;
    @FXML
    private ComboBox<Category> categoryComboBox;
    @FXML
    private ListView<Service> serviceListView;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private ComboBox<Integer> hourComboBox;
    @FXML
    private ComboBox<Integer> minuteComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCancelButton(ActionEvent event) {
        this.createServiceRequestUI.getMainApp().toMainScene();
    }

    @FXML
    private void handleContinueBtn(ActionEvent event) {
        this.createServiceRequestUI.toCreateServiceRequestControllerScene4();
    }
    
    void setCreateServiceRequestSceneUI(CreateServiceRequestUI createServiceRequestUI) {
        this.createServiceRequestUI = createServiceRequestUI;
    }
    
    void setupScheduleControls() {
        
        for(int i=0; i<23; i++) {
            hourComboBox.getItems().add(i);
        }
        for(int i=0; i<60; i+=30) {
            minuteComboBox.getItems().add(i);
        }
    }
    
}
