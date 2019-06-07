package lapr.project.gpsd.model;

import java.util.ArrayList;

public class ServiceOrderRegistry {
    private ArrayList<ServiceOrder> servOrderList;

    public ServiceOrderRegistry() {
        this.servOrderList = new ArrayList<>();
    }

    public ArrayList<ServiceOrder> getCompletedServiceOrdersByClient(Client cli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
