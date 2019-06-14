package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Address;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNewAddressToClientControllerTest {

    /**
     * Test of newAddressRequest method, of class
     * AddNewAddressToClientController.
     */
    @Test
    public void testNewAddressRequest() {
        System.out.println("newAddressRequest");
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        instance.newAddressRequest();
    }

    /**
     * Test of newAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testNewAddress() {
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        System.out.println("newAddress");
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        instance.newAddress(local, postalCode, address);
    }

    /**
     * Test of registerAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testRegisterAddress() {
        System.out.println("registerAddress");
        ApplicationGPSD.getInstance().bootstrap();
        System.out.println(ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190"));
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        instance.newAddressRequest();
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        instance.newAddress(local, postalCode, address);
        boolean expResult = true;
        boolean result = instance.registerAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        instance.newAddress(local, postalCode, address);
        Address expResult = new Address("testLocal", "4000-007", "testAddress");
        Address result = instance.getAddress();
        assertEquals(expResult, result);
    }

}
