package lapr.project.gpsd.model;

import java.util.List;


public interface ISortingBehavior {

    /**
     * Sorts a service description list according to the Sorting behavior
     * @param services
     * @return
     */
    public void sortServiceList(List<ServiceRequestDescription> services);
}
