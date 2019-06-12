package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class ServiceProvider {

    private String nif;
    /**
     * System internal identification number of the Service Provider as String.
     * Generated by system.
     */
    private int number;
    /**
     * Name of the Service Provider.
     */
    private String name;
    /**
     * Abbreviated (short) name of the Service Provider. Generated by system.
     */
    private String abbrevName;
    /**
     * Institutional email address account. Generated by system.
     */
    private String email;
    /**
     * Address of the service provider. Intance of Address.
     */
    private Address spAddress;
    /**
     * List of Categories of service performed by the service provider. Instance
     * of SPCategoryList.
     */
    private SPCategoryList spCatList;
    /**
     * List of Geographic Area where the service provider performs services.
     * Instance of SPGeographicAreaList.
     */
    private SPGeographicAreaList spGeoAreaList;
    /**
     * Availability List of the Service Provider. Instance of AvailabilityList.
     */
    private SPAvailabilityList spAvailabilityList;
    private ArrayList<Evaluation> evalList;
    private String classification;
    private double averageRating;

    /**
     * Construtor for Service Provider receiving only the attributes name and
     * and instance of Address by the method parameters. Creates instances for
     * SPCategoryList, SPGeographicAreaList and SPAvailabilityList.
     *
     * @param name full name of the service provider
     * @param spAddress instance of Addres to register the service provider.
     */
    public ServiceProvider(String name, Address spAddress) {
        this.name = name;
        this.spAddress = spAddress;
        spCatList = new SPCategoryList();
        spGeoAreaList = new SPGeographicAreaList();
        spAvailabilityList = new SPAvailabilityList();
        this.evalList = new ArrayList<>();

    }

    /**
     * 
     * Creates an instance of Service Provider
     *
     * @param name Service Provider's name
     * @param nif Service Provider's nif
     * @param email Service Provider's email
     */
    public ServiceProvider(String name, String nif, String email) {
        if ((name == null) || (nif == null)
                || (email == null)
                || (name.isEmpty()) || (nif.isEmpty())
                || (email.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.name = name;
        this.email = email;
        this.nif = nif;
        spCatList = new SPCategoryList();
        spGeoAreaList = new SPGeographicAreaList();
        spAvailabilityList = new SPAvailabilityList();
        this.evalList = new ArrayList<>();
        this.averageRating = 3;
    }

    //ToDo: do we need a construtor receiving the full name, and the fields for
    // a Address and create a new instance fo address in the construtor?
    /**
     * Returns the System internal identification number of the SP.
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the System internal identification number of the SP.
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 
     * Gives the Service Provider NIF
     * 
     * @return Service Provider's NIF
     */
    public String getNif() {
        return nif;
    }

    /**
     * Returns the full name of the SP.
     *
     * @return full name of the SP in String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the SP.
     *
     * @param name string with full name of SP
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Abbreviated (short) name of SP.
     *
     * @return abbreviated name
     */
    public String getAbbrevName() {
        return abbrevName;
    }

    /**
     * Sets the Abbreviated (short) name of SP.
     *
     * @param abbrevName abbreviated (shor) name for SP
     */
    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }

    /**
     * Returns Institutional email address
     *
     * @return email address of SP
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Institutional email address for the Service Provider.
     *
     * @param email email address SP
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the reference for the Address instance of SP.
     *
     * @return reference for the Address instance of SP
     */
    public Address getSpAddress() {
        return spAddress;
    }

    /**
     * Sets the Address of SP with the reference received by spAddress
     *
     * @param spAddress new reference for the Service Provider.
     */
    public void setSpAddress(Address spAddress) {
        this.spAddress = spAddress;
    }

    /**
     * Returns List of Geographic Areas where the SP performs services.
     *
     * @return List GeographicArea
     */
    public SPGeographicAreaList getSpGeoAreaList() {
        return spGeoAreaList;
    }

    /**
     * Returns List of categories of service performed by SP.
     *
     * @return SPCategoryregistry
     */
    public SPCategoryList getSpCatList() {
        return spCatList;
    }

    /**
     * 
     * Adds a Category to the Service Provider
     * 
     * @param cat Category to be added
     * @return Returns the success of the operation
     */
    public boolean addCategory(Category cat) {
        return spCatList.getCategorylist().add(cat);
    }

    /**
     * 
     * Adds a Geographic Area to the Service Provider
     * 
     * @param geoArea Geographic Area to be added
     * @return Returns the success of the operation
     */
    public boolean addGeoArea(GeographicArea geoArea) {
        return spGeoAreaList.getGeoAreaList().add(geoArea);
    }

    /**
     * Returns instance of SPAvailabilityList containing the list of SP.
     *
     * @return instance of SPAvailability.
     */
    public SPAvailabilityList getSpAvailabilityList() {
        return spAvailabilityList;
    }

    /**
     * Returns a list of integers representing the ratings of the service
     * provider
     *
     * @return
     */
    public List<Integer> getRatings() {
        List<Integer> ratings = new ArrayList<>();
        for (Evaluation eval : evalList) {
            ratings.add(eval.getRating());
        }
        return ratings;
    }

    /**
     * Returns the average rating of a service provider. 
     * 
     * @return average rating for service provider
     */
    public double getAverageRating() {
        return this.averageRating;
    }

    /**
     * Sets the average rating attribute of the service provider
     *
     * @param average
     */
    public void setAverageRating(double average) {
        this.averageRating = average;
    }

    /**
     * Sets the classification of the service provider
     *
     * @param label
     */
    public void setClassification(String label) {
        classification = label;
    }

    /**
     * register new evaluation and recalculates average
     *
     * @param rating
     * @param servOrder
     */
    public void registerEvaluation(int rating, ServiceOrder servOrder) {
        Evaluation eval = new Evaluation(rating, servOrder);
        evalList.add(eval);
        recalculateAverage();
    }

    /**
     * 
     * Recalculates the average of the Service Provider
     * 
     */
    public void recalculateAverage() {
        double sum = 0;
        for (Evaluation eval : evalList) {
            sum += eval.getRating();
        }
        double average = sum / evalList.size();
        this.averageRating = average;
    }

    /**
     * Verify that service provider has Geographic Area
     *
     * @param area
     * @return
     */
    public boolean hasGeographicArea(GeographicArea area) {
        return spGeoAreaList.getGeoAreaList().contains(area);
    }

    /**
     * Verifies that Service Provider has category
     *
     * @param category
     * @return
     */
    public boolean hasCategory(Category category) {
        return spCatList.getCategorylist().contains(category);
    }

    /**
     * toString method returning only name and email
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " : " + email;
    }

    /**
     * Adds evaluation to Service provider
     *
     * @param eval
     * @return
     */
    public boolean addEvaluation(Evaluation eval) {
        return evalList.add(eval);
    }

    /**
     * 
     * Checks if the Service Provider is available in a given time window
     * 
     * @param schedule Schedule for the Service
     * @param duration Service's duration
     * @return The SP availability for the time window
     */
    public boolean isAvailable(SchedulePreference schedule, int duration) {
        return spAvailabilityList.hasAvailability(schedule, duration);
    }

}
