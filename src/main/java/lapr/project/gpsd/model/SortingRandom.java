package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sorting behavior can sort a list of ServiceRequestDescriptions in random order
 */
public class SortingRandom implements ISortingBehavior {

    /**
     * Modifies (sorts) the argument list in random order
     * @param services
     * @return 
     */
    @Override
    public void sortServiceList(List<ServiceRequestDescription> services) {
        // shuffles (randomize)
        Collections.shuffle(services);
    }
    
}
