package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeographicAreaTest {
    
    /**
     * Test of getGeoId method, of class GeographicArea.
     */
    @Disabled
    public void testGetGeoId() {
        System.out.println("getGeoId");
        GeographicArea instance = null;
        String expResult = "";
        String result = instance.getGeoId();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasId method, of class GeographicArea.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String id = "";
        GeographicArea instance = null;
        boolean expResult = false;
        boolean result = instance.hasId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class GeographicArea.
     */
    @Disabled
    public void testGetDesignation() {
        System.out.println("getDesignation");
        GeographicArea instance = null;
        String expResult = "";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDesignation method, of class GeographicArea.
     */
    @Disabled
    public void testSetDesignation() {
        System.out.println("setDesignation");
        String designation = "";
        GeographicArea instance = null;
        instance.setDesignation(designation);
    }

    /**
     * Test of getTravelCost method, of class GeographicArea.
     */
    @Disabled
    public void testGetTravelCost() {
        System.out.println("getTravelCost");
        GeographicArea instance = null;
        double expResult = 0.0;
        double result = instance.getTravelCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setTravelCost method, of class GeographicArea.
     */
    @Disabled
    public void testSetTravelCost() {
        System.out.println("setTravelCost");
        double travelCost = 0.0;
        GeographicArea instance = null;
        instance.setTravelCost(travelCost);
    }

    /**
     * Test of getRadius method, of class GeographicArea.
     */
    @Disabled
    public void testGetRadius() {
        System.out.println("getRadius");
        GeographicArea instance = null;
        double expResult = 0.0;
        double result = instance.getRadius();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setRadius method, of class GeographicArea.
     */
    @Disabled
    public void testSetRadius() {
        System.out.println("setRadius");
        double radius = 0.0;
        GeographicArea instance = null;
        instance.setRadius(radius);
    }

    /**
     * Test of getLocationList method, of class GeographicArea.
     */
    @Test
    public void testGetLocationList() {
        System.out.println("getLocationList");
        GeographicArea instance = null;
        List<Location> expResult = null;
        List<Location> result = instance.getLocationList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocationList method, of class GeographicArea.
     */
    @Disabled
    public void testSetLocationList() {
        System.out.println("setLocationList");
        List<Location> LocationList = null;
        GeographicArea instance = null;
        instance.setLocationList(LocationList);
    }

    /**
     * Test of getMainPostalCode method, of class GeographicArea.
     */
    @Disabled
    public void testGetMainPostalCode() {
        System.out.println("getMainPostalCode");
        GeographicArea instance = null;
        PostalCode expResult = null;
        PostalCode result = instance.getMainPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMainPostalCode method, of class GeographicArea.
     */
    @Disabled
    public void testSetMainPostalCode() {
        System.out.println("setMainPostalCode");
        PostalCode mainPostalCode = null;
        GeographicArea instance = null;
        instance.setMainPostalCode(mainPostalCode);
    }

    /**
     * Test of getDistanceToPostalCode method, of class GeographicArea.
     */
    @Test
    public void testGetDistanceToPostalCode() {
        System.out.println("getDistanceToPostalCode");
        PostalCode pc = null;
        GeographicArea instance = null;
        double expResult = 0.0;
        double result = instance.getDistanceToPostalCode(pc);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class GeographicArea.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        GeographicArea instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        GeographicArea instance = null;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of setGeoId method, of class GeographicArea.
     */
    @Disabled
    public void testSetGeoId() {
        System.out.println("setGeoId");
        String geoId = "";
        GeographicArea instance = null;
        instance.setGeoId(geoId);
    }
    
}
