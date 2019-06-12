/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class ServiceOrderTest {
 
    /**
     * Test of setOrderNumber method, of class ServiceOrder.
     */
    @Disabled
    public void testSetOrderNumber() {
        System.out.println("setOrderNumber");
        int orderNumber = 0;
        ServiceOrder instance = null;
        instance.setOrderNumber(orderNumber);
    }

    /**
     * Test of getServiceProvider method, of class ServiceOrder.
     */
    @Disabled
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        ServiceOrder instance = null;
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequest method, of class ServiceOrder.
     */
    @Disabled
    public void testGetServiceRequest() {
        System.out.println("getServiceRequest");
        ServiceOrder instance = null;
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestDescription method, of class ServiceOrder.
     */
    @Disabled
    public void testGetServiceRequestDescription() {
        System.out.println("getServiceRequestDescription");
        ServiceOrder instance = null;
        ServiceRequestDescription expResult = null;
        ServiceRequestDescription result = instance.getServiceRequestDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSchePref method, of class ServiceOrder.
     */
    @Disabled
    public void testGetSchePref() {
        System.out.println("getSchePref");
        ServiceOrder instance = null;
        SchedulePreference expResult = null;
        SchedulePreference result = instance.getSchePref();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class ServiceOrder.
     */
    @Disabled
    public void testGetStatus() {
        System.out.println("getStatus");
        ServiceOrder instance = null;
        ServiceOrderStatus expResult = null;
        ServiceOrderStatus result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPending method, of class ServiceOrder.
     */
    @Test
    public void testIsPending() {
        System.out.println("isPending");
        String status = "";
        ServiceOrder instance = null;
        boolean expResult = false;
        boolean result = instance.isPending(status);
        assertEquals(expResult, result);
    }    
}
