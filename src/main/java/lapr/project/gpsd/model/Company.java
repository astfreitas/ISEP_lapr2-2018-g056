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
import lapr.project.autorizacao.AutorizacaoFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Company {

    private String designation;
    private String NIF;
    private final AutorizacaoFacade authentication;
    private ServiceAssignementRegistry serviceAssignementRegistry;
    private ServiceExecutionOrderRegistry serviceExecutionOrderRegistry;
    private ServiceOrderRegistry serviceOrderRegistry;
    private ServiceProviderRegistry serviceProviderRegistry;
    private ServiceRegistry serviceRegistry;
    private ServiceRequestRegistry serviceRequestRegistry;
    private ServiceTypeRegistry serviceTypeRegistry;
    private CategoryRegistry categoryRegistry;
    private ClientRegistry clientRegistry;
    private GeographicAreaRegistry geographicAreaRegistry;
    private IAssignmentAlgoritm assignmentAlgoritm;
    private IExternalService externalService;
    private Timer timer;

    public Company(String designation, String NIF) {
        if ((designation == null) || (NIF == null)
                || (designation.isEmpty()) || (NIF.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.designation = designation;
        this.NIF = NIF;

        this.authentication = new AutorizacaoFacade();

        this.serviceAssignementRegistry = new ServiceAssignementRegistry();
        this.serviceExecutionOrderRegistry = new ServiceExecutionOrderRegistry();
        this.serviceOrderRegistry = new ServiceOrderRegistry();
        this.serviceProviderRegistry = new ServiceProviderRegistry();
        this.serviceRegistry = new ServiceRegistry();
        this.serviceRequestRegistry = new ServiceRequestRegistry();
        this.serviceTypeRegistry = new ServiceTypeRegistry();
        this.categoryRegistry = new CategoryRegistry();
        this.clientRegistry = new ClientRegistry();
        this.geographicAreaRegistry = new GeographicAreaRegistry();
        this.assignmentAlgoritm = null;
        this.externalService = null;
        this.timer = null;
    }

    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.authentication;
    }

}
