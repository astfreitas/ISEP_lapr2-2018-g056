package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISortingBehaviorTest {

    /**
     * Test of sortServiceList method, of class ISortingBehavior.
     */
    @Disabled
    public void testSortServiceList() {
        System.out.println("sortServiceList");
        List<ServiceRequestDescription> services = null;
        ISortingBehavior instance = new ISortingBehaviorImpl();
        instance.sortServiceList(services);
    }

    public class ISortingBehaviorImpl implements ISortingBehavior {

        public void sortServiceList(List<ServiceRequestDescription> services) {
        }
    }
    
}
