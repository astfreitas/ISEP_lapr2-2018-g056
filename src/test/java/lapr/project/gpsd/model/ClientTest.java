package lapr.project.gpsd.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ClientTest {
    
    public ClientTest() {
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
     * Test of getName method, of class Client.
     */
    @Ignore
    public void testGetName() {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Ignore
    public void testGetEmail() {
        System.out.println("getEmail");
        Client instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasEmail method, of class Client.
     */
    @Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String email = "test@test.com";
        Client instance = new Client(null, null, null, "test@test.com");
        boolean expResult = true;
        boolean result = instance.hasEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAddress method, of class Client.
     */
    @Ignore
    public void testAddAddress() {
        System.out.println("addAddress");
        Address address = null;
        Client instance = null;
        boolean expResult = false;
        boolean result = instance.addAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAddress method, of class Client.
     */
    @Ignore
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        Address address = null;
        Client instance = null;
        boolean expResult = false;
        boolean result = instance.removeAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Client.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherClient = new Client("Joao", "123", "987", "test@test.com");
        Client instance = new Client("Joao", "123", "987", "test@test.com");
        boolean expResult = true;
        boolean result = instance.equals(otherClient);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Client.
     */
    @Ignore
    public void testToString() {
        System.out.println("toString");
        Client instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAddress method, of class Client.
     */
    @Ignore
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        Address expResult = null;
        Address result = Client.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
