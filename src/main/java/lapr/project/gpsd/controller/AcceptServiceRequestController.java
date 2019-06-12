package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;


public class AcceptServiceRequestController {
    
    private ApplicationGPSD app;
    private Company company;
    private ServiceAssignmentRegistry sar;
    private ServiceRequestRegistry srr;
    /**
     * Method returns a list of fully assigned ServiceRequests ID's
     * @return a list of fully assigned ServiceRequet ID's from the user
     */
    public List<Integer> checkAssignedServiceRequests() {
        app = ApplicationGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        company = app.getCompany();
        ClientRegistry cr = company.getClientRegistry();
        Client cli = cr.getClientByEmail(email);
        srr = app.getCompany().getServiceRequestRegistry();
        
        List<Integer> serviceIDS = new ArrayList();
        List<ServiceRequest> serviceRequests = srr.getServiceRequestsFullyAssignedByClient(cli);
        for(ServiceRequest sreq : serviceRequests) {
            serviceIDS.add(sreq.getNumber());
        }
        return serviceIDS; 
    }
    
    /**
     * Method returns a list of service assignments for a given ServiceRequest
     * @param serviceNumber
     * @return a list of service assignments for a given ServiceRequest
     */
    public List<ServiceAssignment> checkServiceAssignments(int serviceNumber) {
        List<ServiceAssignment> result = new ArrayList();
        ServiceRequest servRequest = srr.getServiceRequestByNumber(serviceNumber);
        if(servRequest!=null) {
            sar = company.getServiceAssignementRegistry();
            result = sar.getServiceAssignmentListByServiceRequest(servRequest);
        } 
        return result;
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
     * @return  list of ServiceOrder numbers
     */
    public List<Integer> acceptServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        sar.removeServiceAssignment(listServiceAssignments, true);
        ServiceOrderRegistry sor = company.getServiceOrderRegistry();
        return sor.registerServiceOrders(listServiceAssignments);
    }
    
    
}
