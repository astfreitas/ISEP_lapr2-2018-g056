package lapr.project.gpsd.model;

import java.util.ArrayList;
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
        String id = "150";
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("150", "GeoArea1", 150, 25, "4000-007", exService, pcReg);
        boolean expResult = true;
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
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            List<PostalCode> listPC = exService.loadPostalCodeList();
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea instance = new GeographicArea("150", "GeoArea1", 150, 25, "4000-007", exService, pcReg);
        PostalCode pc = new PostalCode("4000-007", 41.1469459, -8.6064074);
        List<Location> expResult = exService.getActsOnLocationList(pc, 25, pcReg);
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
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea instance = new GeographicArea("150", "GeoArea1", 150, 2500, "4000-007", exService, pcReg);
        PostalCode pc = new PostalCode("4000-008", 41.1579438,-8.6291053);
        double expResult = exService.getDistanceBetCP(instance.getMainPostalCode(),pc);
        double result = instance.getDistanceToPostalCode(pc);
        System.out.println();
        assertEquals(expResult, result, 0.1);
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
        
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            List<PostalCode> listPC = exService.loadPostalCodeList();
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea instance = new GeographicArea("150", "GeoArea1", 150, 25, "4000-007", exService, pcReg);
        Object otherObject = new GeographicArea("160", "GeoArea2", 100, 10, "4000-009", exService, pcReg);
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
