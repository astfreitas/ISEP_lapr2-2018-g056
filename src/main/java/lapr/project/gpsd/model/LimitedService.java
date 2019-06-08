package lapr.project.gpsd.model;

import java.util.ArrayList;

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
    public LimitedService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category, ServiceType serviceType) {
        super(id, briefDescription, fullDescription, hourlyCost, category, serviceType);
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

    public ArrayList[] getAmountOfAttributes(Service service) {
        ArrayList[] qttAttributes = new ArrayList[6];
        return qttAttributes;
    }

    @Override
    public double getPredeterminedDuration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
