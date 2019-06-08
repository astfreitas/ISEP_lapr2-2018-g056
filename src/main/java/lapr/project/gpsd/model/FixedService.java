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
    public FixedService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category, ServiceType serviceType) {
        super(id, briefDescription, fullDescription, hourlyCost, category, serviceType);
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

    public double getPredeterminedDuration() {
        return predeterminedDuration;
    }

    @Override
    public ArrayList[] getAmountOfAttributes(Service service) {
        ArrayList[] qttAttributes = new ArrayList[7];
        return qttAttributes;
    }

}
