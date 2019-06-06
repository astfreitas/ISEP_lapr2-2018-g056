package lapr.project.gpsd.controller;

import lapr.project.gpsd.utils.Constants;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;

public class CreateServiceRequestController {
    
    Company company; 
    Client cli;
    
    public CreateServiceRequestController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }
    
    /**
     * Method will return the list of addresses from the logged in user.
     * @return returns list of addresses
     */
    public List<Address> newRequest() {
       ApplicationGPSD app = ApplicationGPSD.getInstance();
       UserSession session = app.getCurrentSession();
       String email = session.getUserEmail();
       ClientRegistry rc = company.getClientRegistry();
       cli = rc.getClientByEmail(email);
       return cli.getAddresses();
    }
    
    /**
     * Method that defines the address where the service will take place
     * @param local 
     * @param postalCode
     * @param address 
     */
    public void setAddress(String local, PostalCode postalCode, String address) {
        cli.getAddress(local, postalCode, address); 
    }
   
    
}
