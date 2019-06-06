package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderRegistry {

    private List<ServiceProvider> spList;

    /**
     *
     * Creates an instance of Service Provicer Registry
     *
     */
    public ServiceProviderRegistry() {
        this.spList = new ArrayList<>();
    }

    /**
     *
     * Searches the Service Provider registry for a SP with a determined email
     * and returns it.
     *
     * @param email Email for the preferred SP
     * @return Service provider who has the email
     */
    public ServiceProvider getServiceProviverByEmail(String email) {
        for (ServiceProvider sp : spList) {
            if (sp.getEmail().equals(email)) {
                return sp;
            }
        }
        return null;
    }
}
