package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class holds the data to display the required statistics of
 * a Service Provider's ratings. Every Service Provider has a number of ratings.
 * Every Service Provider has an average rating. The population of Service
 * Providers has a mean average rating. The populations mean rating has a
 * standard deviation. A Service Provider is labeled according to his average
 * rating, the population's mean average rating and it's standard deviation.
 */
public class ServiceProviderStatistics {

    // Labels available to assign to the Service Provider
    static final String LABEL_WORST = "Worst Provider";
    static final String LABEL_REGULAR = "Regular Provider";
    static final String LABEL_OUTSTANDING = "Outstanding Provider";

    // Average rating of each Service Provider in the Registry
    private List<Double> SPSAverageRatings;

    // Average rating of the Service Provider under analysis
    private double spAverageRating;

    // Mean Average rating for the population of Service Providers in Registry
    private double populationMeanAverageRating;

    // Standard deviation of the average rating for the population of SP's
    private double populationStdDeviation;

    // SP's average rating's deviation from the population's mean average rating
    private double spAbsoluteDifference;

    // SP's classification (label)
    private String classification;

    public ServiceProviderStatistics(List<Double> SPSAverageRatings, double spAverageRating) {
        this.SPSAverageRatings = SPSAverageRatings;
        this.spAverageRating = spAverageRating;
        this.populationMeanAverageRating = calcPopulationMeanAverageRating();
        this.populationStdDeviation = calcPopulationStdDeviation();
        this.spAbsoluteDifference = calcSpDeviation();
        this.classification = calcClassification();
    }

    /**
     * Get labels applicable to ServiceProvider's classification calculated
     * according to his statistics
     *
     * @return
     */
    public static List<String> getLabels() {
        List<String> labels = new ArrayList<>();
        labels.add(LABEL_WORST);
        labels.add(LABEL_REGULAR);
        labels.add(LABEL_OUTSTANDING);
        return labels;
    }

    /**
     * Returns Average rating of each Service Provider in the Registry
     *
     * @return
     */
    public List<Double> getSPSAverageRatings() {
        return SPSAverageRatings;
    }

    /**
     * Returns Average rating of the Service Provider under analysis
     *
     * @return
     */
    public double getSpAverageRating() {
        return spAverageRating;
    }

    /**
     * Returns Mean Average rating for the population of Service Providers in
     * Registry
     *
     * @return
     */
    public double getPopulationMeanAverageRating() {
        return populationMeanAverageRating;
    }

    /**
     * Returns Standard deviation of the average rating for the population of
     * SP's
     *
     * @return
     */
    public double getPopulationStdDeviation() {
        return populationStdDeviation;
    }

    /**
     * Returns SP's average rating's deviation from the population's mean
     * average rating
     *
     * @return
     */
    public double getSpAbsoluteDifference() {
        return spAbsoluteDifference;
    }

    /**
     * Returns SP's classification
     *
     * @return
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Calculates the mean average rating for the SP's population
     *
     * @return
     */
    public double calcPopulationMeanAverageRating() {
        return 0;
    }

    /**
     * Calculates the population average rating's deviation
     *
     * @return
     */
    public double calcPopulationStdDeviation() {
        return 0;
    }

    /**
     * Calculates SP average rating's deviation from the population mean average
     *
     * @return
     */
    public double calcSpDeviation() {
        return 0;
    }

    /**
     * Calculates the SP's classification according to it's average rating and
     * the SP's population mean average and std. deviations
     *
     * @return SP's classification (label)
     */
    public String calcClassification() {
        if (spAverageRating < populationMeanAverageRating - populationStdDeviation) {
            return LABEL_WORST;
        } else if (spAverageRating >= populationMeanAverageRating - populationStdDeviation
                && spAverageRating <= populationMeanAverageRating + populationStdDeviation) {
            return LABEL_REGULAR;
        } else if (spAverageRating > populationMeanAverageRating + populationStdDeviation) {
            return LABEL_OUTSTANDING;
        }
        return null;
    }

}
