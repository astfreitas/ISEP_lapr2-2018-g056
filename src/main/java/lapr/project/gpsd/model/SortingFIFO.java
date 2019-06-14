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
     * Does not modify the list
     *
     * @param services
     */
    @Override
    public void sortServiceList(List<ServiceRequestDescription> services) {
    }

}
