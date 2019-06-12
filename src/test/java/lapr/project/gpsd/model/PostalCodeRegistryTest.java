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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatchingPostalCode method, of class PostalCodeRegistry.
     */
    @Test
    public void testGetMatchingPostalCode() {
        System.out.println("getMatchingPostalCode");
        String strCP = "";
        PostalCodeRegistry instance = new PostalCodeRegistry();
        PostalCode expResult = null;
        PostalCode result = instance.getMatchingPostalCode(strCP);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchMatchPostalCode method, of class PostalCodeRegistry.
     */
    @Test
    public void testSearchMatchPostalCode() {
        System.out.println("searchMatchPostalCode");
        String strPC = "";
        PostalCodeRegistry instance = new PostalCodeRegistry();
        List<PostalCode> expResult = null;
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        assertEquals(expResult, result);
    }
    
}
