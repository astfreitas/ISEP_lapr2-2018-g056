package lapr.project.gpsd.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class RateSPUI3 implements Initializable {

    private RateSPUI rateSPUI;

    @FXML
    private Button finishBtn;
    @FXML
    private TextArea invoiceTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleFinishBtn(ActionEvent event) {
        this.rateSPUI.getMainMenu().backToMainMenu();
    }

    public void showInvoice() {
        double totalCost = this.rateSPUI.getController().getServiceCost() + this.rateSPUI.getController().getTravelCost();
        String invoice = "Client:\n"
                + "\tName: " + this.rateSPUI.getController().getClient().getName()
                + "\nAddress: " + this.rateSPUI.getController().getServiceRequest().getAddress()
                + "\nNIF: " + this.rateSPUI.getController().getClient().getNIF()
                + "\n"
                + "Service Provider:\n"
                + "\tName: " + this.rateSPUI.getController().getServiceProvider(this.rateSPUI.getController().getServOrder()).getName()
                + "\nNIF: " + this.rateSPUI.getController().getServiceProvider(this.rateSPUI.getController().getServOrder()).getNif()
                + "\n"
                + "Service:"
                + "\tDescription: " + this.rateSPUI.getController().getServOrder().getServiceRequestDescription().getService().getBriefDescription()
                + "\tService Cost: " + String.valueOf(this.rateSPUI.getController().getServiceCost())
                + "\nTravel Cost: " + String.valueOf(this.rateSPUI.getController().getTravelCost())
                + "\n\n Total Cost: " + String.valueOf(totalCost);
        invoiceTxt.setText(invoice);
                
    }

    void setRateSPUI(RateSPUI rateSPUI) {
        this.rateSPUI = rateSPUI;
    }
}
