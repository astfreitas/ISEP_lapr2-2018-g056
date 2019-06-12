package lapr.project.gpsd.model;

import java.util.List;

/**
 * Sorting behavior returns the list of service descriptions order according to
 * each request's creation time
 *
 */
public class SortingFIFO implements ISortingBehavior {

    public SortingFIFO() {
    }

    /**
     * Returns a copy of the argument's list in order of service request
     * creation date
     *
     * @param services
     */
    @Override
    public void sortServiceList(List<ServiceRequestDescription> services) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
