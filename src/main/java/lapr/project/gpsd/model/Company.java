/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lapr.project.authentication.AuthenticationFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private String NIF;
    private final AuthenticationFacade authentication;
    private ServiceAssignementRegistry serviceAssignementRegistry;
    private ServiceOrderRegistry serviceOrderRegistry;
    private ServiceProviderRegistry serviceProviderRegistry;
    private ServiceRegistry serviceRegistry;
    private ServiceRequestRegistry serviceRequestRegistry;
    private ServiceTypeRegistry serviceTypeRegistry;
    private SPApplicationRegistry spApplicationRegistry;
    private CategoryRegistry categoryRegistry;
    private ClientRegistry clientRegistry;
    private GeographicAreaRegistry geographicAreaRegistry;
    private IAssignmentAlgoritm assignmentAlgoritm;
    private IExternalService externalService;
    private Timer timer;

    /**
     * 
     * Creates an instance of Company
     * 
     * @param designation Company's designation
     * @param NIF Company's NIF
     */
    public Company(String designation, String NIF) {
        if ((designation == null) || (NIF == null)
                || (designation.isEmpty()) || (NIF.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.designation = designation;
        this.NIF = NIF;

        this.authentication = new AuthenticationFacade();

        this.serviceAssignementRegistry = new ServiceAssignementRegistry();
        this.serviceOrderRegistry = new ServiceOrderRegistry();
        this.serviceProviderRegistry = new ServiceProviderRegistry();
        this.serviceRegistry = new ServiceRegistry();
        this.serviceRequestRegistry = new ServiceRequestRegistry();
        this.serviceTypeRegistry = new ServiceTypeRegistry();
        this.spApplicationRegistry = new SPApplicationRegistry();
        this.categoryRegistry = new CategoryRegistry();
        this.clientRegistry = new ClientRegistry();
        this.geographicAreaRegistry = new GeographicAreaRegistry();
        this.assignmentAlgoritm = null;
        this.externalService = null;
        this.timer = null;
    }
    
    /**
     * 
     * Gets the instance of Service Assignement Registry
     * 
     * @return Service Assignement Registry
     */
    public ServiceAssignementRegistry getServiceAssignementRegistry(){
        return this.serviceAssignementRegistry;
    }
    
    /**
     * 
     * Gets the instance of Service Order Registry
     * 
     * @return Service Order Registry
     */
    public ServiceOrderRegistry getServiceOrderRegistry(){
        return this.serviceOrderRegistry;
    }
    
    /**
     * 
     * Gets the instance of Service Provider Registry
     * 
     * @return Service Provider Registry
     */
    public ServiceProviderRegistry getServiceProviderRegistry(){
        return this.serviceProviderRegistry;
    }
    
    /**
     * 
     * Gets the instance of Service Registry
     * 
     * @return Service Registry
     */
    public ServiceRegistry getServiceRegistry(){
        return this.serviceRegistry;
    }
    
    /**
     * 
     * Gets the instance of Service Request Registry
     * 
     * @return Service Request Registry
     */
    public ServiceRequestRegistry getServiceRequestRegistry(){
        return this.serviceRequestRegistry;
    }
    
    /**
     * 
     * Gets the instance of Geographic Area Registry
     * 
     * @return Geographic Area Registry
     */
    public GeographicAreaRegistry getGeographicAreaRegistry(){
        return this.geographicAreaRegistry;
    }
    
    /**
     * 
     * Gets the instance of Client Registry
     * 
     * @return Client Registry
     */
    public ClientRegistry getClientRegistry(){
        return this.clientRegistry;
    }
    
    /**
     * 
     * Gets the instance of Category Registry
     * 
     * @return Category Registry
     */
    public CategoryRegistry getCategoryRegistry(){
        return this.categoryRegistry;
    }

    /**
     * Gets the instance of SPApplicationRegistry
     * @return applicationRegistry
     */
    public SPApplicationRegistry getSPApplicationRegistry() {
        return applicationRegistry;
    }
    

    /**
     * 
     * Gets the instance of Authentication Facade
     * 
     * @return Authentication Facade
     */
    public AuthenticationFacade getAuthenticationFacade() {
        return this.authentication;
    }

}
