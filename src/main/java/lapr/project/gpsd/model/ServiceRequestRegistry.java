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
    
}
