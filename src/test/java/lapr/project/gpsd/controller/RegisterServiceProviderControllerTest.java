/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.ServiceProvider;
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
public class RegisterServiceProviderControllerTest {
    
    public RegisterServiceProviderControllerTest() {
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
     * Test of getApplicationData method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetApplicationData() {
        System.out.println("getApplicationData");
        String nif = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = false;
        boolean result = instance.getApplicationData(nif);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testNewServiceProvider() {
        System.out.println("newServiceProvider");
        String name = "";
        Address address = null;
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = false;
        boolean result = instance.newServiceProvider(name, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCategory method, of class RegisterServiceProviderController.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String catId = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        Category expResult = null;
        Category result = instance.addCategory(catId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeographicAreas method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetGeographicAreas() {
        System.out.println("getGeographicAreas");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<GeographicArea> expResult = null;
        List<GeographicArea> result = instance.getGeographicAreas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGeographicArea method, of class RegisterServiceProviderController.
     */
    @Test
    public void testAddGeographicArea() {
        System.out.println("addGeographicArea");
        String geoId = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        GeographicArea expResult = null;
        GeographicArea result = instance.addGeographicArea(geoId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testRegisterServiceProvider() {
        System.out.println("registerServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = false;
        boolean result = instance.registerServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringServiceProvider method, of class RegisterServiceProviderController.
     */
    @Test
    public void testToStringServiceProvider() {
        System.out.println("toStringServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.toStringServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAddress method, of class RegisterServiceProviderController.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.newAddress(local, postalCode, address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
