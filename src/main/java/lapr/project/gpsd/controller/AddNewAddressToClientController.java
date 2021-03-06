package lapr.project.gpsd.controller;

import lapr.project.authentication.model.*;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;

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
     * 
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
     *
     * @param local Local
     * @param postalCode Postal Code
     * @param address Address
     */
    public void newAddress(String local, String postalCode, String address) {
        this.address = Client.newAddress(local, postalCode, address);
    }

    /**
     * Register address to Client's Address list
     *
     * @return The success of the operation
     */
    public boolean registerAddress() {
        return cli.addAddress(address);
    }
    
    /**
     * 
     * Returns the address
     * 
     * @return Address
     */
    public Address getAddress() {
        return address;
    }

}
