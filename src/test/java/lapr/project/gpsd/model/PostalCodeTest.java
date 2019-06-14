package lapr.project.gpsd.model;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostalCodeTest {

    /**
     * Test of getPostalCode method, of class PostalCode.
     */
    @Disabled
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        PostalCode instance = null;
        String expResult = "";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostalCode method, of class PostalCode.
     */
    @Disabled
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "";
        PostalCode instance = null;
        instance.setPostalCode(postalCode);
    }

    /**
     * Test of getCpLatitude method, of class PostalCode.
     */
    @Disabled
    public void testGetCpLatitude() {
        System.out.println("getCpLatitude");
        PostalCode instance = null;
        double expResult = 0.0;
        double result = instance.getCpLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCpLatitude method, of class PostalCode.
     */
    @Disabled
    public void testSetCpLatitude() {
        System.out.println("setCpLatitude");
        double cpLatitude = 0.0;
        PostalCode instance = null;
        instance.setCpLatitude(cpLatitude);
    }

    /**
     * Test of getCpLongitude method, of class PostalCode.
     */
    @Disabled
    public void testGetCpLongitude() {
        System.out.println("getCpLongitude");
        PostalCode instance = null;
        double expResult = 0.0;
        double result = instance.getCpLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCpLongitude method, of class PostalCode.
     */
    @Disabled
    public void testSetCpLongitude() {
        System.out.println("setCpLongitude");
        double cpLongitude = 0.0;
        PostalCode instance = null;
        instance.setCpLongitude(cpLongitude);
    }

    /**
     * Test of toString method, of class PostalCode.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        PostalCode instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
