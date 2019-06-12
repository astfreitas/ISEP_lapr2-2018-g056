package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceRequestRegistryTest {
 
    /**
     * Test of getServiceRequests method, of class ServiceRequestRegistry.
     */
    @Disabled
    public void testGetServiceRequests() {
        System.out.println("getServiceRequests");
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        List<ServiceRequest> expResult = null;
        List<ServiceRequest> result = instance.getServiceRequests();
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceRequest method, of class ServiceRequestRegistry.
     */
    @Test
    public void testNewServiceRequest() {
        System.out.println("newServiceRequest");
        Client client = null;
        Address address = null;
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.newServiceRequest(client, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceRequest method, of class ServiceRequestRegistry.
     */
    @Test
    public void testRegisterServiceRequest() {
        System.out.println("registerServiceRequest");
        ServiceRequest serviceRequest = null;
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        int expResult = 0;
        int result = instance.registerServiceRequest(serviceRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnassignedServices method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetUnassignedServices() {
        System.out.println("getUnassignedServices");
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        List<ServiceRequestDescription> expResult = null;
        List<ServiceRequestDescription> result = instance.getUnassignedServices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestFromDescription method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetRequestFromDescription() {
        System.out.println("getRequestFromDescription");
        ServiceRequestDescription srd = null;
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getRequestFromDescription(srd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestsFullyAssignedByClient method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetServiceRequestsFullyAssignedByClient() {
        System.out.println("getServiceRequestsFullyAssignedByClient");
        Client client = null;
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        List<ServiceRequest> expResult = null;
        List<ServiceRequest> result = instance.getServiceRequestsFullyAssignedByClient(client);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestByNumber method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetServiceRequestByNumber() {
        System.out.println("getServiceRequestByNumber");
        int number = 0;
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        ServiceRequest expResult = null;
        ServiceRequest result = instance.getServiceRequestByNumber(number);
        assertEquals(expResult, result);
    }
}
