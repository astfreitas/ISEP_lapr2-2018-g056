/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Address;
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
public class AddNewAddressToClientControllerTest {
    
    public AddNewAddressToClientControllerTest() {
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
     * Test of newAddressRequest method, of class AddNewAddressToClientController.
     */
    @Test
    public void testNewAddressRequest() {
        System.out.println("newAddressRequest");
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        instance.newAddressRequest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        instance.newAddress(local, postalCode, address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testRegisterAddress() {
        System.out.println("registerAddress");
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        boolean expResult = false;
        boolean result = instance.registerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class AddNewAddressToClientController.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        AddNewAddressToClientController instance = new AddNewAddressToClientController();
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
