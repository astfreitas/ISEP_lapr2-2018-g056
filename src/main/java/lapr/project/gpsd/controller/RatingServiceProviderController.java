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

    public RatingServiceProviderController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
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
        this.servOrder = servOrder;
        return servOrder.getServiceProvider();
    }

    public void setRating(int rating){
        this.servProvider.registerEvaluation(rating,this.servOrder);
        this.servProvider.recalculateAverage();
    }
    
    public ServiceRequestDescription getServiceDescription(){
        return this.servOrder.getServiceRequestDescription();
    }
    
    public Client getClient(){
        return this.servOrder.getServiceRequest().getClient();
    }
    
    public double getServiceCost(){
        return this.servOrder.getServiceRequestDescription().getCost();
    }
    
    public double getTravelCost(){
        return this.servOrder.getServiceRequest().getOtherCost();
    }
}
