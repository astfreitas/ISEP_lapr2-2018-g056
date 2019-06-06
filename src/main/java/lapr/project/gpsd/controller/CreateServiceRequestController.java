package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;

public class CreateServiceRequestController {
    Company company; 
    Client cli;
    ServiceRequestRegistry srr;
    ServiceRequest serviceRequest;
    ServiceRegistry servReg;
    public CreateServiceRequestController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }
    /**
     * Method will return the list of addresses from the logged in user.
     * @return returns list of addresses
     */
    public List<Address> newRequest() {
       ApplicationGPSD app = ApplicationGPSD.getInstance();
       UserSession session = app.getCurrentSession();
       String email = session.getUserEmail();
       ClientRegistry rc = company.getClientRegistry();
       cli = rc.getClientByEmail(email);
       return cli.getAddresses();
    }
    /**
     * Method that defines the address where the service will take place
     * @param local 
     * @param postalCode
     * @param address 
     */
    public void setAddress(String local, PostalCode postalCode, String address) {
        Address endP = cli.getAddress(local, postalCode, address); 
        srr = company.getServiceRequestRegistry();
        serviceRequest = srr.newServiceRequest(cli, endP);
    }
    /**
     * Method returns the list of categories that exists in the company
     * @return return a list of Category instances
     */
    public List<Category> getCategories() {
        CategoryRegistry catr = company.getCategoryRegistry();
        return catr.getCategories();
    }
    /**
     * Method returns the list of services from a given category ID.
     * @param idCat string of the category id
     * @return returns a list of services associated with the category
     */
    public List<Service> getServicesFromCategory(String idCat) {
        servReg = company.getServiceRegistry();
        List<Service> ls = servReg.getServicesFromCategory(idCat);
        return ls;
    }
    /**
     * Method appends a service with client's preferences to the whole Service Request
     * @param idServ String id of the Service requested
     * @param desc description of the client request {could be empty]
     * @param dur duration of the service
     * @return true if the service is created.
     */
    public boolean addServiceRequestDescription(String idServ, String desc, int dur) {
        Service s = servReg.getServiceById(idServ);
        return serviceRequest.addServiceRequestDescription(s, desc, dur);
    }
    /**
     * Method appends a schedule preference to the Service Order
     * @param date represents the date preference
     * @param time represents the time preference
     */
    public void addSchedulePreference(LocalDate date, LocalTime time) {
        serviceRequest.addSchedulePreference(date, time);
    }
   
    
}
