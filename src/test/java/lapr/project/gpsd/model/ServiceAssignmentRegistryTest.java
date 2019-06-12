package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceAssignmentRegistryTest {
 
    /**
     * Test of getServiceAssignments method, of class ServiceAssignmentRegistry.
     */
    @Disabled
    public void testGetServiceAssignments() {
        System.out.println("getServiceAssignments");
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.getServiceAssignments();
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceAssignment method, of class ServiceAssignmentRegistry.
     */
    @Test
    public void testAddServiceAssignment() {
        System.out.println("addServiceAssignment");
        ServiceAssignment sa = null;
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        boolean expResult = false;
        boolean result = instance.addServiceAssignment(sa);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceAssignmentListByServiceRequest method, of class ServiceAssignmentRegistry.
     */
    @Disabled
    public void testGetServiceAssignmentListByServiceRequest() {
        System.out.println("getServiceAssignmentListByServiceRequest");
        ServiceRequest serviceRequest = null;
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.getServiceAssignmentListByServiceRequest(serviceRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeServiceAssignment method, of class ServiceAssignmentRegistry.
     */
    @Test
    public void testRemoveServiceAssignment() {
        System.out.println("removeServiceAssignment");
        List<ServiceAssignment> listServiceAssignments = null;
        boolean setAssigned = false;
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        instance.removeServiceAssignment(listServiceAssignments, setAssigned);
    }
    
}
