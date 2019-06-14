package lapr.project.gpsd.controller;

import java.util.ArrayList;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;
import static lapr.project.gpsd.utils.Constants.*;

public class CompleteServiceController {

    /**
     * atributes of class CompleteServiceController
     */
    private Company company;
    private ServiceOrder servOrder;
    private ServiceProvider sp;
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
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        sp = spr.getServiceProviderByEmail(email);
        this.sor = this.company.getServiceOrderRegistry();
        pendingServOrders = sor.getPendingServiceOrdersByServiceProvider(PENDING_ORDER, sp);
        return pendingServOrders;
    }

    /**
     * method used to conclude a service order without any issue
     */
    public void concludeServiceOrder() {
        this.company.getServiceOrderRegistry().concludeServiceOrder(servOrder);
    }

    /**
     * 
     * Sets the Service Order used on this controller
     * 
     * @param servOrder Service Order
     */
    public void setServOrder(ServiceOrder servOrder) {
        this.servOrder = servOrder;
    }

    /**
     * 
     * Returns the Service Order used on this controller
     * 
     * @return Service Order
     */
    public ServiceOrder getServOrder() {
        return servOrder;
    }

    /**
     * method used to conclude a service order reporting an issue and respective troubleshooting
     * @param issue detected issue to report (as well as troubleshooting strategy)
     */
    public void concludeServiceOrderWithIssue(String issue) {
        this.company.getServiceOrderRegistry().concludeServiceOrderWithIssue(servOrder, issue);
    }

}
