package lapr.project.gpsd.model;

import java.util.List;
import lapr.project.gpsd.controller.*;
import java.util.TimerTask;

public class AssignServiceTask extends TimerTask {

    /**
     * Method run by Company's Timer in regular intervals. Selects a List
     * ServiceDescriptions without Assignment from the ServiceRequest Registry
     * and passes as argument to the Company's AssignmentAlgoritm (set by
     * configuration file during startup), during which a List of new
     * Assignments is returned. The new Assignment List is then added to the
     * ServiceAssigment Registry
     */
    @Override
    public void run() {
        
        // returns the list of service providers in the system
        Company company = ApplicationGPSD.getInstance().getCompany();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        List<ServiceProvider> providers = spr.getServiceProviders();
        
        // returns the list of service descriptions not yet assigned
        ServiceRequestRegistry srr = company.getServiceRequestRegistry();
        List<ServiceRequestDescription> unassignedServices = srr.getUnassignedServices();
        
        // returns the list of assignments from the assignment algoritm
        IAssignmentAlgoritm alg = company.getAssignmentAlgoritm();
        List<ServiceAssignment> sal = alg.assignServices(unassignedServices);
        
        // registers the assignments into the assignment registry
        ServiceAssignmentRegistry sar = company.getServiceAssignementRegistry();
        for (ServiceAssignment sa : sal) {
            sar.addServiceAssignment(sa);
        }
    }

}
