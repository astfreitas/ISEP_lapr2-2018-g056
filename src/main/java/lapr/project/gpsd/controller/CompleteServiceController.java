package lapr.project.gpsd.controller;

import java.util.ArrayList;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;
import static lapr.project.gpsd.utils.Constants.*;

public class CompleteServiceController {

    /**
     * atributes of class CompleteServiceController
     */
    private Company company;
    private ServiceOrder servOrder;
    private ServiceOrderStatus servOrderstatus;
    private ArrayList<ServiceOrder> servOrders;
    private ServiceOrderRegistry sor;
    private ServiceRequestDescription servDesc;
    private ArrayList<ServiceOrder> pendingServOrders;

    /**
     * constructor of class CompleteServiceController
     */
    public CompleteServiceController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_SERVICE_PROVIDER)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.servOrders = new ArrayList<>();
    }

    /**
     * mehod to obtain the pending service orders, returning a list of pending service orders
     * @return list of pending service orders
     */
    public ArrayList<ServiceOrder> getPendingServiceOrders() {
        this.sor = this.company.getServiceOrderRegistry();
        pendingServOrders = sor.getPendingServiceOrders(PENDING_ORDER);
        return pendingServOrders;
    }

    /**
     * method to get the service description of a specific service, obtained by the service order id
     * @param orderId the service order id
     * @return service description
     */
    public ServiceRequestDescription getServiceDescriptionByOrderId(String orderId) {
        servOrder = this.company.getServiceOrderRegistry().getServiceOrderByID(this.pendingServOrders, orderId);
        servDesc = servOrder.getServiceRequestDescription();
        return servDesc;
    }

    /**
     * method used to conclude a service order without any issue
     */
    public void concludeServiceOrder() {
        this.company.getServiceOrderRegistry().concludeServiceOrder(servOrder);
    }

    /**
     * method used to conclude a service order reporting an issue and respective troubleshooting
     * @param issue detected issue to report (as well as troubleshooting strategy)
     */
    public void concludeServiceOrderWithIssue(String issue) {
        this.company.getServiceOrderRegistry().concludeServiceOrderWithIssue(servOrder, issue);
    }

}
