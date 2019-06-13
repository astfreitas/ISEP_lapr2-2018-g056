package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;


public class AcceptServiceRequestController {
    
    private ApplicationGPSD app;
    private Company company;
    private ClientRegistry clientRegistry;
    private ServiceAssignmentRegistry serAssignRegistry;
    private ServiceRequestRegistry servReqRegistry;
    private ServiceOrderRegistry servOrderRegistry;
    private List<ServiceAssignment> clientServiceAssignments;
    private Client client;
    public AcceptServiceRequestController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        app = ApplicationGPSD.getInstance();
        company = app.getCompany();
        servOrderRegistry = company.getServiceOrderRegistry();
        serAssignRegistry = company.getServiceAssignementRegistry();
        clientRegistry = company.getClientRegistry();
        servReqRegistry = app.getCompany().getServiceRequestRegistry();
        serAssignRegistry.removeExpiredAssignments();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        client = clientRegistry.getClientByEmail(email);
        clientServiceAssignments = serAssignRegistry.getServiceAssignmentsByCli(client);
    }
    
    /**
     * Method returns a list of fully assigned ServiceRequests ID's
     * @return a list of fully assigned ServiceRequet ID's from the user
     */
    public List<Integer> checkAssignedServiceRequests() {
        List<Integer> serviceIDS = new ArrayList();
        return servReqRegistry.getServiceRequestIdsFullyAssignedByClient(client);
    }
    
    /**
     * Method returns a list of service assignments for a given ServiceRequest
     * @param serviceNumber
     * @return a list of service assignments for a given ServiceRequest
     */
    public List<ServiceAssignment> checkServiceAssignments(int serviceNumber) {
        List<ServiceAssignment> result = new ArrayList();
        //**
        ServiceRequest servRequest = servReqRegistry.getServiceRequestByNumber(serviceNumber);        
        return serAssignRegistry.getServiceAssignmentListByServiceRequest(servRequest, clientServiceAssignments);
    }
    
    /**
     * Method removes list of service assignments
     * @param listServiceAssignments 
     */
    public void rejectServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        serAssignRegistry.removeServiceAssignment(listServiceAssignments, false);
    }
    
    /**
     * Method accepts list of service assignments
     * @param listServiceAssignments 
     * @return  list of ServiceOrder numbers
     */
    public List<Integer> acceptServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        serAssignRegistry.removeServiceAssignment(listServiceAssignments, true);
        return servOrderRegistry.registerServiceOrders(listServiceAssignments);
    }
    
    
}
