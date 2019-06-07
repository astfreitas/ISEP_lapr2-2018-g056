package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ClientRegistry;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.gpsd.model.ServiceAssignmentRegistry;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestRegistry;


public class AcceptServiceRequestController {
    
    ApplicationGPSD app;
    Company company;
    ServiceAssignmentRegistry sar;
    
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
     * 
     * @param listServiceAssignments 
     */
    public void rejectServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        sar.removeServiceAssignment(listServiceAssignments, false);
    }
    
    public void acceptServiceAssignment(List<ServiceAssignment> listServiceAssignments) {
        
    }
    
    
}
