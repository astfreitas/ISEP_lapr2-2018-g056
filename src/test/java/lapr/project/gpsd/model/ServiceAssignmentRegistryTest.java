package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        boolean expResult = true;
        boolean result = instance.addServiceAssignment(sa);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceAssignmentListByServiceRequest method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testGetServiceAssignmentListByServiceRequest_ServiceRequest() {
        System.out.println("getServiceAssignmentListByServiceRequest");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addSchedulePreference(LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        instance.addServiceAssignment(sa);
        List<ServiceAssignment> expResult = new ArrayList<>();
        expResult.add(sa);
        List<ServiceAssignment> result = instance.getServiceAssignmentListByServiceRequest(sr);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeServiceAssignment method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testRemoveServiceAssignment() {
        System.out.println("removeServiceAssignment");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addSchedulePreference(LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        List<ServiceAssignment> listServiceAssignments = new ArrayList<>();
        listServiceAssignments.add(sa);
        boolean setAssigned = true;
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        instance.addServiceAssignment(sa);
        instance.removeServiceAssignment(listServiceAssignments, setAssigned);
    }

    /**
     * Test of getServiceAssignmentListByServiceRequest method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testGetServiceAssignmentListByServiceRequest_ServiceRequest_List() {
        System.out.println("getServiceAssignmentListByServiceRequest");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest serviceRequest = new ServiceRequest(cli, add);
        serviceRequest.addSchedulePreference(LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        serviceRequest.addServiceRequestDescription(serv, "testDesc", 60);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, serviceRequest, schedPref);

        List<ServiceAssignment> clientServiceAssignments = new ArrayList<>();
        clientServiceAssignments.add(sa);
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        List<ServiceAssignment> expResult = new ArrayList<>();
        expResult.add(sa);
        List<ServiceAssignment> result = instance.getServiceAssignmentListByServiceRequest(serviceRequest, clientServiceAssignments);
        assertEquals(expResult, result);
    }

    /**
     * Test of serviceRequestHasExpiredAssignment method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testServiceRequestHasExpiredAssignment() {
        System.out.println("serviceRequestHasExpiredAssignment");
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addSchedulePreference(LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        boolean expResult = false;
        boolean result = instance.serviceRequestHasExpiredAssignment(sr);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceAssignmentsByCli method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testGetServiceAssignmentsByCli() {
        System.out.println("getServiceAssignmentsByCli");
        
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest serviceRequest = new ServiceRequest(cli, add);
        serviceRequest.addSchedulePreference(LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        serviceRequest.addServiceRequestDescription(serv, "testDesc", 60);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, serviceRequest, schedPref);
        
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        instance.addServiceAssignment(sa);
        List<ServiceAssignment> expResult = new ArrayList<>();
        expResult.add(sa);
        List<ServiceAssignment> result = instance.getServiceAssignmentsByCli(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeExpiredAssignments method, of class
     * ServiceAssignmentRegistry.
     */
    @Test
    public void testRemoveExpiredAssignments() {
        System.out.println("removeExpiredAssignments");
        ServiceAssignmentRegistry instance = new ServiceAssignmentRegistry();
        instance.removeExpiredAssignments();
    }
}
