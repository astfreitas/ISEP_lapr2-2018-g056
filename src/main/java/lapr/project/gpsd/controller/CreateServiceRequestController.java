package lapr.project.gpsd.controller;

import lapr.project.gpsd.utils.Constants;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;

public class CreateServiceRequestController {

    private Company company;
    private Client cli;
    private ServiceRequestRegistry serviceRequestRegistry;
    private ServiceRequest serviceRequest;
    private ServiceRegistry serviceRegister;

    public CreateServiceRequestController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_CLIENT)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }

    /**
     * Method will return the list of addresses from the logged in user.
     *
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
     * @param address
     */
    public void setAddress(Address address) {
        serviceRequestRegistry = company.getServiceRequestRegistry();
        serviceRequest = serviceRequestRegistry.newServiceRequest(cli, address);
    }

    /**
     * Method returns the instance of the service requested
     *
     * @return
     */
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    /**
     * Method returns the list of categories that exists in the company
     *
     * @return return a list of Category instances
     */
    public List<Category> getCategories() {
        CategoryRegistry catr = company.getCategoryRegistry();
        return catr.getCategories();
    }

    /**
     * Method returns the list of services from a given category ID.
     *
     * @param idCat string of the category id
     * @return returns a list of services associated with the category
     */
    public List<Service> getServicesFromCategory(String idCat) {
        serviceRegister = company.getServiceRegistry();
        List<Service> ls = serviceRegister.getServicesFromCategory(idCat);
        return ls;
    }

    /**
     * Method appends a service with client's preferences to the whole Service
     * Request
     *
     * @param idServ String id of the Service requested
     * @param desc description of the client request {could be empty]
     * @param dur duration of the service
     * @return true if the service is created.
     */
    public boolean addServiceRequestDescription(String idServ, String desc, int dur) {       
        Service s = serviceRegister.getServiceById(idServ);
        if (s!=null) {
            return serviceRequest.addServiceRequestDescription(s, desc, dur);
        } else { 
            return false;
        }
    }

    /**
     * Method appends a schedule preference to the Service Order
     *
     * @param date represents the date preference
     * @param time represents the time preference
     */
    public void addSchedulePreference(LocalDate date, LocalTime time) {
        serviceRequest.addSchedulePreference(date, time);
    }

    /**
     * Method validates the clients order
     *
     * @return the instance of service request.
     */
    public ServiceRequest validate() {
        serviceRegister.validateRequest(serviceRequest);
        return serviceRequest;
    }
    
    public double getTravelExpenses() {
        return serviceRequest.getTravelExpenses();
    }
    
    public double getTotalCost() {
        return serviceRequest.getTotal();
    }
    
    /**
     * Method that registers the order.
     *
     * @return a unique number associated with the service requested or -1 if it
     * could not be added.
     */
    public int registerRequest() {
        return serviceRequestRegistry.registerServiceRequest(serviceRequest);
    }

}
