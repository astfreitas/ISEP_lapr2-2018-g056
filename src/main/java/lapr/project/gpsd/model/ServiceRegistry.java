package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceRegistry {

    /**
     * list of the existing services
     */

    private List<Service> services = new ArrayList<>();

    /**
     * constructor of service registry with an array of services as parameter
     *
     */
    public ServiceRegistry() {
        services = new ArrayList();
    }

    /**
     * validates if a service already exists in the existing list
     *
     * @param serv
     * @return true or false
     */
    public boolean validateService(Service serv) {
        boolean validation = true;
        if (serv == null) {
            return false;
        }
        if (services.contains(serv)) {
            return false;
        }
        return validation;
    }

    /**
     * Add service to the existing list
     *
     * @param serv
     * @return list of services with the new service added
     */
    public boolean addService(Service serv) {
        return services.add(serv);
    }

    /**
     * register the new service added and returns true or false if the service
     * was added or not
     *
     * @param serv
     * @return true or false
     */
    public boolean registerService(Service serv) {
        if (validateService(serv)) {
            addService(serv);
            return true;
        }
        return false;
    }

    /**
     * returns the list of services
     *
     * @return services
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * returns a service by service id
     *
     * @param idServ
     * @return service (if founded)
     */
    public Service getServiceById(String idServ) {
        for (Service serv : services) {
            if (serv.getId().equals(idServ)) {
                return serv;
            }
        }
        return null;
    }
    
    /**
     * Method return a list of services of a given category id;
     * @param idCat string of the category id
     * @return returns a list of services associated with the category.
     */
    public List<Service> getServicesFromCategory(String idCat) {
        List<Service> listOfServicesFromCat = new ArrayList();
        for(Service s : services) {
            if(s.getCategory().getCode().equals(idCat)) {
                listOfServicesFromCat.add(s);
            }
        }
        return listOfServicesFromCat;
    }
    
    /**
     * Method that validates the service request and returns the total cost.
     * @param serviceRequest the instance of the service reqeusted by the client.
     * @return true of the service request
     */
    public boolean validateRequest(ServiceRequest serviceRequest) {
        
        serviceRequest.calculateCost();
        
        return verifyRequest(serviceRequest);
    }
    
    /**
     * Checks if the service request has all the necessary data
     * @param serviceRequest
     * @return true if the service is valid
     */
    private boolean verifyRequest(ServiceRequest serviceRequest) {        
        return serviceRequest.validate();
    }
}
