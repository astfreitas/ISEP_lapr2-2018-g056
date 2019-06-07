package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceOrderRegistry {
    private ArrayList<ServiceOrder> servOrderList;

    public ServiceOrderRegistry() {
        this.servOrderList = new ArrayList<>();
    }

    public ArrayList<ServiceOrder> getCompletedServiceOrdersByClient(Client cli) {
        ArrayList<ServiceOrder> servOrderByClient = new ArrayList<>();
        for(ServiceOrder servOrder : servOrderList){
            if(servOrder.getServiceRequest().getClient().equals(cli) && servOrder.getStatus().equals("")){
                servOrderByClient.add(servOrder);
            }
        }
        return servOrderByClient;
    }
    
    public ArrayList<ServiceOrder> getServiceOrderByDateAndSP(LocalDate sDate, LocalDate eDate, ServiceProvider sp){
        ArrayList<ServiceOrder> servOrderByDate = new ArrayList<>();
        for(ServiceOrder servOrder : servOrderList){
            if(servOrder.getServiceProvider().equals(sp)){
                if((servOrder.getSchePref().getDate().isAfter(sDate) || servOrder.getSchePref().getDate().equals(sDate))
                    && (servOrder.getSchePref().getDate().isBefore(eDate) || servOrder.getSchePref().getDate().equals(eDate))){
                servOrderByDate.add(servOrder);
            }
            }
        }
        return servOrderByDate;
    }
}
