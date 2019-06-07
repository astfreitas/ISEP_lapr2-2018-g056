package lapr.project.gpsd.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceAssignmentRegistry {
    List<ServiceAssignment> serviceAssignments = new ArrayList<>();


    public List<ServiceAssignment> getServiceAssignments() {
        return serviceAssignments;
    }
    
    public boolean addServiceAssignment(ServiceAssignment sa) {
        return this.serviceAssignments.add(sa);
    }
    
    /**
     * Method obtains the list of service assignments by Service Request
     * @param serviceRequest instance of service request to be filtered  by
     * @return returns a list of service assignments for a given Service Request.
     */
    public List<ServiceAssignment> getServiceAssignmentListByServiceRequest(ServiceRequest serviceRequest) {
        List<ServiceAssignment> serviceAssignments = new ArrayList();
        for(ServiceRequestDescription srd : serviceRequest.getServiceRequestDescriptions()) {
            ServiceAssignment servAssign = getServiceAssignmentByDescription(srd);
            if(servAssign != null) {
                serviceAssignments.add(servAssign);
            }
        }
        return serviceAssignments;
    }
    
    /**
     * Method returns an instance of ServiceAssignment related to the Service request description
     * @param srd
     * @return an instance of ServiceAssignment related to the Service request description
     */
    private ServiceAssignment getServiceAssignmentByDescription(ServiceRequestDescription srd) {
        for(ServiceAssignment serviceAssignment : serviceAssignments) {
            if (serviceAssignment.getServiceRequestDescription().equals(srd))
                return serviceAssignment;
        }
        return null;
    }
    
    /**
     * Method removes service assignments related to a ServiceRequest and changes service state if necessary
     * @param listServiceAssignments
     * @param setAssigned 
     */
    public void removeServiceAssignment(List<ServiceAssignment> listServiceAssignments, boolean setAssigned) {       
        for(ServiceAssignment serviceAssignment : listServiceAssignments) {
            //removes and sets service assignment to false
            if(setAssigned == false) {
                serviceAssignment.getServiceRequestDescription().setAssigned(false);
                ServiceProvider sp = serviceAssignment.getServiceProvider();
                SchedulePreference schp = serviceAssignment.getSchedulePreference();
                int duration = serviceAssignment.getServiceRequestDescription().getDuration();
                sp.getSpAvailabilityList().addAvailabilityBySchedulePreference(schp, duration);
            } 
            serviceAssignments.remove(serviceAssignment);
        }
    }
    
    
}
