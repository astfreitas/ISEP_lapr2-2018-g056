package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Client;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterClientControllerTest {
    
    private RegisterClientController instance;
    
    public RegisterClientControllerTest() {
        ApplicationGPSD.getInstance().getCompany();
        ApplicationGPSD.getInstance().bootstrap();
        instance = new RegisterClientController();
    }
    
    /**
     * Test of newClient method, of class RegisterClientController.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String name = "testName";
        String NIF = "testNIF";
        String telephone = "testTel";
        String email = "testEmail";
        String pwd = "testPwd";
        boolean expResult = true;
        boolean result = instance.newClient(name, NIF, telephone, email, pwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAddress method, of class RegisterClientController.
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        instance.newClient("testName", "testNIF", "testTel", "testEmail", "testPwd");
        Address address = new Address("testLocal", "4000-007", "testAddress");
        boolean expResult = false;
        boolean result = instance.removeAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAddress method, of class RegisterClientController.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        instance.newClient("testName", "testNIF", "testTel", "testEmail", "testPwd");
        Address expResult = new Address(local, postalCode, address);
        Address result = instance.addAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerCliente method, of class RegisterClientController.
     */
    @Disabled
    public void testRegisterCliente() {
        System.out.println("registerCliente");
        boolean expResult = false;
        instance.newClient("testName", "testNIF", "testTel", "testEmail", "testPwd");
        boolean result = instance.registerCliente();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class RegisterClientController.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        instance.newClient("testName", "testNIF", "testTel", "testEmail", "testPwd");
        Client expResult = new Client("testName", "testNIF", "testTel", "testEmail");
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringClient method, of class RegisterClientController.
     */
    @Disabled
    public void testToStringClient() {
        System.out.println("toStringClient");
        RegisterClientController instance = new RegisterClientController();
        String expResult = "";
        String result = instance.toStringClient();
        assertEquals(expResult, result);
    } 
}
