package lapr.project.gpsd.model;

import java.util.ArrayList;

import java.util.List;

public class ServiceRequestRegistry {

    private List<ServiceRequest> serviceRequests;

    public ServiceRequestRegistry() {
        serviceRequests = new ArrayList();
    }

    /**
     * Method returns the list of service requests
     *
     * @return List<ServiceRequest> containing all the service requests in the
     * company
     */
    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    /**
     * Method creates and returns a new Service Request
     *
     * @param client instance of client that requested the service
     * @param address instance of address where the service will be executed
     * @return the created Service Request
     */
    public ServiceRequest newServiceRequest(Client client, Address address) {
        return new ServiceRequest(client, address);
    }

    /**
     * Returns the list of unassigned services (descriptions) from the Service
     * Requests stored in registry
     *
     * @return List of unassigned Service Descriptions
     */
    public List<ServiceRequestDescription> getUnassignedServices() {
        List<ServiceRequestDescription> unassignedServices = new ArrayList<>();
        for (ServiceRequest request : serviceRequests) {
            List<ServiceRequestDescription> services = request.getServiceRequestDescriptions();
            for (ServiceRequestDescription service : services) {
                if (!service.isAssigned()) {
                    unassignedServices.add(service);
                }
            }
        }
        return unassignedServices;
    }

    /**
     * Returns the Service Requests that originated a given Service Description
     *
     * @param srd
     * @return
     */
    public ServiceRequest getRequestFromDescription(ServiceRequestDescription srd) {
        for(ServiceRequest request : serviceRequests) {
            if(request.getServiceRequestDescriptions().contains(srd)) {
                return request;
            }
        }
        return null;
    }
}
