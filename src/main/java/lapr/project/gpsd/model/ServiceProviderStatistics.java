package lapr.project.gpsd.model;

import java.util.List;

public class ServiceProviderStatistics {

    private List<Double> SPSAverageRatings;
    private double spAverageRating;
    private double populationAverageRating;
    private double populationAverageStdDeviation;
    private double spDeviation;
    private String classification;
    
    
    public ServiceProviderStatistics(double ar, List<Double> arl) {
    
    }
    
    public static List<String> getLabels() {
        return null;
    }
    
}
