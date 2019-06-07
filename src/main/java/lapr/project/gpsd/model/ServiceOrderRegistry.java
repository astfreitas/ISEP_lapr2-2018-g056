package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceOrderRegistry {

    private ArrayList<ServiceOrder> serviceOrders;

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

    public ServiceOrder getServiceOrderByID(String id) {
        for (ServiceOrder sol : serviceOrders) {
            if (sol.hasId(id)) {
                return sol;
            }
        }
        return null;
    }

    public ArrayList<ServiceOrder> getCompletedServiceOrdersByClient(Client cli) {
        ArrayList<ServiceOrder> servOrderByClient = new ArrayList<>();
        for (ServiceOrder servOrder : serviceOrders) {
            if (servOrder.getServiceRequest().getClient().equals(cli) && servOrder.getStatus().equals("")) {
                servOrderByClient.add(servOrder);
            }
        }
        return servOrderByClient;
    }

    public ArrayList<ServiceOrder> getServiceOrderByDateAndSP(LocalDate sDate, LocalDate eDate, ServiceProvider sp) {
        ArrayList<ServiceOrder> servOrderByDate = new ArrayList<>();
        for (ServiceOrder servOrder : serviceOrders) {
            if (servOrder.getServiceProvider().equals(sp)) {
                if ((servOrder.getSchePref().getDate().isAfter(sDate) || servOrder.getSchePref().getDate().equals(sDate))
                        && (servOrder.getSchePref().getDate().isBefore(eDate) || servOrder.getSchePref().getDate().equals(eDate))) {
                    servOrderByDate.add(servOrder);
                }
            }
        }
        return servOrderByDate;
    }
    
    /**
     * Method used to store register service orders from a list of service assignments.
     * @param listServiceAssignments
     * @return list of service orders created.
     */
    public List<ServiceOrder> registerServiceOrders(List<ServiceAssignment> listServiceAssignments) {
        List<ServiceOrder> serviceOrdersList = new ArrayList();
        for(ServiceAssignment serviceAssignment : listServiceAssignments) {
            ServiceOrder so = new ServiceOrder(serviceAssignment);
            if(validate(so)) {
                int orderNumber = generateServiceOrderNumber();
                so.setOrderNumber(orderNumber);
                serviceOrdersList.add(so);
            }
        }
        return serviceOrdersList;
    }
    
    /**
     * Method verifies if the service order is already exists
     * @param serviceOrder instance of the service order to be added.
     * @return true if the so is not registered yet 
     */
    private boolean validate(ServiceOrder serviceOrder) {
        return !serviceOrders.contains(serviceOrder);
    }
    
    public void exportData(String filename, FileType adapter) {
        // write header
        String[] header = {"ClientName", "ClientEmail", "SchedPrefDay", "SchePrefTime", "Category", "Service"};
        adapter.export(filename, header);

        for (ServiceOrder servOrder : serviceOrders) {
            String clientName = servOrder.getServiceRequest().getClient().getName();
            String clientEmail = servOrder.getServiceRequest().getClient().getEmail();
            String schePrefDay = servOrder.getSchePref().getDate().toString();
            String schePrefTime = servOrder.getSchePref().getTime().toString();
            String category = servOrder.getServiceRequestDescription().getService().getCategory().getDescription();
            String service = servOrder.getServiceRequestDescription().getService().getBriefDescription();
            String[] line = {clientName, clientEmail, schePrefDay, schePrefTime, category, service};
            adapter.export(filename, line);
        }
    }

    private int generateServiceOrderNumber() {
        return 1000 + serviceOrders.size();
    }

}
