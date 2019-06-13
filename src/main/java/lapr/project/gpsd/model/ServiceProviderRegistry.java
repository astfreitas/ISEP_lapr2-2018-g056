package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import lapr.project.gpsd.utils.Constants;

public class ServiceProviderRegistry {

    /**
     * attribute of ServiceProviderRegistry as a list of service providers
     */
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
     * Creates new Address instance
     *
     * @param local
     * @param postalCode
     * @param address
     * @return Address
     */
    public Address newAddress(String local, String postalCode, String address) {
        return new Address(local, postalCode, address);
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
     * @param sp service provider to set his number
     */
    private void generateServiceProviderNumber(ServiceProvider sp) {
        int number = 1000 + spList.size();
        sp.setNumber(number);
    }

    /**
     * Method generates the institutional SP email using SP number and company
     * name
     *
     * @param sp service provider to obtain number
     * @return created institutional email of service provider
     */
    private String generateServiceProviderInstEmail(ServiceProvider sp) {
        int number = sp.getNumber();
        String companyName = ApplicationGPSD.getInstance().getCompany().getDesignation();
        String emailCompanyName = companyName.trim().toLowerCase().replace(" ", "");
        String spEmail = number + "@" + emailCompanyName + "com";
        return spEmail;
    }

    /**
     * Method generates abbreviated name of service provider
     *
     * @param sp service provider to obtain full name
     */
    private void generateAbbreviatedName(ServiceProvider sp) {
        int firstNameIndex = sp.getName().indexOf(' ');
        int lastNameIndex = sp.getName().lastIndexOf(' ');
        String abbrevName = sp.getName().substring(0, firstNameIndex) + sp.getName().substring(lastNameIndex);
        sp.setAbbrevName(abbrevName);
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
        String spInstEmail = generateServiceProviderInstEmail(sp);
        sp.setEmail(spInstEmail);
        String abbrevName = sp.getAbbrevName();
        if (ApplicationGPSD.getInstance().getCompany().getAuthenticationFacade().registerUserWithRole(abbrevName, spInstEmail, pwd, Constants.ROLE_SERVICE_PROVIDER)) {
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

    /**
     * Searches the Service Provider registry for a SP with a determined number
     * and returns it.
     *
     * @param number Number for the preferred SP
     * @return Service provider who has the number
     */
    public ServiceProvider getServiceProviderByNumber(int number) {
        for (ServiceProvider sp : spList) {
            if (sp.getNumber() == number) {
                return sp;
            }
        }
        return null;
    }

    /**
     * returns a list of service providers
     *
     * @return service providers list
     */
    public List<ServiceProvider> getServiceProviders() {
        return spList;
    }

    /**
     * Returns a list of the average rating for each service provider
     *
     * @return
     */
    public List<Double> getAverageRatings() {
        List<Double> averageRatings = new ArrayList<>();
        for (ServiceProvider sp : spList) {
            averageRatings.add(sp.getAverageRating());
        }
        return averageRatings;
    }

}
