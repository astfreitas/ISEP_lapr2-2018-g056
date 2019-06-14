package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceOrderRegistryTest {
   
    /**
     * Test of getPendingServiceOrdersByServiceProvider method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testGetPendingServiceOrdersByServiceProvider() {
        System.out.println("getPendingServiceOrdersByServiceProvider");
        String status = "";
        ServiceProvider sp = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getPendingServiceOrdersByServiceProvider(status, sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of concludeServiceOrder method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testConcludeServiceOrder() {
        System.out.println("concludeServiceOrder");
        ServiceOrder servOrder = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        instance.concludeServiceOrder(servOrder);
    }

    /**
     * Test of concludeServiceOrderWithIssue method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testConcludeServiceOrderWithIssue() {
        System.out.println("concludeServiceOrderWithIssue");
        ServiceOrder servOrder = null;
        String issue = "";
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        instance.concludeServiceOrderWithIssue(servOrder, issue);
    }

    /**
     * Test of getCompletedServiceOrdersByClient method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testGetCompletedServiceOrdersByClient() {
        System.out.println("getCompletedServiceOrdersByClient");
        Client cli = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getCompletedServiceOrdersByClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrderByDateAndSP method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testGetServiceOrderByDateAndSP() {
        System.out.println("getServiceOrderByDateAndSP");
        LocalDate sDate = null;
        LocalDate eDate = null;
        ServiceProvider sp = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getServiceOrderByDateAndSP(sDate, eDate, sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceOrders method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testRegisterServiceOrders() {
        System.out.println("registerServiceOrders");
        List<ServiceAssignment> listServiceAssignments = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        List<Integer> expResult = null;
        List<Integer> result = instance.registerServiceOrders(listServiceAssignments);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportData method, of class ServiceOrderRegistry.
     */
    @Disabled
    public void testExportData() {
        System.out.println("exportData");
        List<ServiceOrder> servOrdList = null;
        String filename = "";
        FileType adapter = null;
        ServiceOrderRegistry instance = new ServiceOrderRegistry();
        instance.exportData(servOrdList, filename, adapter);
    }
    
}
