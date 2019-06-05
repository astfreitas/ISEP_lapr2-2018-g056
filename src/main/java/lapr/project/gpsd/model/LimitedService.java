package lapr.project.gpsd.model;

public class LimitedService extends Service {

    /**
     * Limited service constructor with 5 parameters
     *
     * @param id
     * @param briefDescription
     * @param fullDescription
     * @param hourlyCost
     * @param category
     */
    public LimitedService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
        super(id, briefDescription, fullDescription, hourlyCost, category);
    }

    /**
     * returns the service cost according to the duration
     *
     * @param duration
     * @return service duration cost
     */
    @Override
    public double getDurationCost(double duration) {
        return this.getHourlyCost() * (duration / 60);
    }

}