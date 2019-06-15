package lapr.project.gpsd.controller;

import java.util.ArrayList;
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

    /**
     *
     * Get the application associated with a certain NIF
     *
     * @param nif NIF of the applicant
     * @return The success of the operation
     */
    public boolean getApplicationData(String nif) {
        SPApplication application = this.company.getSPApplicationRegistry().getApplicationByNIF(nif);
        if (application != null) {
            spApp = application;
            return true;
        }
        return false;
    }

    /**
     * Creates new service providers and add to registry. Returns true if SP is
     * not duplicate (validation)
     *
     * Throws exception if address is not valid
     *
     * @param name SP's name
     * @param local
     * @param postalCode
     * @param address SP's address
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean newServiceProvider(String name, String local, String postalCode, String address) {
        Address newAddress = company.getServiceProviderRegistry().newAddress(local, postalCode, address);
        spRegistry = company.getServiceProviderRegistry();
        sp = spRegistry.newServiceProvider(name, newAddress);
        spApp.getCategories().forEach((cat) -> {
            sp.addCategory(cat);
        });
        sp.setNif(spApp.getNIF());
        return this.spRegistry.validateServiceProvider(this.sp);
    }

    /**
     * returns a list of categories from registry
     *
     * @return categories list
     */
    public List<Category> getCategories() {
        CategoryRegistry cr = this.company.getCategoryRegistry();
        return cr.getCategories();
    }

    /**
     * return the sp's list of categories
     *
     * @return
     */
    public List<Category> getSPCategories() {
        return sp.getSpCatList().getCategorylist();
    }

    /**
     * Sets the sequence of methods necessary to add a Category to the SP
     *
     * @param catId SP's category ID
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean addCategory(String catId) {
        Category oCategory = this.company.getCategoryRegistry().getCatById(catId);
        return this.sp.addCategory(oCategory);
    }

    /**
     * returns a list of geographic areas registry
     *
     * @return geographic areas list
     */
    public List<GeographicArea> getGeographicAreas() {
        GeographicAreaRegistry gar = this.company.getGeographicAreaRegistry();
        return gar.getGeographicAreas();
    }

    /**
     * Return the sp's list of geographic areas
     *
     * @return
     */
    public List<GeographicArea> getSPGeographicAreas() {
        return sp.getSpGeoAreaList().getGeoAreaList();
    }

    /**
     * Sets the sequence of methods necessary to add a Geographic area to the SP
     *
     * @param geoId SP's geographic area ID
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean addGeographicArea(String geoId) {
        GeographicArea area = this.company.getGeographicAreaRegistry().getGeoAreaById(geoId);
        return sp.getSpGeoAreaList().addGeographicArea(area);

    }

    /**
     * Sets the sequence of methods necessary to register a Service provider on
     * the App
     *
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean registerServiceProvider() {
        return this.spRegistry.registerServiceProvider(sp);
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

    /**
     *
     * Fetches all the not yet registered applicants
     *
     * @return Not registered applicants
     */
    public List<String> getApplications() {
        List<String> allNifs = company.getSPApplicationRegistry().getApplicationsNifs();
        List<String> acceptedNifs = new ArrayList<>();
        for (String nif : allNifs) {
            if (this.company.getServiceProviderRegistry().getServiceProviderByNif(nif) == null) {
                acceptedNifs.add(nif);
            }
        }
        return acceptedNifs;
    }

    /**
     *
     * Gets the applicant's name
     *
     * @return Applicant's name
     */
    public String getSPName() {
        return spApp.getName();
    }

    /**
     *
     * Gets the applicant's address
     *
     * @return Applicant's address
     */
    public String getSPAddress() {
        return spApp.getAddress().getAddress();
    }

    /**
     * 
     * Gets the applicant's postal code
     * 
     * @return Postal Code
     */
    public String getSPPostalCode() {
        return spApp.getAddress().getPostalCode().getPostalCode();
    }

    /**
     * 
     * Gets the applicants Local
     * 
     * @return Local
     */
    public String getSPLocal() {
        return spApp.getAddress().getLocal();
    }

    /**
     * 
     * Removes a category from the Service Provider
     * 
     * @param catId ID of the category being removed
     */
    public void removeSPCategory(String catId) {
        Category cat = company.getCategoryRegistry().getCatById(catId);
        this.sp.getSpCatList().removeCategory(cat);
    }

    /**
     * 
     * Removes a Geographic Area from the Service Provider
     * 
     * @param areaId ID of the Geographic Area being removed
     */
    public void removeSPArea(String areaId) {
        GeographicArea area = company.getGeographicAreaRegistry().getGeoAreaById(areaId);
        this.sp.getSpGeoAreaList().removeGeographicArea(area);
    }

    /**
     * 
     * Gets the Success Message
     * 
     * @return Success Message
     */
    public String getSuccessMessage() {
        return "Abreviated name: " + sp.getAbbrevName()
                + "\nInstitutional email: " + sp.getEmail()
                + "\nTemporary password: " + lapr.project.gpsd.utils.Constants.TEMPORARY_PASSWORD;
    }

}
