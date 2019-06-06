package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

class ServiceRegistry {

    /**
     * list of the existing services
     */
    private List<Service> services;

    /**
     * constructor of service registry with an array of services as parameter
     *
     * @param services
     */
    public ServiceRegistry(List<Service> services) {
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
            return addService(serv);
        }
        return true;
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
}
