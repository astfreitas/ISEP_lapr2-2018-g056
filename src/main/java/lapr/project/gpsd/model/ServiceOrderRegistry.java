package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrderRegistry {

    private List<ServiceOrder> serviceOrders;

    public ServiceOrderRegistry() {
        this.serviceOrders = new ArrayList<>();
    }

    public ServiceOrder getPendingServiceOrders(String status) {
        for (ServiceOrder sol : serviceOrders) {
            if (sol.isPending(status)) {
                return sol;
            }
        }
        return null;
    }
    
    public ServiceOrder getServiceOrderByID(String id){
        for (ServiceOrder sol : serviceOrders) {
            if (sol.hasId(id)) {
                return sol;
            }
        }
        return null;
    }

}
