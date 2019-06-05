
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;


public class ServiceRequestRegistry {
    
    private List<ServiceRequest> serviceRequests;
    private List<ServiceOrder> serviceOrders;

    public ServiceRequestRegistry() {
        serviceRequests = new ArrayList();
        serviceOrders = new ArrayList();
    }

    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceRequests(List<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    @Override
    public String toString() {
        return "ServiceRequestRegistry{" + "serviceRequests=" + serviceRequests + ", serviceOrders=" + serviceOrders + '}';
    }
    
    
    
    
}
