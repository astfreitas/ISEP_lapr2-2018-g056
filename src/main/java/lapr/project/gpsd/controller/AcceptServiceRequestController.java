package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;


public class AcceptServiceRequestController {
    
    private final ServiceAssignmentRegistry serAssignRegistry;
    private final ServiceRequestRegistry servReqRegistry;
    private final ServiceOrderRegistry servOrderRegistry;
    private final Client client;
    private List<ServiceAssignment> clientServiceAssignments;
    private List<ServiceAssignment> sRequestAssignments;

    /**
     * 
     * Creates an instance of AcceptServiceRequestController
     * 
     */
    public AcceptServiceRequestController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        Company company = app.getCompany();
        servOrderRegistry = company.getServiceOrderRegistry();
        serAssignRegistry = company.getServiceAssignementRegistry();
        ClientRegistry clientRegistry = company.getClientRegistry();
        servReqRegistry = app.getCompany().getServiceRequestRegistry();
        serAssignRegistry.removeExpiredAssignments();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        client = clientRegistry.getClientByEmail(email);
        clientServiceAssignments = serAssignRegistry.getServiceAssignmentsByCli(client);
        sRequestAssignments = new ArrayList();
    }
    
    /**
     * Method returns a list of fully assigned ServiceRequests ID's
     * @return a list of fully assigned ServiceRequet ID's from the user
     */
    public List<Integer> checkAssignedServiceRequests() {
        List<Integer> serviceIDS = new ArrayList();
        try {
            serviceIDS = servReqRegistry.getServiceRequestIdsFullyAssignedByClient(client);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return serviceIDS;
    }
    
    /**
     * Method returns a list of service assignments for a given ServiceRequest
     * @param serviceNumber Service Number
     * @return a list of service assignments for a given ServiceRequest
     */
    public List<ServiceAssignment> checkServiceAssignments(int serviceNumber) {
        try {
            ServiceRequest servRequest = servReqRegistry.getServiceRequestByNumber(serviceNumber);
            sRequestAssignments = serAssignRegistry.getServiceAssignmentListByServiceRequest(servRequest, clientServiceAssignments);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return sRequestAssignments;
    }
    
    /**
     * Method removes list of service assignments 
     */
    public void rejectServiceAssignment() {
        serAssignRegistry.removeServiceAssignment(sRequestAssignments, false);
        sRequestAssignments.clear();
    }
    
    /**
     * Method accepts list of service assignments 
     * @return  list of ServiceOrder numbers
     */
    public List<Integer> acceptServiceAssignment() {
        List<Integer> serviceOrders = servOrderRegistry.registerServiceOrders(sRequestAssignments);
        serAssignRegistry.removeServiceAssignment(sRequestAssignments, true);
        sRequestAssignments.clear();
        return serviceOrders;
    }  
}
