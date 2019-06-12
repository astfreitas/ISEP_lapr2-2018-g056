package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
   
    /**
     * Test of getPostalCode method, of class Location.
     */
    @Disabled
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Location instance = null;
        PostalCode expResult = null;
        PostalCode result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class Location.
     */
    @Disabled
    public void testGetDistance() {
        System.out.println("getDistance");
        Location instance = null;
        double expResult = 0.0;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Location.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        Location instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
