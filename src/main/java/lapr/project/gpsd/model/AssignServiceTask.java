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
        Company company = ApplicationGPSD.getInstance().getCompany();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        ServiceRequestRegistry srr = company.getServiceRequestRegistry();
        ServiceAssignmentRegistry sar = company.getServiceAssignementRegistry();
        IAssignmentAlgoritm alg = company.getAssignmentAlgoritm();
        List<ServiceAssignment> sal = alg.assignServices(srr, spr);
        for (ServiceAssignment sa : sal) {
            sar.addServiceAssignment(sa);
        }
    }

}
