package lapr.project.gpsd.model;

import java.util.ArrayList;

public interface ServiceCostCalculation {

    /**
     * method for calculating the cost of the service according to the duration
     * of the service
     *
     * @param duration duration of the service
     * @return cost of service according to the duration
     */
    public double getDurationCost(double duration);

    public ArrayList[] getAmountOfAttributes(Service service);
    
    public double getPredeterminedDuration();

}
