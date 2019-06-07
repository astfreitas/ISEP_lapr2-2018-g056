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
     * @return List<ServiceRequest> containing all the service requests in the company
     */
    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }
    
    /**
     * Method creates and returns a new Service Request
     * @param client instance of client that requested the service
     * @param address instance of address where the service will be executed
     * @return the created Service Request
     */
    public ServiceRequest newServiceRequest(Client client, Address address) {
        return new ServiceRequest(client, address);
    }
    
    /**
     * Method registers the service requested by the client.
     * @param serviceRequest instance of the service request to be registered.
     * @return a unique number associated with the service requested or -1 if it could not be added.
     */
    public int registerServiceRequest(ServiceRequest serviceRequest) {
        validateServiceRequest(serviceRequest);
        if(validateServiceRequest(serviceRequest)) {
            int num = 1000 + serviceRequests.size();
            serviceRequest.setNumber(num);
            addServiceRequest(serviceRequest);
            return num;
        }
        return -1;
    }
    
    /**
     * Method validates service request.
     * @param serviceRequest instance of the service request that is validated
     * @return true if the service request is not already registered.
     */
    private boolean validateServiceRequest(ServiceRequest serviceRequest) {
        return !serviceRequests.contains(serviceRequest);        
    }
    
    /**
     * Method adds a new service request to the registry
     * @param serviceRequest
     * @return true if the operation is successful
     */
    private boolean addServiceRequest(ServiceRequest serviceRequest) {        
        return serviceRequests.add(serviceRequest);
    }
    
}
