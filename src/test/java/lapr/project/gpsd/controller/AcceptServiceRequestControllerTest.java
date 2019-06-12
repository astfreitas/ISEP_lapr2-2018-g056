package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.ServiceAssignment;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptServiceRequestControllerTest {
    
    public AcceptServiceRequestControllerTest() {
    }
    
    /**
     * Test of checkAssignedServiceRequests method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckAssignedServiceRequests() {
        System.out.println("checkAssignedServiceRequests");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        List<Integer> expResult = null;
        List<Integer> result = instance.checkAssignedServiceRequests();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkServiceAssignments method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckServiceAssignments() {
        System.out.println("checkServiceAssignments");
        int serviceNumber = 0;
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.checkServiceAssignments(serviceNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rejectServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Test
    public void testRejectServiceAssignment() {
        System.out.println("rejectServiceAssignment");
        List<ServiceAssignment> listServiceAssignments = null;
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        instance.rejectServiceAssignment(listServiceAssignments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Test
    public void testAcceptServiceAssignment() {
        System.out.println("acceptServiceAssignment");
        List<ServiceAssignment> listServiceAssignments = null;
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        List<Integer> expResult = null;
        List<Integer> result = instance.acceptServiceAssignment(listServiceAssignments);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
