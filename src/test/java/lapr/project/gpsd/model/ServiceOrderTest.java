package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import lapr.project.gpsd.utils.Constants;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    public void testGetServiceRequestDescription() {
        System.out.println("getServiceRequestDescription");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceOrder instance = new ServiceOrder(sa);
        ServiceRequestDescription expResult = new ServiceRequestDescription(serv, "testDesc", 60);;
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
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceOrder instance = new ServiceOrder(sa);
        ServiceOrderStatus expResult = new ServiceOrderStatus(Constants.PENDING_ORDER);
        ServiceOrderStatus result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPending method, of class ServiceOrder.
     */
    @Test
    public void testIsPending() {
        System.out.println("isPending");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceOrder instance = new ServiceOrder(sa);
        boolean expResult = true;
        boolean result = instance.isPending(instance.getStatus().getServOrderStatus());
        assertEquals(expResult, result);
    }
}
