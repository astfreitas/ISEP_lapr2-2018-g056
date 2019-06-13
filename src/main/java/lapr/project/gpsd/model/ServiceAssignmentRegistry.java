package lapr.project.gpsd.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.utils.Constants;

public class ServiceAssignmentRegistry {

    List<ServiceAssignment> serviceAssignments;

    public ServiceAssignmentRegistry() {
        this.serviceAssignments = new ArrayList<>();
    }

    public List<ServiceAssignment> getServiceAssignments() {
        return this.serviceAssignments;
    }

    public boolean addServiceAssignment(ServiceAssignment sa) {
        return this.serviceAssignments.add(sa);
    }

    /**
     * Method obtains the list of service assignments by Service Request
     *
     * @param serviceRequest instance of service request to be filtered by
     * @return returns a list of service assignments for a given Service
     * Request.
     */
    public List<ServiceAssignment> getServiceAssignmentListByServiceRequest(ServiceRequest serviceRequest) {
        List<ServiceAssignment> serviceAssignments = new ArrayList();
        for (ServiceRequestDescription srd : serviceRequest.getServiceRequestDescriptions()) {
            ServiceAssignment servAssign = getServiceAssignmentByDescription(srd);
            if (servAssign != null) {
                serviceAssignments.add(servAssign);
            }
        }
        return serviceAssignments;
    }
    
    /**
     * Method obtains the list of service assignments by Service Request
     * 
     * @param serviceRequest
     * @param clientServiceAssignments
     * @return 
     */
    public List<ServiceAssignment> getServiceAssignmentListByServiceRequest(ServiceRequest serviceRequest, List<ServiceAssignment> clientServiceAssignments) {
        List<ServiceAssignment> result = new ArrayList();
        for (ServiceRequestDescription srd : serviceRequest.getServiceRequestDescriptions()) {
            ServiceAssignment servAssign = getServiceAssignmentByDescription(srd, clientServiceAssignments);
            if (servAssign != null) {
                result.add(servAssign);
            }
        }
        return result;
    }
    
    /**
     * Method returns an instance of ServiceAssignment related to the Service
     * request description
     *
     * @param srd
     * @return an instance of ServiceAssignment related to the Service request
     * description
     */
    private ServiceAssignment getServiceAssignmentByDescription(ServiceRequestDescription srd) {
        return getServiceAssignmentByDescription(srd, serviceAssignments);
    }
    
    /**
     * Method returns an instance of ServiceAssignment related to the Service 
     * @param srd
     * @param clientServiceAssignments array of assignments
     * @return 
     */
    private ServiceAssignment getServiceAssignmentByDescription(ServiceRequestDescription srd, List<ServiceAssignment> servAssignments) {
        for (ServiceAssignment serviceAssignment : servAssignments) {
            if (serviceAssignment.getServiceRequestDescription().equals(srd)) {
                return serviceAssignment;
            }
        }
        return null;
    }

    /**
     * Method removes a list of serviceAssignments
     * changes service state if necessary
     *
     * @param listServiceAssignments
     * @param setAssigned
     */
    public void removeServiceAssignment(List<ServiceAssignment> listServiceAssignments, boolean setAssigned) {
        for (ServiceAssignment serviceAssignment : listServiceAssignments) {
            removeServiceAssignment(serviceAssignment, setAssigned);
        }
    }

    /**
     * Method removes a service Assignment
     * @param serviceAssignment
     * @param setAssigned 
     */
    private void removeServiceAssignment(ServiceAssignment serviceAssignment, boolean setAssigned) {
        if (setAssigned == false) {
            serviceAssignment.getServiceRequestDescription().setAssigned(Constants.SERVICE_NOT_ASSIGNED);
            ServiceProvider sp = serviceAssignment.getServiceProvider();
            SchedulePreference schp = serviceAssignment.getSchedulePreference();
            int duration = serviceAssignment.getServiceRequestDescription().getDuration();
            sp.getSpAvailabilityList().addAvailabilityBySchedulePreference(schp, duration);
            sp.getSpAvailabilityList().mergeAvailabilities();
        } else {
            serviceAssignment.getServiceRequestDescription().setAssigned(Constants.SERVICE_ACCEPTED);
        }
        serviceAssignments.remove(serviceAssignment);
    }

    /**
     * Method checks if the Service Request has expired schedule preferences.
     *
     * @param serviceRequest
     * @return returns true if the service request has expired assignments
     */
    public boolean serviceRequestHasExpiredAssignment(ServiceRequest serviceRequest) {
        for (ServiceRequestDescription srd : serviceRequest.getServiceRequestDescriptions()) {
            ServiceAssignment sa = getServiceAssignmentByDescription(srd);
            if (LocalDateTime.now().isAfter(sa.getSchedulePreference().getDateTime())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method return serviceAssignments from a given client
     *
     * @param cli
     * @return serviceAssignments from a client.
     */
    public List<ServiceAssignment> getServiceAssignmentsByCli(Client cli) {
        List<ServiceAssignment> result = new ArrayList();
        for (ServiceAssignment sa : serviceAssignments) {
            if (sa.getServiceRequest().getClient().equals(cli)) {
                result.add(sa);
            }
        }
        return result;
    }

    /**
     * 
     * Method removes expired assignments from a List of ServiceAssignments
     *
     */
    public void removeExpiredAssignments() {
        List<ServiceAssignment> auxList = new ArrayList<>();
        for (ServiceAssignment sa : serviceAssignments) {
            if (sa.isExpired()) {
                auxList.add(sa);
            }
        }
        for(ServiceAssignment servAssign : auxList){
            removeServiceAssignment(servAssign, false);
        }
    }

    

    

}
