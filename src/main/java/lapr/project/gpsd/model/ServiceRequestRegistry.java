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
     * Method registers the service requested by the client.
     *
     * @param serviceRequest instance of the service request to be registered.
     * @return a unique number associated with the service requested or -1 if it
     * could not be added.
     */
    public int registerServiceRequest(ServiceRequest serviceRequest) {
        validateServiceRequest(serviceRequest);
        if (validateServiceRequest(serviceRequest)) {
            int num = 1000 + serviceRequests.size();
            serviceRequest.setNumber(num);
            addServiceRequest(serviceRequest);
            return num;
        }
        return -1;
    }

    /**
     * Method validates service request.
     *
     * @param serviceRequest instance of the service request that is validated
     * @return true if the service request is not already registered.
     */
    private boolean validateServiceRequest(ServiceRequest serviceRequest) {
        return !serviceRequests.contains(serviceRequest);
    }

    /**
     * Method adds a new service request to the registry
     *
     * @param serviceRequest
     * @return true if the operation is successful
     */
    private boolean addServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequests.add(serviceRequest);
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
        for (ServiceRequest request : serviceRequests) {
            if (request.getServiceRequestDescriptions().contains(srd)) {
                return request;
            }
        }
        return null;
    }
    
    /**
     * Method returns a list of Service Requests  fully assigned by the system or admin for a given client.
     * @param client instance of the client to be filtered by
     * @return a list of ServiceRequests fully assigned by the system from the client.
     */
    public List<ServiceRequest> getServiceRequestsFullyAssignedByClient(Client client) {
        List<ServiceRequest> serviceRequestsFullyAssigned = new ArrayList();
        for(ServiceRequest s : serviceRequests) {
            if(s.getClient().equals(client) && s.fullyAssigned()) {
                serviceRequestsFullyAssigned.add(s);
            }
        }
        return serviceRequestsFullyAssigned;
    }
    
    /**
     * Method returns a list of ServiceRequests Assigned by the client
     * @param client
     * @return 
     */
    public List<Integer> getServiceRequestIdsFullyAssignedByClient(Client client) {
        List<Integer> result = new ArrayList();
        for(ServiceRequest s : serviceRequests) {
            if(s.getClient().equals(client) && s.fullyAssigned()) {
                result.add(s.getNumber());
            }
        }
        return result;
    }
    
    
    /**
     * Method returns a service request by a given number
     * @param number
     * @return null if not exist
     */
    public ServiceRequest getServiceRequestByNumber(int number) {
        for(ServiceRequest s : serviceRequests) {
            if (s.getNumber() == number) {
                return s;
            }
        }
        return null;
    }
    
}
