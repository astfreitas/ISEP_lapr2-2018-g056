/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceRequest;
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
public class CreateServiceRequestControllerTest {
    
    public CreateServiceRequestControllerTest() {
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
     * Test of newRequest method, of class CreateServiceRequestController.
     */
    @Test
    public void testNewRequest() {
        System.out.println("newRequest");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> expResult = null;
        List<Address> result = instance.newRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class CreateServiceRequestController.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        Address address = null;
        CreateServiceRequestController instance = new CreateServiceRequestController();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceRequest method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetServiceRequest() {
        System.out.println("getServiceRequest");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServicesFromCategory method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetServicesFromCategory() {
        System.out.println("getServicesFromCategory");
        String idCat = "";
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Service> expResult = null;
        List<Service> result = instance.getServicesFromCategory(idCat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addServiceRequestDescription method, of class CreateServiceRequestController.
     */
    @Test
    public void testAddServiceRequestDescription() {
        System.out.println("addServiceRequestDescription");
        String idServ = "";
        String desc = "";
        int dur = 0;
        CreateServiceRequestController instance = new CreateServiceRequestController();
        boolean expResult = false;
        boolean result = instance.addServiceRequestDescription(idServ, desc, dur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSchedulePreference method, of class CreateServiceRequestController.
     */
    @Test
    public void testAddSchedulePreference() {
        System.out.println("addSchedulePreference");
        LocalDate date = null;
        LocalTime time = null;
        CreateServiceRequestController instance = new CreateServiceRequestController();
        instance.addSchedulePreference(date, time);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class CreateServiceRequestController.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.validate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTravelExpenses method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetTravelExpenses() {
        System.out.println("getTravelExpenses");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        double expResult = 0.0;
        double result = instance.getTravelExpenses();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalCost method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        double expResult = 0.0;
        double result = instance.getTotalCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerRequest method, of class CreateServiceRequestController.
     */
    @Test
    public void testRegisterRequest() {
        System.out.println("registerRequest");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        int expResult = 0;
        int result = instance.registerRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
