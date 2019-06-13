package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import static lapr.project.gpsd.utils.Constants.*;
import java.util.List;
import lapr.project.gpsd.utils.Constants;

public class ServiceOrderRegistry {

    /**
     * atribute of class ServiceOrderRegistry
     */
    private List<ServiceOrder> serviceOrders;

    /**
     * constructor of ServiceOrderRegistry initialized with an empty arraylist.
     */
    public ServiceOrderRegistry() {
        this.serviceOrders = new ArrayList();
    }

    /**
     * returns a list of only pending service orders by Service Provider
     *
     * @param status Status of the service order
     * @param sp Service Provider
     * @return list List of only pending service orders
     */
    public ArrayList<ServiceOrder> getPendingServiceOrdersByServiceProvider(String status, ServiceProvider sp) {
        ArrayList<ServiceOrder> pendingServiceOrders = new ArrayList<>();
        for (ServiceOrder serviceOrder : serviceOrders) {
            if (serviceOrder.isPending(status) && serviceOrder.getServiceProvider().equals(sp)) {
                pendingServiceOrders.add(serviceOrder);
            }
        }
        return pendingServiceOrders;
    }

    /**
     * method to conclude service order
     *
     * @param servOrder service order to be concluded
     */
    public void concludeServiceOrder(ServiceOrder servOrder) {
        servOrder.getStatus().setServOrderStatus(CONCLUDED_ORDER);
    }

    /**
     * method to conclude service order reporting issue (and troubleshooting)
     *
     * @param servOrder service order to be concluded
     * @param issue issue to be reported
     */
    public void concludeServiceOrderWithIssue(ServiceOrder servOrder, String issue) {
        servOrder.getStatus().setServOrderStatus(CONCLUDED_ORDER);
        servOrder.getStatus().setServOrderDetail(issue);
    }

    public ArrayList<ServiceOrder> getCompletedServiceOrdersByClient(Client cli) {
        ArrayList<ServiceOrder> servOrderByClient = new ArrayList<>();
        for (ServiceOrder servOrder : serviceOrders) {
            if (servOrder.getServiceRequest().getClient().equals(cli) && servOrder.getStatus().getServOrderStatus().equals(Constants.CONCLUDED_ORDER)) {
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
     * Method used to store register service orders from a list of service
     * assignments.
     *
     * @param listServiceAssignments
     * @return list of serviceOrdersIDs.
     */
    public List<Integer> registerServiceOrders(List<ServiceAssignment> listServiceAssignments) {
        List<Integer> serviceOrdersIDList = new ArrayList();
        for (ServiceAssignment serviceAssignment : listServiceAssignments) {
            ServiceOrder so = new ServiceOrder(serviceAssignment);
            if (validate(so)) {
                int orderNumber = generateServiceOrderNumber();
                so.setOrderNumber(orderNumber);
                serviceOrders.add(so);
                serviceOrdersIDList.add(orderNumber);
            }
        }
        return serviceOrdersIDList;
    }

    public ServiceOrder getServiceOrderById(int id) {
        for (ServiceOrder so : serviceOrders) {
            if (so.getOrderNumber() == id) {
                return so;
            }
        }
        return null;
    }

    /**
     *
     * Creates a ServiceOrder from a ServiceAssgnment instance
     *
     * @param servAssi Service assignment
     * @return Service Order created
     */
    public ServiceOrder registerServiceOrder(ServiceAssignment servAssi) {
        ServiceOrder so = new ServiceOrder(servAssi);
        if (validate(so)) {
            int orderNumber = generateServiceOrderNumber();
            so.setOrderNumber(orderNumber);
            serviceOrders.add(so);
            return so;
        }
        return null;
    }

    /**
     * Method verifies if the service order is already exists
     *
     * @param serviceOrder instance of the service order to be added.
     * @return true if the so is not registered yet
     */
    private boolean validate(ServiceOrder serviceOrder) {
        return !serviceOrders.contains(serviceOrder);
    }

    public void exportData(List<ServiceOrder> servOrdList, String filename, FileType adapter) {
        // write header
        String[] header = {"ClientName", "ClientEmail", "SchedPrefDay", "SchePrefTime", "Category", "Service"};
        if (adapter instanceof AdapterXML) {
        } else {
            adapter.export(filename, header);
        }

        for (ServiceOrder servOrder : servOrdList) {
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

    /**
     * Method generates a service Order number from regist size.
     *
     * @return a number to be set in the ServiceOrder.
     */
    private int generateServiceOrderNumber() {
        return 1 + serviceOrders.size();
    }

}
