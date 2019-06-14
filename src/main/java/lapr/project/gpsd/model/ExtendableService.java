package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class ExtendableService extends Service {

    /**
     * service constructor with 5 parameters
     *
     * @param id
     * @param briefDescription
     * @param fullDescription
     * @param hourlyCost
     * @param category
     */
    public ExtendableService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
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

    /**
     * returns a list of other attributes
     *
     * @return list of other attributes
     */
    public List<String> getOtherAtributes() {
        List<String> otherAttributes = new ArrayList();
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
     * returns false because it has no additional data
     *
     * @param data
     * @return false
     */
    @Override
    public boolean setAdditionalData(String data) {
        return false;
    }

    @Override
    public boolean hasAttribute(String attribute) {
        return false;
    }

}
