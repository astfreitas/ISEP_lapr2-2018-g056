package lapr.project.gpsd.controller;

import java.util.ArrayList;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;

public class RatingServiceProviderController {

    private Company company;
    private ServiceOrder servOrder;
    private int rating;
    private Client cli;
    private ServiceProvider servProvider;

    /**
     * 
     * Creates an instance of RatingServiceProvider Controller
     * 
     */
    public RatingServiceProviderController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        ApplicationGPSD.getInstance().bootstrap();
    }

    /**
     * 
     * Sets the Service Order used on the controller
     * 
     * @param servOrder Service order
     */
    public void setServOrder(ServiceOrder servOrder) {
        this.servOrder = servOrder;
    }
    
    
    public void setServiceProvider(){
        this.servProvider = this.servOrder.getServiceProvider();
    }
    
    public ArrayList<ServiceOrder> getClientServices() {
        UserSession session = ApplicationGPSD.getInstance().getCurrentSession();
        String email = session.getUserEmail();
        ClientRegistry cr = company.getClientRegistry();
        cli = cr.getClientByEmail(email);
        ServiceOrderRegistry sor = company.getServiceOrderRegistry();
        ArrayList<ServiceOrder> lse = sor.getCompletedServiceOrdersByClient(cli);
        return lse;
    }
    
    public ServiceProvider getServiceProvider(ServiceOrder servOrder){
        return servOrder.getServiceProvider();
    }

    public void setRating(int rating){
        this.servProvider.registerEvaluation(rating,this.servOrder);
    }
    
    public ServiceRequestDescription getServiceDescription(){
        return this.servOrder.getServiceRequestDescription();
    }
    
    public Client getClient(){
        return this.servOrder.getServiceRequest().getClient();
    }
    
    public ServiceRequest getServiceRequest(){
        return this.servOrder.getServiceRequest();
    }

    public ServiceOrder getServOrder() {
        return servOrder;
    }
    
    public double getServiceCost(){
        return this.servOrder.getServiceRequestDescription().getCost();
    }
    
    public double getTravelCost(){
        return this.servOrder.getServiceRequest().getOtherCost();
    }
}
