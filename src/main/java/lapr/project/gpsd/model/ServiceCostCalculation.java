package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public interface ServiceCostCalculation {

    /**
     * method for calculating the cost of the service according to the duration
     * of the service
     *
     * @param duration duration of the service
     * @return cost of service according to the duration
     */
    public double getDurationCost(double duration);

    /**
     * returns a list of other atributes
     *
     * @return list of other atributes
     */
    public List<String> getOtherAtributes();

    /**
     * verifies if a service has other attributes
     *
     * @return true or false
     */
    public boolean hasOtherAttributes();

    /**
     * modifies additional data if a service has other attributes
     *
     * @param data
     * @return true or false
     */
    public boolean setAdditionalData(String data);

}
