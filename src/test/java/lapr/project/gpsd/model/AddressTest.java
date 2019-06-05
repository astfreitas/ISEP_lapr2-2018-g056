package lapr.project.gpsd.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class AddressTest {
    
    public AddressTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLocal method, of class Address.
     */
    @Ignore
    public void testGetLocal() {
        System.out.println("getLocal");
        Address instance = null;
        String expResult = "";
        String result = instance.getLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocal method, of class Address.
     */
    @Ignore
    public void testSetLocal() {
        System.out.println("setLocal");
        String local = "";
        Address instance = null;
        instance.setLocal(local);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostalCode method, of class Address.
     */
    @Ignore
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Address instance = null;
        PostalCode expResult = null;
        PostalCode result = instance.getPostalCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostalCode method, of class Address.
     */
    @Ignore
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "";
        Address instance = null;
        instance.setPostalCode(postalCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Address.
     */
    @Ignore
    public void testGetAddress() {
        System.out.println("getAddress");
        Address instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Address.
     */
    @Ignore
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Address instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherAddress = new Address("Place", "1234-567", "Test street");
        Address instance = new Address("Place", "1234-567", "Test street");
        boolean expResult = true;
        boolean result = instance.equals(otherAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Address.
     */
    @Ignore
    public void testToString() {
        System.out.println("toString");
        Address instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
