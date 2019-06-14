package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortRandomTest {
 
    /**
     * Test of sortServiceList method, of class SortRandom.
     */
    @Disabled
    public void testSortServiceList() {
        System.out.println("sortServiceList");
        List<ServiceRequestDescription> services = null;
        SortRandom instance = new SortRandom();
        instance.sortServiceList(services);
    }
    
}
