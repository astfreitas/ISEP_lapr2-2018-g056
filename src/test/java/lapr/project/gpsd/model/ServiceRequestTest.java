package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceRequestTest {
  
    /**
     * Test of setNumber method, of class ServiceRequest.
     */
    @Disabled
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        ServiceRequest instance = null;
        instance.setNumber(number);

    }

    /**
     * Test of addServiceRequestDescription method, of class ServiceRequest.
     */
    @Disabled
    public void testAddServiceRequestDescription() {
        System.out.println("addServiceRequestDescription");
        Service service = null;
        String desc = "";
        int dur = 0;
        ServiceRequest instance = null;
        boolean expResult = false;
        boolean result = instance.addServiceRequestDescription(service, desc, dur);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSchedulePreference method, of class ServiceRequest.
     */
    @Disabled
    public void testAddSchedulePreference() {
        System.out.println("addSchedulePreference");
        LocalDate date = null;
        LocalTime time = null;
        ServiceRequest instance = null;
        boolean expResult = false;
        boolean result = instance.addSchedulePreference(date, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class ServiceRequest.
     */
    @Disabled
    public void testGetClient() {
        System.out.println("getClient");
        ServiceRequest instance = null;
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherCost method, of class ServiceRequest.
     */
    @Disabled
    public void testGetOtherCost() {
        System.out.println("getOtherCost");
        ServiceRequest instance = null;
        double expResult = 0.0;
        double result = instance.getOtherCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateCost method, of class ServiceRequest.
     */
    @Disabled
    public void testCalculateCost() {
        System.out.println("calculateCost");
        ServiceRequest instance = null;
        double expResult = 0.0;
        double result = instance.calculateCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of validate method, of class ServiceRequest.
     */
    @Disabled
    public void testValidate() {
        System.out.println("validate");
        ServiceRequest instance = null;
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class ServiceRequest.
     */
    @Disabled
    public void testGetNumber() {
        System.out.println("getNumber");
        ServiceRequest instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class ServiceRequest.
     */
    @Disabled
    public void testGetDate() {
        System.out.println("getDate");
        ServiceRequest instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class ServiceRequest.
     */
    @Disabled
    public void testGetTotal() {
        System.out.println("getTotal");
        ServiceRequest instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAddress method, of class ServiceRequest.
     */
    @Disabled
    public void testGetAddress() {
        System.out.println("getAddress");
        ServiceRequest instance = null;
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestDescriptions method, of class ServiceRequest.
     */
    @Disabled
    public void testGetServiceRequestDescriptions() {
        System.out.println("getServiceRequestDescriptions");
        ServiceRequest instance = null;
        List<ServiceRequestDescription> expResult = null;
        List<ServiceRequestDescription> result = instance.getServiceRequestDescriptions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSchedulePreferences method, of class ServiceRequest.
     */
    @Disabled
    public void testGetSchedulePreferences() {
        System.out.println("getSchedulePreferences");
        ServiceRequest instance = null;
        ArrayList<SchedulePreference> expResult = null;
        ArrayList<SchedulePreference> result = instance.getSchedulePreferences();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherCosts method, of class ServiceRequest.
     */
    @Disabled
    public void testGetOtherCosts() {
        System.out.println("getOtherCosts");
        ServiceRequest instance = null;
        ArrayList<OtherCost> expResult = null;
        ArrayList<OtherCost> result = instance.getOtherCosts();
        assertEquals(expResult, result);
    }

    /**
     * Test of fullyAssigned method, of class ServiceRequest.
     */
    @Disabled
    public void testFullyAssigned() {
        System.out.println("fullyAssigned");
        ServiceRequest instance = null;
        boolean expResult = false;
        boolean result = instance.fullyAssigned();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTravelExpenses method, of class ServiceRequest.
     */
    @Disabled
    public void testGetTravelExpenses() {
        System.out.println("getTravelExpenses");
        ServiceRequest instance = null;
        double expResult = 0.0;
        double result = instance.getTravelExpenses();
        assertEquals(expResult, result, 0.0);
    }
    
}
