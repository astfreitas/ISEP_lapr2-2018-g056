/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.*;

/**
 *
 * @author paulomaio
 */
public class RegisterClientController {

    private AplicacaoGPSD app;
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
        this.app = AplicacaoGPSD.getInstance();
        this.company = app.getEmpresa();
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
     * @param local Client's city name
     * @param postalCode Client's postal code
     * @param address Client's address
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean newClient(String name, String NIF, String telephone, String email, String pwd, String local, String postalCode, String address) {
        clientRegistry = company.getClientRegistry();
        this.pwd = pwd;
        Address oAddress = Client.newAddress(local, postalCode, address);
        this.client = this.clientRegistry.newClient(name, NIF, telephone, email, oAddress);
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
}