package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import lapr.project.gpsd.utils.Constants;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceOrderRegistryTest {

    /**
     * Test of getPendingServiceOrdersByServiceProvider method, of class
     * ServiceOrderRegistry.
     */
    @Test
    public void testGetPendingServiceOrdersByServiceProvider() {
        System.out.println("getPendingServiceOrdersByServiceProvider");
        String status = Constants.PENDING_ORDER;

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);

        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ArrayList<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(instance.registerServiceOrder(sa));
        ArrayList<ServiceOrder> result = instance.getPendingServiceOrdersByServiceProvider(status, sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of concludeServiceOrder method, of class ServiceOrderRegistry.
     */
    @Test
    public void testConcludeServiceOrder() {
        System.out.println("concludeServiceOrder");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);

        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ServiceOrder servOrder = instance.registerServiceOrder(sa);
        instance.concludeServiceOrder(servOrder);
    }

    /**
     * Test of concludeServiceOrderWithIssue method, of class
     * ServiceOrderRegistry.
     */
    @Test
    public void testConcludeServiceOrderWithIssue() {
        System.out.println("concludeServiceOrderWithIssue");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);

        String issue = "issueTest";
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ServiceOrder servOrder = instance.registerServiceOrder(sa);
        instance.concludeServiceOrderWithIssue(servOrder, issue);
    }

    /**
     * Test of getCompletedServiceOrdersByClient method, of class
     * ServiceOrderRegistry.
     */
    @Test
    public void testGetCompletedServiceOrdersByClient() {
        System.out.println("getCompletedServiceOrdersByClient");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);

        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ServiceOrder so = instance.registerServiceOrder(sa);
        so.getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        ArrayList<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        ArrayList<ServiceOrder> result = instance.getCompletedServiceOrdersByClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrderByDateAndSP method, of class ServiceOrderRegistry.
     */
    @Test
    public void testGetServiceOrderByDateAndSP() {
        System.out.println("getServiceOrderByDateAndSP");
        LocalDate sDate = LocalDate.of(2019, 6, 22);
        LocalDate eDate = LocalDate.of(2019, 6, 23);
        
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ServiceOrder so = instance.registerServiceOrder(sa);
        ArrayList<ServiceOrder> expResult = new ArrayList<>();
        expResult.add(so);
        ArrayList<ServiceOrder> result = instance.getServiceOrderByDateAndSP(sDate, eDate, sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceOrders method, of class ServiceOrderRegistry.
     */
    @Test
    public void testRegisterServiceOrders() {
        System.out.println("registerServiceOrders");
        
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        
        List<ServiceAssignment> listServiceAssignments = new ArrayList<>();
        listServiceAssignments.add(sa);
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        List<Integer> expResult = new ArrayList<>();
        expResult.add(1);
        List<Integer> result = instance.registerServiceOrders(listServiceAssignments);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportData method, of class ServiceOrderRegistry.
     */
    @Test
    public void testExportData() {
        System.out.println("exportData");
        
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ServiceOrder so = instance.registerServiceOrder(sa);
        List<ServiceOrder> servOrdList = new ArrayList<>();
        servOrdList.add(so);
        String filename = "src/main/resources/testFiles/testSO.csv";
        FileType adapter = new AdapterCSV();
        instance.exportData(servOrdList, filename, adapter);
    }

}
