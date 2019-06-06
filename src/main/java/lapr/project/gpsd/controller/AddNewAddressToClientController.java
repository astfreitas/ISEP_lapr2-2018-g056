package lapr.project.gpsd.controller;

import lapr.project.authentication.model.*;
import lapr.project.gpsd.model.*;

public class AddNewAddressToClientController {

    private Company company;
    private Client cli;
    private Address address;

    /**
     * Verifies if User in current Session is a Client
     */
    public AddNewAddressToClientController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }

    /**
     * Starts the new address request and retrieves the client for the current
     * session
     *
     */
    public void newAddressRequest() {
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        ClientRegistry rc = company.getClientRegistry();
        this.cli = rc.getClientByEmail(email);
    }
    
    /**
     * Creates new Address for Client
     * @param local
     * @param postalCode
     * @param address
     * @return 
     */
    public Address newAddress(String local, String postalCode, String address) {
        this.address = Client.newAddress(local, postalCode, local);
        return this.address;
    }
    
    /**
     * Register address to Client's Address list
     * @return 
     */
    public boolean registerAddress() {
        return cli.addAddress(address);
    }
}
