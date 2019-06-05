
package lapr.project.gpsd.model;

public interface ServiceCostCalculation {
    
    /**
     * method for calculating the cost of the service according to the duration of the service
     * @param dur duration of the service
     * @return cost of service according to the duration
     */
    public double getDurationCost(double duration);
}
