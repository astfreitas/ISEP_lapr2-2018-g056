package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.AplicacaoGPSD;

public class ClientRegistry {
  private List<Client> clients;

  /**
   * 
   * Creates an instance of Client Registry
   * 
   */
    public ClientRegistry() {
        this.clients = new ArrayList<>();
    }
  
    /**
     * 
     * Checks the registry if the Client is already present in the registry
     * 
     * @param cli Client being validated
     * @return True/false if the Client is/isn't validated
     */
    public boolean validateClient(Client cli){
        for(Client clientListed : clients){
            if(clientListed.equals(cli)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * Creates and returns an instance of Client
     * 
     * @param name Client's name
     * @param NIF Client's NIF
     * @param telephone Client's telephone
     * @param email Client's email
     * @param address Client's address
     * @return Client instantiated
     */
    public Client newClient(String name, String NIF, String telephone, String email, Address address){
        return new Client(name, NIF, telephone, email, address);
    }
    
    /**
     * 
     * Adds a Client to the regitry
     * 
     * @param cli Client being registed
     * @return True/false if the Client is/isn't added
     */
    public boolean addClient(Client cli){
        return clients.add(cli);
    }
    
     /**
     * 
     * Looks in the registry for a Client with a specific email
     * 
     * @param email Email to look for
     * @return Client with the email. Null if none is found.
     */
    public Client getClientByEmail(String email){
        for(Client clientListed : clients){
            if(clientListed.hasEmail(email)){
                return clientListed;
            }
        }
        return null;
    }
    
    /**
     * 
     * Registers the Client as a User and adds it to the Registry
     * 
     * @param client Instance of Client to be registed
     * @param pwd Client's password
     * @return True/false if the operation succeeds/fails
     */
    public boolean registerClient(Client client, String pwd){
        String clientName = client.getName();
        String clientEmail = client.getEmail();
        
        if(AplicacaoGPSD.getInstance().getEmpresa().getAuthenticationFacade().registerUserWithRole(clientName, clientEmail, pwd, Constants.PAPEL_CLIENTE)){
            return this.addClient(client);
        }
        
        return false;
    }
}
