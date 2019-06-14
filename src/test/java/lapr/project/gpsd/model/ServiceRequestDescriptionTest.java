package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceRequestDescriptionTest {
    
    /**
     * Test of getCost method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetCost() {
        System.out.println("getCost");
        ServiceRequestDescription instance = null;
        double expResult = 0.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAssigned method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testSetAssigned() {
        System.out.println("setAssigned");
        String assigned = "";
        ServiceRequestDescription instance = null;
        instance.setAssigned(assigned);
    }

    /**
     * Test of isAssigned method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testIsAssigned() {
        System.out.println("isAssigned");
        ServiceRequestDescription instance = null;
        boolean expResult = false;
        boolean result = instance.isAssigned();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAccepted method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testIsAccepted() {
        System.out.println("isAccepted");
        ServiceRequestDescription instance = null;
        boolean expResult = false;
        boolean result = instance.isAccepted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getService method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetService() {
        System.out.println("getService");
        ServiceRequestDescription instance = null;
        Service expResult = null;
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetDescription() {
        System.out.println("getDescription");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDuration method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetDuration() {
        System.out.println("getDuration");
        ServiceRequestDescription instance = null;
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyCategory method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetPropertyCategory() {
        System.out.println("getPropertyCategory");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.getPropertyCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyService method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetPropertyService() {
        System.out.println("getPropertyService");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.getPropertyService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyDuration method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetPropertyDuration() {
        System.out.println("getPropertyDuration");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.getPropertyDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPropertyCost method, of class ServiceRequestDescription.
     */
    @Disabled
    public void testGetPropertyCost() {
        System.out.println("getPropertyCost");
        ServiceRequestDescription instance = null;
        String expResult = "";
        String result = instance.getPropertyCost();
        assertEquals(expResult, result);
    }
    
}
