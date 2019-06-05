package lapr.project.gpsd.model;

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

}
