package lapr.project.gpsd.model;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    
    /**
     * Test of getName method, of class Client.
     */
    @Disabled
    public void testGetName() {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Client.
     */
    @Disabled
    public void testGetEmail() {
        System.out.println("getEmail");
        Client instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasEmail method, of class Client.
     */
    @Test
    public void testHasEmail() {
        System.out.println("hasEmail");
        String email = "test@test.com";
        Client instance = new Client("test", "test", "test", "test@test.com");
        boolean expResult = true;
        boolean result = instance.hasEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAddress method, of class Client.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        Address address = null;
        Client instance = null;
        boolean expResult = false;
        boolean result = instance.addAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAddress method, of class Client.
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        Address address = null;
        Client instance = null;
        boolean expResult = false;
        boolean result = instance.removeAddress(address);
        assertEquals(expResult, result);
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
    @Disabled
    public void testToString() {
        System.out.println("toString");
        Client instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of newAddress method, of class Client.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        Address expResult = null;
        Address result = Client.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNIF method, of class Client.
     */
    @Disabled
    public void testGetNIF() {
        System.out.println("getNIF");
        Client instance = null;
        String expResult = "";
        String result = instance.getNIF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddresses method, of class Client.
     */
    @Disabled
    public void testGetAddresses() {
        System.out.println("getAddresses");
        Client instance = null;
        ArrayList<Address> expResult = null;
        ArrayList<Address> result = instance.getAddresses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Client.
     */
    @Disabled
    public void testGetAddress() {
        System.out.println("getAddress");
        String local = "";
        PostalCode postalCode = null;
        String address = "";
        Client instance = null;
        Address expResult = null;
        Address result = instance.getAddress(local, postalCode, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateAddress method, of class Client.
     */
    @Test
    public void testValidateAddress() {
        System.out.println("validateAddress");
        Address address = null;
        Client instance = null;
        boolean expResult = false;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
