/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.ArrayList;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;
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
public class RatingServiceProviderControllerTest {
    
    public RatingServiceProviderControllerTest() {
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
     * Test of setServOrder method, of class RatingServiceProviderController.
     */
    @Test
    public void testSetServOrder() {
        System.out.println("setServOrder");
        ServiceOrder servOrder = null;
        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setServOrder(servOrder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServiceProvider method, of class RatingServiceProviderController.
     */
    @Test
    public void testSetServiceProvider() {
        System.out.println("setServiceProvider");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setServiceProvider();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientServices method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetClientServices() {
        System.out.println("getClientServices");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getClientServices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceProvider method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        ServiceOrder servOrder = null;
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider(servOrder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class RatingServiceProviderController.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        int rating = 0;
        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceDescription method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServiceDescription() {
        System.out.println("getServiceDescription");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceRequestDescription expResult = null;
        ServiceRequestDescription result = instance.getServiceDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClient method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceRequest method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServiceRequest() {
        System.out.println("getServiceRequest");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServOrder method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServOrder() {
        System.out.println("getServOrder");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceOrder expResult = null;
        ServiceOrder result = instance.getServOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceCost method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServiceCost() {
        System.out.println("getServiceCost");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        double expResult = 0.0;
        double result = instance.getServiceCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTravelCost method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetTravelCost() {
        System.out.println("getTravelCost");
        RatingServiceProviderController instance = new RatingServiceProviderController();
        double expResult = 0.0;
        double result = instance.getTravelCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
