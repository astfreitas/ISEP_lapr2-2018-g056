/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaoferreira
 */
public class RegisterClientControllerTest {
    
    public RegisterClientControllerTest() {
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
     * Test of newClient method, of class RegisterClientController.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String name = "";
        String NIF = "";
        String telephone = "";
        String email = "";
        String pwd = "";
        RegisterClientController instance = new RegisterClientController();
        boolean expResult = false;
        boolean result = instance.newClient(name, NIF, telephone, email, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAddress method, of class RegisterClientController.
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        Address address = null;
        RegisterClientController instance = new RegisterClientController();
        boolean expResult = false;
        boolean result = instance.removeAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAddress method, of class RegisterClientController.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        RegisterClientController instance = new RegisterClientController();
        Address expResult = null;
        Address result = instance.addAddress(local, postalCode, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerCliente method, of class RegisterClientController.
     */
    @Test
    public void testRegisterCliente() {
        System.out.println("registerCliente");
        RegisterClientController instance = new RegisterClientController();
        boolean expResult = false;
        boolean result = instance.registerCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClient method, of class RegisterClientController.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        RegisterClientController instance = new RegisterClientController();
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringClient method, of class RegisterClientController.
     */
    @Test
    public void testToStringClient() {
        System.out.println("toStringClient");
        RegisterClientController instance = new RegisterClientController();
        String expResult = "";
        String result = instance.toStringClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
