package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.*;

public class RegisterClientController {

    private ApplicationGPSD app;
    private Company company;
    private ClientRegistry clientRegistry;
    private Client client;
    private String pwd;

    /**
     * 
     * Creates an instance of RegisterClientController
     * 
     */
    public RegisterClientController() {
        this.app = ApplicationGPSD.getInstance();
        this.company = app.getCompany();
    }

    /**
     * 
     * Sets the sequence of methods necessary to create a valid Client
     * 
     * @param name Client's name
     * @param NIF Client's NIF 
     * @param telephone Client's telephone
     * @param email Client's email
     * @param pwd Client's password
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean newClient(String name, String NIF, String telephone, String email, String pwd) {
        clientRegistry = company.getClientRegistry();
        this.pwd = pwd;
        this.client = this.clientRegistry.newClient(name, NIF, telephone, email);
        return this.clientRegistry.validateClient(this.client);
    }

    /**
     * 
     * Sets the sequence of methods necessary to add an Address to the Client
     * 
     * @param local Client's city name
     * @param postalCode Client's postal code
     * @param address Client's address
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean addAddress(String local, String postalCode, String address) {
        if (this.client != null) {
            Address oAddress = Client.newAddress(local, postalCode, address);
            return this.client.addAddress(oAddress);
        }
        return false;
    }

    /**
     * 
     * Sets the sequence of methods necessary to register a Client on the App
     * 
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean registerCliente(){
        return this.clientRegistry.registerClient(this.client, this.pwd);
    }
    
    /**
     * 
     * Gets the created Client
     * 
     * @return Client
     */
    public Client getClient(){
        return this.client;
    }
}
