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
public final class ServiceProviderStatistics {

    // Labels available to assign to the Service Provider
    static final String LABEL_WORST = "Worst Provider";
    static final String LABEL_REGULAR = "Regular Provider";
    static final String LABEL_OUTSTANDING = "Outstanding Provider";

    // Average rating of each Service Provider in the Registry
    private final List<Double> SPSAverageRatings;

    // Average rating of the Service Provider under analysis
    private final double spAverageRating;

    // Mean Average rating for the population of Service Providers in Registry
    private final double populationMeanAverageRating;

    // Standard deviation of the average rating for the population of SP's
    private final double populationStdDeviation;

    // SP's average rating's deviation from the population's mean average rating
    private final double spAbsoluteDifference;

    // SP's classification (label)
    private String classification;

    // SP's ratings
    private List<Integer> spRatings;

    public ServiceProviderStatistics(List<Double> SPSAverageRatings, List<Integer> spRatings) {
        if ((SPSAverageRatings == null) || (SPSAverageRatings.isEmpty())
                || (spRatings == null) || (spRatings.isEmpty())) {
            throw new IllegalArgumentException("Unable to create statistics. Service Provider has no ratings.");
        }
        this.spRatings = spRatings;
        this.SPSAverageRatings = SPSAverageRatings;
        this.spAverageRating = getAverageFromInt(spRatings);
        this.populationMeanAverageRating = getAverageFromDouble(SPSAverageRatings);
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
    private double calcPopulationMeanAverageRating() {
        return 0;
    }

    /**
     * Calculates the population average rating's deviation
     *
     * @return
     */
    private double calcPopulationStdDeviation() {
        double sum = 0;
        double xb = populationMeanAverageRating;
        for(double x : SPSAverageRatings) {
            sum+= Math.pow(x - xb, 2);
        }
        return Math.sqrt(sum / SPSAverageRatings.size());
    }

    /**
     * Calculates SP average rating's deviation from the population mean average
     *
     * @return
     */
    private double calcSpDeviation() {
        return spAverageRating - populationMeanAverageRating;
    }

    /**
     * Calculates the SP's classification according to it's average rating and
     * the SP's population mean average and std. deviations
     *
     * @return SP's classification (label)
     */
    private String calcClassification() {
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

    public void setClassification(String classification) {
        this.classification = classification;
    }

    
    /**
     * calculates average value from an array of doubles
     * @param vals
     * @return 
     */
    private double getAverage(double[] vals) {
        double avg = 0;
        for (double val : vals) {
            avg += val;
        }
        return avg / vals.length;
    }

    /**
     * converts list of integers into array of doubles and calculates average
     * @param integers
     * @return 
     */
    private double getAverageFromInt(List<Integer> integers) {
        double[] vals = new double[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            vals[i] = (double) integers.get(i);
        }
        return getAverage(vals);
    }

    /**
     * converts list of doubles to array of doubles and calculates average
     * @param doubles
     * @return 
     */
    private double getAverageFromDouble(List<Double> doubles) {
        double[] vals = new double[doubles.size()];
        for (int i = 0; i < doubles.size(); i++) {
            vals[i] = (double) doubles.get(i);
        }
        return getAverage(vals);
    }

    public List<Integer> getSpRatings() {
        return spRatings;
    }
    
    

}
