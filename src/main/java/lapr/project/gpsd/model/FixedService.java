package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class FixedService extends Service {

    private double predeterminedDuration;
    private final static double WITHOUT_PREDETERMINE_DURATION = 60;//60 minutes | hourlyCost = total cost;

    /**
     * Fixed service constructor with 5 parameters
     *
     * @param id
     * @param briefDescription
     * @param fullDescription
     * @param hourlyCost
     * @param category
     */
    public FixedService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
        super(id, briefDescription, fullDescription, hourlyCost, category);
        this.predeterminedDuration = WITHOUT_PREDETERMINE_DURATION;
    }

    /**
     * returns the service cost according to the duration
     *
     * @param duration
     * @return service duration cost
     */
    @Override
    public double getDurationCost(double duration) {
        return this.getHourlyCost() * (predeterminedDuration / 60);
    }

    /**
     * returns predetermined durtation of FixedService
     *
     * @return predetermined durtation of FixedService
     */
    public double getPredeterminedDuration() {
        return predeterminedDuration;
    }

    /**
     * modifies predetermined durtation of FixedService
     *
     * @param predeterminedDuration
     */
    public void setPredeterminedDuration(double predeterminedDuration) {
        this.predeterminedDuration = predeterminedDuration;
    }

    /**
     * returns a list of other attributes
     *
     * @return list of other attributes
     */
    public List<String> getOtherAtributes() {
        List<String> otherAttributes = new ArrayList();
        otherAttributes.add("predeterminedDuration");
        return otherAttributes;
    }

    /**
     * verifies if the service has other attributes and returns true or false
     *
     * @return true or false
     */
    public boolean hasOtherAttributes() {
        return getOtherAtributes().size() > 0;
    }

    /**
     * verifies if the service has other attributes and modifies the respective
     * atribute. also returns true or false if operation was succeded
     *
     * @param data
     * @return true or false
     */
    @Override
    public boolean setAdditionalData(String data) {
        if (hasOtherAttributes()) {
            setPredeterminedDuration(Double.parseDouble(data));
            return true;
        }
        return false;
    }
}
