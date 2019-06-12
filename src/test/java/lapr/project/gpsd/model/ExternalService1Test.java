package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalService1Test {
 
    /**
     * Test of getActsOnLocationList method, of class ExternalService1.
     */
    @Test
    public void testGetActsOnLocationList() {
        System.out.println("getActsOnLocationList");
        PostalCode mainPCode = null;
        double radius = 0.0;
        PostalCodeRegistry pcRegistry = null;
        ExternalService1 instance = null;
        List<Location> expResult = null;
        List<Location> result = instance.getActsOnLocationList(mainPCode, radius, pcRegistry);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Test
    public void testLoadPostalCodeList() throws Exception {
        System.out.println("loadPostalCodeList");
        ExternalService1 instance = null;
        ArrayList<PostalCode> expResult = null;
        ArrayList<PostalCode> result = instance.loadPostalCodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistanceBetCP method, of class ExternalService1.
     */
    @Test
    public void testGetDistanceBetCP() {
        System.out.println("getDistanceBetCP");
        PostalCode pc1 = null;
        PostalCode pc2 = null;
        ExternalService1 instance = null;
        double expResult = 0.0;
        double result = instance.getDistanceBetCP(pc1, pc2);
        assertEquals(expResult, result, 0.0);
    }
    
}
