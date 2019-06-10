package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;


public class AcceptServiceRequestController {
    
    private ApplicationGPSD app;
    private Company company;
    private ServiceAssignmentRegistry sar;
    
    /**
     * Method returns a list of fully assigned ServiceRequests
     * @return a list of fully assigned ServiceRequets from the user
     */
    public List<ServiceRequest> checkAssignedServiceRequests() {
        app = ApplicationGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        company = app.getCompany();
        ClientRegistry cr = company.getClientRegistry();
        Client cli = cr.getClientByEmail(email);
        ServiceRequestRegistry srr = app.getCompany().getServiceRequestRegistry();
        return srr.getServiceRequestsFullyAssignedByClient(cli); 
    }
    
    /**
     * Method returns a list of service assignments for a given ServiceRequest
     * @return a list of service assignments for a given ServiceRequest
     */
    public List<ServiceAssignment> checkServiceAssignments(ServiceRequest serviceRequest) {
        sar = company.getServiceAssignementRegistry();
        return sar.getServiceAssignmentListByServiceRequest(serviceRequest);
    }
    
    /**
     * Method removes list of service assignments
     * @param listServiceAssignments 
     */
    public void rejectServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        sar.removeServiceAssignment(listServiceAssignments, false);
        
    }
    
    /**
     * Method accepts list of service assignments
     * @param listServiceAssignments 
     */
    public void acceptServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        sar.removeServiceAssignment(listServiceAssignments, true);
        ServiceOrderRegistry sor = company.getServiceOrderRegistry();
        sor.registerServiceOrders(listServiceAssignments);
    }
    
    
}
