package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingFIFOTest {
  
    /**
     * Test of sortServiceList method, of class SortingFIFO.
     */
    @Disabled
    public void testSortServiceList() {
        System.out.println("sortServiceList");
        List<ServiceRequestDescription> services = null;
        SortingFIFO instance = new SortingFIFO();
        instance.sortServiceList(services);
    }
    
}
