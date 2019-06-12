/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.ArrayList;
import lapr.project.gpsd.model.ServiceOrder;
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
public class CompleteServiceControllerTest {
    
    public CompleteServiceControllerTest() {
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
     * Test of getPendingServiceOrders method, of class CompleteServiceController.
     */
    @Test
    public void testGetPendingServiceOrders() {
        System.out.println("getPendingServiceOrders");
        CompleteServiceController instance = new CompleteServiceController();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getPendingServiceOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceDescriptionByOrderId method, of class CompleteServiceController.
     */
    @Test
    public void testGetServiceDescriptionByOrderId() {
        System.out.println("getServiceDescriptionByOrderId");
        String orderId = "";
        CompleteServiceController instance = new CompleteServiceController();
        ServiceRequestDescription expResult = null;
        ServiceRequestDescription result = instance.getServiceDescriptionByOrderId(orderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concludeServiceOrder method, of class CompleteServiceController.
     */
    @Test
    public void testConcludeServiceOrder() {
        System.out.println("concludeServiceOrder");
        CompleteServiceController instance = new CompleteServiceController();
        instance.concludeServiceOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServOrder method, of class CompleteServiceController.
     */
    @Test
    public void testSetServOrder() {
        System.out.println("setServOrder");
        ServiceOrder servOrder = null;
        CompleteServiceController instance = new CompleteServiceController();
        instance.setServOrder(servOrder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServOrder method, of class CompleteServiceController.
     */
    @Test
    public void testGetServOrder() {
        System.out.println("getServOrder");
        CompleteServiceController instance = new CompleteServiceController();
        ServiceOrder expResult = null;
        ServiceOrder result = instance.getServOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concludeServiceOrderWithIssue method, of class CompleteServiceController.
     */
    @Test
    public void testConcludeServiceOrderWithIssue() {
        System.out.println("concludeServiceOrderWithIssue");
        String issue = "";
        CompleteServiceController instance = new CompleteServiceController();
        instance.concludeServiceOrderWithIssue(issue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
