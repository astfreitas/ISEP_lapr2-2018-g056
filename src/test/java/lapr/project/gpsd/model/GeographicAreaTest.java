package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeographicAreaTest {

    /**
     * Test of getGeoId method, of class GeographicArea.
     */
    @Test
    public void testGetGeoId() {
        System.out.println("getGeoId");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("GeoaDes", 50, 2500, "4000-007", exService, pcReg);
        String expResult = null;
        String result = instance.getGeoId();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testEquals_False() {
        System.out.println("getGeoId");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("GeoaDes", 50, 2500, "4000-007", exService, pcReg);
        Client cli = new Client("name", "nif", "tel", "mail");
        boolean result = instance.equals(cli);
        
        assertFalse(result);
    }
    
     /**
     * Test of equals method, of class GeographicArea.
     */
    @Test
    public void testCheckLocationsForPC_False() {
        System.out.println("getGeoId");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("GeoaDes", 50, 2500, "4000-007", exService, pcReg);
        PostalCode pc = new PostalCode("3800-000", 20.001, 10.222);
        boolean result = instance.checkLocationsForPC(pc);

        assertFalse(result);
    }
       
    /**
     * Test of GeographicArea constructor, of class GeographicArea.
     */
    @Test
    public void testGeoAreaConstructor_Negativ1() {
        System.out.println("testGeoAreaConstructor_Null");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        
        assertThrows(IllegalArgumentException.class, () -> {
            GeographicArea instance = new GeographicArea("dadads","daa", -10, 2500, "4000-007", exService, pcReg);
        });
    }
    
    /**
     * Test of GeographicArea constructor, of class GeographicArea.
     */
    @Test
    public void testGeoAreaConstructor_Negative() {
        System.out.println("testGeoAreaConstructor_Null");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        
        assertThrows(IllegalArgumentException.class, () -> {
            GeographicArea instance = new GeographicArea("GeoaDes", -10, -10, "4000-007", exService, pcReg);
        });
    }

    /**
     * Test of getGeoId method, of class GeographicArea.
     */
    @Test
    public void testGetGeoIdSucess() {
        System.out.println("getGeoId");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("ID1Test", "GeoaDes", 50, 2500, "4000-007", exService, pcReg);
        String expResult = "ID1Test";
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
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("150", "GeoArea1", 150, 25, "4000-007", exService, pcReg);
        String expResult = "GeoArea1";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class GeographicArea.
     */
    @Test
    public void testGeoConstrutorFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
            PostalCodeRegistry pcReg = new PostalCodeRegistry();
            GeographicArea instance = new GeographicArea("", "", 150, 25, "4000-007", exService, pcReg);
            String expResult = "GeoArea1";
            String result = instance.getDesignation();
            assertEquals(expResult, result);
        });
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
    @Test
    public void testGetTravelCost() {
        System.out.println("getTravelCost");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("ID1", "Designationtest", 150, 25, "4000-007", exService, pcReg);
        double expResult = 150;
        double result = instance.getTravelCost();
        assertEquals(expResult, result, 0.1);
    }
    
    /**
     * Test of getTravelCost method, of class GeographicArea.
     */
    @Test
    public void testGetTravelCostFailed() {
        System.out.println("getTravelCost");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        GeographicArea instance = new GeographicArea("ID1", "Designationtest", 150, 25, "4000-007", exService, pcReg);
        double expResult = 15;
        double result = instance.getTravelCost();
//        assertEquals(expResult, result, 0.1);
        assertNotEquals(expResult, result);
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
        PostalCode pc = new PostalCode("4000-008", 41.1579438, -8.6291053);
        double expResult = exService.getDistanceBetCP(instance.getMainPostalCode(), pc);
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

    /**
     * Test of hasDesignation method, of class GeographicArea.
     */
    @Disabled
    public void testHasDesignation() {
        System.out.println("hasDesignation");
        String desig = "";
        GeographicArea instance = null;
        boolean expResult = false;
        boolean result = instance.hasDesignation(desig);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of display method, of class GeographicArea.
     */
    @Disabled
    public void testDisplay() {
        System.out.println("display");
        GeographicArea instance = null;
        String expResult = "";
        String result = instance.display();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLocationsForPC method, of class GeographicArea.
     */
    @Disabled
    public void testCheckLocationsForPC() {
        System.out.println("checkLocationsForPC");
        PostalCode pc = null;
        GeographicArea instance = null;
        boolean expResult = false;
        boolean result = instance.checkLocationsForPC(pc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
