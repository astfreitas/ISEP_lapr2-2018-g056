package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
   
    /**
     * Test of getPostalCode method, of class Location.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Location instance = new Location(new PostalCode("4000-007", 41.1469459, -8.60640740),50);
        PostalCode expResult = new PostalCode("4000-007", 41.1469459, -8.60640740);
        PostalCode result = instance.getPostalCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPostalCode method, of class Location.
     */
    @Test
    public void testGetPostalCodeFailExp() {
        System.out.println("getPostalCode");
        Location instance = new Location(new PostalCode("4000-007", 41.1469459, -8.60640740),50);
        PostalCode expResult = new PostalCode("4000-015", 41.1535831, -8.5980628);
        PostalCode result = instance.getPostalCode();
        assertNotEquals(expResult, result);
    }
    

    /**
     * Test of getDistance method, of class Location.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Location instance = new Location(new PostalCode("4000-007", 41.1469459, -8.60640740),50);
        double expResult = 50;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.01);
    }
    
    /**
     * Test of getDistance method, of class Location.
     */
    @Test
    public void testGetDistanceFailExp() {
        System.out.println("getDistance");
        Location instance = new Location(new PostalCode("4000-007", 41.1469459, -8.60640740),50);
        double expResult = 10;
        double result = instance.getDistance();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Location.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Location instance = new Location(new PostalCode("4000-007", 41.1469459, -8.60640740),50);
        String expResult = "\n"+"4000-007" + " -> " + "50.00";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
