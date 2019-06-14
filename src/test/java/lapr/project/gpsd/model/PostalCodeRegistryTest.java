package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostalCodeRegistryTest {

    /**
     * Test of getPostalCodeList method, of class PostalCodeRegistry.
     */
    @Disabled
    public void testGetPostalCodeList() {
        System.out.println("getPostalCodeList");
        PostalCodeRegistry instance = new PostalCodeRegistry();
        List<PostalCode> expResult = null;
        List<PostalCode> result = instance.getPostalCodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostalCodeList method, of class PostalCodeRegistry.
     */
    @Disabled
    public void testSetPostalCodeList() {
        System.out.println("setPostalCodeList");
        ArrayList<PostalCode> postalCodeListReg = null;
        PostalCodeRegistry instance = new PostalCodeRegistry();
        instance.setPostalCodeList(postalCodeListReg);
    }

    /**
     * Test of getMatchingPostalCode method, of class PostalCodeRegistry.
     */
    @Test
    public void testGetMatchingPostalCode() {
        System.out.println("getMatchingPostalCode");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry instance = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            instance.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }
        String strCP = "4000-013";
        PostalCode expResult = new PostalCode("4000-013", 41.1794367, -8.6816897);
        PostalCode result = instance.getMatchingPostalCode(strCP);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchMatchPostalCode method, of class PostalCodeRegistry.
     */
    @Test
    public void testSearchMatchPostalCode() {
        System.out.println("searchMatchPostalCode");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry instance = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            instance.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }
        PostalCode pc4 = new PostalCode("4000-010", 41.1531991, -8.5980302);
        PostalCode pc5 = new PostalCode("4000-011", 41.1530502, -8.5990289);
        PostalCode pc6 = new PostalCode("4000-012", 41.1519936, -8.5985596);
        PostalCode pc7 = new PostalCode("4000-013", 41.1794367, -8.6816897);
        PostalCode pc8 = new PostalCode("4000-014", 41.1535831, -8.5980628);
        PostalCode pc9 = new PostalCode("4000-015", 41.1535831, -8.5980628);
        ArrayList<PostalCode> expResult = new ArrayList<>();
        expResult.add(pc4);
        expResult.add(pc5);
        expResult.add(pc6);
        expResult.add(pc7);
        expResult.add(pc8);
        expResult.add(pc9);
        String strPC = "4000-01";
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        assertEquals(expResult, result);
    }

}
