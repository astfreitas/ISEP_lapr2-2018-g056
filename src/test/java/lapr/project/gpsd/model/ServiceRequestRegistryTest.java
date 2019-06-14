package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.utils.Constants;
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
        Client client = new Client("testName", "testNIF", "testTel", "testEmail");
        Address address = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        ServiceRequest expResult = new ServiceRequest(new Client("testName", "testNIF", "testTel", "testEmail"), new Address("testLocal", "4000-007", "testAddress"));
        ServiceRequest result = instance.newServiceRequest(client, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceRequest method, of class ServiceRequestRegistry.
     */
    @Test
    public void testRegisterServiceRequest() {
        System.out.println("registerServiceRequest");
        Client client = new Client("testName", "testNIF", "testTel", "testEmail");
        Address address = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest serviceRequest = new ServiceRequest(client, address);
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        int expResult = 1;
        int result = instance.registerServiceRequest(serviceRequest);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnassignedServices method, of class ServiceRequestRegistry.
     */
    @Disabled
    public void testGetUnassignedServices() {
        System.out.println("getUnassignedServices");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        instance.registerServiceRequest(sr);
        List<ServiceRequestDescription> expResult = new ArrayList<>();
        expResult.add(srd);
        
        List<ServiceRequestDescription> result = instance.getUnassignedServices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequestFromDescription method, of class ServiceRequestRegistry.
     */
    @Disabled
    public void testGetRequestFromDescription() {
        System.out.println("getRequestFromDescription");
        
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        instance.registerServiceRequest(sr);
        ServiceRequest expResult = new ServiceRequest(cli, add);
        expResult.addServiceRequestDescription(serv, "testDesc", 60);
        ServiceRequest result = instance.getRequestFromDescription(srd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestsFullyAssignedByClient method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetServiceRequestsFullyAssignedByClient() {
        System.out.println("getServiceRequestsFullyAssignedByClient");
        
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        sr.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        instance.registerServiceRequest(sr);
        List<ServiceRequest> expResult = new ArrayList<>();
        expResult.add(sr);
        List<ServiceRequest> result = instance.getServiceRequestsFullyAssignedByClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestByNumber method, of class ServiceRequestRegistry.
     */
    @Test
    public void testGetServiceRequestByNumber() {
        System.out.println("getServiceRequestByNumber");
        int number = 1;
        
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        
        ServiceRequestRegistry instance = new ServiceRequestRegistry();
        instance.registerServiceRequest(sr);
        ServiceRequest expResult = sr;
        ServiceRequest result = instance.getServiceRequestByNumber(number);
        assertEquals(expResult, result);
    }
}
