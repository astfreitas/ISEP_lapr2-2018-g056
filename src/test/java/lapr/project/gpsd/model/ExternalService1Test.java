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
    @Disabled
    public void testGetActsOnLocationList() {
        System.out.println("getActsOnLocationList");
        ExternalService1 instance = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = instance.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea geoArea = new GeographicArea("150", "GeoArea1", 150, 100000, "4000-007", instance, pcReg);

        PostalCode mainPCode = pcReg.getMatchingPostalCode("4000-007");
        double radius = 100000;                
        List<Location> expResult = geoArea.getLocationList();
        List<Location> result = instance.getActsOnLocationList(mainPCode, radius, pcReg);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Disabled
    public void testLoadPostalCodeList() throws Exception {
        System.out.println("loadPostalCodeList");
        ExternalService1 instance = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCode pc1 = new PostalCode("4000-007",41.1469459,-8.6064074);
        PostalCode pc2 = new PostalCode("4000-008",41.1579438,-8.6291053);
        PostalCode pc3 = new PostalCode("4000-009",41.1555392,-8.6061091);
        PostalCode pc4 = new PostalCode("4000-010",41.1531991,-8.5980302);
        PostalCode pc5 = new PostalCode("4000-011",41.1530502,-8.5990289);
        PostalCode pc6 = new PostalCode("4000-012",41.1519936,-8.5985596);
        PostalCode pc7 = new PostalCode("4000-013",41.1794367,-8.6816897);
        PostalCode pc8 = new PostalCode("4000-014",41.1535831,-8.5980628);
        PostalCode pc9 = new PostalCode("4000-015",41.1535831,-8.5980628);
        ArrayList<PostalCode> expResult = new ArrayList<>();
        expResult.add(pc1);
        expResult.add(pc2);
        expResult.add(pc3);
        expResult.add(pc4);
        expResult.add(pc5);
        expResult.add(pc6);
        expResult.add(pc7);
        expResult.add(pc8);
        expResult.add(pc9);
        ArrayList<PostalCode> result = instance.loadPostalCodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistanceBetCP method, of class ExternalService1.
     */
    @Test
    public void testGetDistanceBetCP() {
        System.out.println("getDistanceBetCP");
        PostalCode pc1 = new PostalCode("4000-007",41.1469459,-8.6064074);
        PostalCode pc2 = new PostalCode("4000-008",41.1579438,-8.6291053);
        ExternalService1 instance = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        double expResult = 2259.8;
        double result = instance.getDistanceBetCP(pc1, pc2);
        assertEquals(expResult, result, 0.1);
    }
    
    /**
     * Test of getDistanceBetCP method, of class ExternalService1.
     */
    @Test
    public void testGetDistanceBetCP2() {
        System.out.println("getDistanceBetCP - 2 same CP");
        PostalCode pc1 = new PostalCode("4000-007",41.1469459,-8.6064074);
        PostalCode pc2 = new PostalCode("4000-008",41.1579438,-8.6291053);
        ExternalService1 instance = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        double expResult = 0;
        double result = instance.getDistanceBetCP(pc1, pc1);
        System.out.println("Distancia: "+result);
        assertEquals(expResult, result, 0.000001);
    }
    
}
