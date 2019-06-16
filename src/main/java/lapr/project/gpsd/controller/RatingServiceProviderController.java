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
    
    /**
     * 
     * Sets the Service Provider being rated
     * 
     */
    public void setServiceProvider(){
        this.servProvider = this.servOrder.getServiceProvider();
    }
    
    /**
     * 
     * Gets all the Client's completed services
     * 
     * @return Client's completed services
     */
    public ArrayList<ServiceOrder> getClientServices() {
        UserSession session = ApplicationGPSD.getInstance().getCurrentSession();
        String email = session.getUserEmail();
        ClientRegistry cr = company.getClientRegistry();
        cli = cr.getClientByEmail(email);
        ServiceOrderRegistry sor = company.getServiceOrderRegistry();
        ArrayList<ServiceOrder> lse = sor.getCompletedServiceOrdersByClient(cli);
        return lse;
    }
    
    /**
     * 
     * Gets the Service Provider being rated
     * 
     * @param servOrder Service Order being rated
     * @return Service Provider being rated
     */
    public ServiceProvider getServiceProvider(ServiceOrder servOrder){
        return servOrder.getServiceProvider();
    }

    /**
     * 
     * Sets the rating
     * 
     * @param rating Rating
     */
    public void setRating(int rating){
        this.servProvider.registerEvaluation(rating,this.servOrder);
    }
    
    /**
     * 
     * Gets the Service Request Description
     * 
     * @return Service Request Description
     */
    public ServiceRequestDescription getServiceDescription(){
        return this.servOrder.getServiceRequestDescription();
    }
    
    /**
     * 
     * Gets the client
     * 
     * @return Client
     */
    public Client getClient(){
        return this.servOrder.getServiceRequest().getClient();
    }
    
    /**
     * 
     * Gets the Service Request
     * 
     * @return Service Request
     */
    public ServiceRequest getServiceRequest(){
        return this.servOrder.getServiceRequest();
    }

    /**
     * 
     * Gets the Service Order
     * 
     * @return Service Order
     */
    public ServiceOrder getServOrder() {
        return servOrder;
    }
    
    /**
     * 
     * Gets the Service Cost
     * 
     * @return Service Cost
     */
    public double getServiceCost(){
        return this.servOrder.getServiceRequestDescription().getCost();
    }
    
    /**
     * 
     * Gets the travel expenses
     * 
     * @return Travel expenses
     */
    public double getTravelCost(){
        return this.servOrder.getServiceRequest().getOtherCost();
    }
}
