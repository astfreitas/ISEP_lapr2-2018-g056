package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lapr.project.gpsd.controller.ApplicationGPSD;
import lapr.project.gpsd.utils.Constants;

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
     * Creates and returns an instance of Service provider
     *
     * @param name Service provider's name
     * @param address Service provider's address
     * @return Service provider instantiated
     */
    public ServiceProvider newServiceProvider(String name, Address address) {
        return new ServiceProvider(name, address);
    }

    /**
     * Checks the registry if the Service Provider is already present in the
     * registry
     *
     * @param sp
     * @return True/false if the Service provider is/isn't validated
     */
    public boolean validateServiceProvider(ServiceProvider sp) {
        for (ServiceProvider serviceProvider : spList) {
            if (serviceProvider.equals(sp)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a Service provider to the registry
     *
     * @param sp Service provider registered
     * @return True/false if the Client is/isn't added
     */
    public boolean addServiceProvider(ServiceProvider sp) {
        return spList.add(sp);
    }

    /**
     * Method generates a service provider number from regist size.
     *
     * @return a number to be set in the ServiceProvider.
     */
    private int generateServiceProviderNumber(ServiceProvider sp) {
        int number = 1000 + spList.size();
        sp.setNumber(number);
        return number;
    }

    /**
     *
     * Registers the Service Provider as a User and adds it to the Registry
     *
     * @param sp Instande of Service provider to be registered
     * @param pwd Service provider's password
     * @return True/false if the operation succeeds/fails
     */
    public boolean registerServiceProvider(ServiceProvider sp, String pwd) {
        int number = generateServiceProviderNumber(sp);
        String companyName = ApplicationGPSD.getInstance().getCompany().getDesignation();
        String emailCompanyName = companyName.trim().toLowerCase().replace(" ", "");
        String spEmail = number + "@" + emailCompanyName + ".com";
        int firstNameIndex = sp.getName().indexOf(' ');
        int lastNameIndex = sp.getName().lastIndexOf(' ');
        String abbrevName = sp.getName().substring(0, firstNameIndex) + sp.getName().substring(lastNameIndex);

        if (ApplicationGPSD.getInstance().getCompany().getAuthenticationFacade().registerUserWithRole(abbrevName, spEmail, pwd, Constants.ROLE_SERVICE_PROVIDER)) {
            return this.addServiceProvider(sp);
        }

        return false;
    }

    /**
     * Searches the Service Provider registry for a SP with a determined email
     * and returns it.
     *
     * @param email Email for the preferred SP
     * @return Service provider who has the email
     */
    public ServiceProvider getServiceProviderByEmail(String email) {
        for (ServiceProvider sp : spList) {
            if (sp.getEmail().equals(email)) {
                return sp;
            }
        }
        return null;
    }

    public List<ServiceProvider> getServiceProviders() {
        return spList;
    }

    public List<Double> getAverageRatings() {
        return null;
        // to-do
    }

}
