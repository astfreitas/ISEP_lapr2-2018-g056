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
public class ServiceAssignmentTest {

    /**
     * Test of getServiceProvider method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        ServiceAssignment instance = null;
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceRequestDescription method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetServiceRequestDescription() {
        System.out.println("getServiceRequestDescription");
        ServiceAssignment instance = null;
        ServiceRequestDescription expResult = null;
        ServiceRequestDescription result = instance.getServiceRequestDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceRequest method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetServiceRequest() {
        System.out.println("getServiceRequest");
        ServiceAssignment instance = null;
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchedulePreference method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetSchedulePreference() {
        System.out.println("getSchedulePreference");
        ServiceAssignment instance = null;
        SchedulePreference expResult = null;
        SchedulePreference result = instance.getSchedulePreference();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
