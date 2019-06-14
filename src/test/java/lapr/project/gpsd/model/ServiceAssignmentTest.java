/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /**
     * Test of isExpired method, of class ServiceAssignment.
     */
    @Test
    public void testIsExpired() {
        System.out.println("isExpired");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 1), LocalTime.of(12, 0),"");
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        boolean expResult = true;
        boolean result = sa.isExpired();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ServiceAssignment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 1), LocalTime.of(12, 0),"");
        ServiceAssignment instance = new ServiceAssignment(sp, srd, sr, schedPref);
        Object obj = new ServiceAssignment(sp, srd, sr, schedPref);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyCat method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetPropertyCat() {
        System.out.println("getPropertyCat");
        ServiceAssignment instance = null;
        String expResult = "";
        String result = instance.getPropertyCat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyService method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetPropertyService() {
        System.out.println("getPropertyService");
        ServiceAssignment instance = null;
        String expResult = "";
        String result = instance.getPropertyService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyServiceProviderName method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetPropertyServiceProviderName() {
        System.out.println("getPropertyServiceProviderName");
        ServiceAssignment instance = null;
        String expResult = "";
        String result = instance.getPropertyServiceProviderName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyMeanRating method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetPropertyMeanRating() {
        System.out.println("getPropertyMeanRating");
        ServiceAssignment instance = null;
        String expResult = "";
        String result = instance.getPropertyMeanRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyClassification method, of class ServiceAssignment.
     */
    @Disabled
    public void testGetPropertyClassification() {
        System.out.println("getPropertyClassification");
        ServiceAssignment instance = null;
        String expResult = "";
        String result = instance.getPropertyClassification();
        assertEquals(expResult, result);
    }  
}
