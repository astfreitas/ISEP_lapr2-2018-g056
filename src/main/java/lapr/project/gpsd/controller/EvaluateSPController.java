package lapr.project.gpsd.controller;

import lapr.project.gpsd.utils.Constants;
import java.util.List;
import lapr.project.gpsd.model.*;

public class EvaluateSPController {

    private Company company;
    private ServiceProviderRegistry spr;
    private ServiceProvider sp;
    private List<ServiceProvider> spl;
    private List<Integer> r;
    private List<String> labels;
    private List<Double> arl;
    private double ar;
    private ServiceProviderStatistics sps;

    /**
     * Constructor: checks if user has HRO ROLE and sets the company reference
     * throws exception if user does not possess the right role
     */
    public EvaluateSPController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_HRO)) {
            throw new IllegalStateException("Unautorized user!");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.spr = company.getServiceProviderRegistry();
    }

    /**
     * Returns the list of service providers available in registry
     *
     * @return the List of Service Providers in Registry
     */
    public List<ServiceProvider> getServiceProviders() {
        this.spl = spr.getServiceProviders();
        if (spl.isEmpty()) {
            throw new RuntimeException("No Service Providers were found in the system.");
        }
        return spl;
    }

    /**
     * Sets the chosen Service Provider given it's email, gets it's ratings and
     * the average ratings for all service providers and creates and returns an
     * instance of SPStatistics with all the chosen Service Provider statistics
     *
     * @param email
     */
    public void newSPStatistics(String email) {
        this.sp = spr.getServiceProviderByEmail(email);
        this.r = sp.getRatings();
        this.arl = spr.getAverageRatings();
        this.ar = sp.getAverageRating();
        this.sps = new ServiceProviderStatistics(arl, r);
    }

    /**
     * Returns a String of labels available for definining the Service
     * Provider's classification
     *
     * @return List of labels for Service Provider's classification
     */
    public List<String> getLabels() {
        this.labels = ServiceProviderStatistics.getLabels();
        return labels;
    }

    /**
     * Sets the label to be used to define the Service Provider's classification
     * (local to the Controller)
     *
     * @param label
     */
    public void setLabel(String label) {
        this.sps.setClassification(label);
    }

    /**
     * returns the label chosen to define the Service Provider's classification
     *
     * @return
     */
    public String getLabel() {
        return sps.getClassification();
    }

    /**
     * Sets the Service Provider's classification to the chosen label.
     */
    public void setSPClassification() {
        sp.setClassification(sps.getClassification());
    }

    public double getPopulationMeanAverageRating() {
        return sps.getPopulationMeanAverageRating();
    }

    public double getPopulationStdDeviation() {
        return sps.getPopulationStdDeviation();
    }

    public double getSpAverageRating() {
        return sps.getSpAverageRating();
    }

    public double getSpAbsoluteDifference() {
        return sps.getSpAbsoluteDifference();
    }

    public List<Integer> getSpRatings() {
        return sps.getSpRatings();
    }

}
