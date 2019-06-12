package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPGeographicAreaListTest {
   
    /**
     * Test of getGeoAreaList method, of class SPGeographicAreaList.
     */
    @Disabled
    public void testGetGeoAreaList() {
        System.out.println("getGeoAreaList");
        SPGeographicAreaList instance = new SPGeographicAreaList();
        List<GeographicArea> expResult = null;
        List<GeographicArea> result = instance.getGeoAreaList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
