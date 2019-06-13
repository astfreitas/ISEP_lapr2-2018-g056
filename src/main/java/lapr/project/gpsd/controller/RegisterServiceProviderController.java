package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.CategoryRegistry;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.GeographicAreaRegistry;
import lapr.project.gpsd.model.SPApplication;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProviderRegistry;

public class RegisterServiceProviderController {

    /**
     * attributes of RegisterServiceProviderController
     */
    private ApplicationGPSD app;
    private Company company;
    private ServiceProviderRegistry spRegistry;
    private ServiceProvider sp;
    private String pwd;
    private SPApplication spApp;

    /**
     * Creates an instance of RegisterServiceProviderController
     *
     */
    public RegisterServiceProviderController() {
        this.app = ApplicationGPSD.getInstance();
        this.company = app.getCompany();
    }

    public boolean getApplicationData(String nif) {
        SPApplication application = this.company.getSPApplicationRegistry().getApplicationByNIF(nif);
//        if ((application != null) && (application.isAccepted(ACCEPTED_APPLICATION))) {
        if (application != null) {
            spApp = application;
            return true;
        }
        return false;
    }

    /**
     * Sets the sequence of methods necessary to create a valid SP
     *
     * Throws exception if address is not valid
     * @param name SP's name
     * @param local
     * @param postalCode
     * @param address SP's address
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean newServiceProvider(String name, String local, String postalCode, String address) {
        Address newAddress = company.getServiceProviderRegistry().newAddress(local, postalCode, address);
        spRegistry = company.getServiceProviderRegistry();
        this.sp = spRegistry.newServiceProvider(name, newAddress);
        return this.spRegistry.validateServiceProvider(this.sp);
    }

    /**
     * returns a list of categories
     *
     * @return categories list
     */
    public List<Category> getCategories() {
        CategoryRegistry cr = this.company.getCategoryRegistry();
        return cr.getCategories();
    }

    /**
     * Sets the sequence of methods necessary to add a Category to the SP
     *
     * @param catId SP's category ID
     * @return True/false if the operation succeeds or doesn't
     */
    public Category addCategory(String catId) {
        if (this.sp != null) {
            Category oCategory = this.company.getCategoryRegistry().getCatById(catId);
            this.sp.addCategory(oCategory);
            return oCategory;
        }
        return null;
    }

    /**
     * returns a list of geographic areas
     *
     * @return geographic areas list
     */
    public List<GeographicArea> getGeographicAreas() {
        GeographicAreaRegistry gar = this.company.getGeographicAreaRegistry();
        return gar.getGeographicAreas();
    }

    /**
     * Sets the sequence of methods necessary to add a Geographic area to the SP
     *
     * @param geoId SP's geographic area ID
     * @return True/false if the operation succeeds or doesn't
     */
    public GeographicArea addGeographicArea(String geoId) {
        if (this.sp != null) {
            GeographicArea oGeographicArea = this.company.getGeographicAreaRegistry().getGeoAreaById(geoId);
            this.sp.addGeoArea(oGeographicArea);
            return oGeographicArea;
        }
        return null;
    }

    /**
     * Sets the sequence of methods necessary to register a Service provider on
     * the App
     *
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean registerServiceProvider() {
        return this.spRegistry.registerServiceProvider(sp, pwd);
    }

    /**
     * Gets the created Service provider
     *
     * @return Service provider
     */
    public ServiceProvider getServiceProvider() {
        return this.sp;
    }

    /**
     * shows instance of service provider
     *
     * @return instance of service provider with some attributes
     */
    public String toStringServiceProvider() {
        return this.sp.toString();
    }

    public String getName() {
        return spApp.getName();
    }

    public Address getAddress() {
        return spApp.getAddress();
    }

    public List<String> getApplications() {
        return company.getSPApplicationRegistry().getApplicationsNifs();
    }

    public String getSPName() {
        return spApp.getName();
    }

    public String getSPAddress() {
        return spApp.getAddress().getAddress();
    }

    public String getSPPostalCode() {
        return spApp.getAddress().getPostalCode().getPostalCode();
    }

    public String getSPLocal() {
        return spApp.getAddress().getLocal();
    }

}
