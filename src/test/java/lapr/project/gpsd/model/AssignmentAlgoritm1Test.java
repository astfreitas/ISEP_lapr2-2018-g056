package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentAlgoritm1Test {
    
    /**
     * Test of assignServices method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testAssignServices() {
        System.out.println("assignServices");
        List<ServiceRequestDescription> services = null;
        ISortingBehavior sortingBehavior = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.assignServices(services, sortingBehavior);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuitableSPList method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testGetSuitableSPList() {
        System.out.println("getSuitableSPList");
        ServiceRequestDescription srd = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.getSuitableSPList(srd);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectMostSuitableSP method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testSelectMostSuitableSP() {
        System.out.println("selectMostSuitableSP");
        List<ServiceProvider> suitableSPs = null;
        ServiceRequestDescription srd = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.selectMostSuitableSP(suitableSPs, srd);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByCategory method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testFilterByCategory() {
        System.out.println("filterByCategory");
        List<ServiceProvider> spList = null;
        Category cat = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.filterByCategory(spList, cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAvailability method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testFilterByAvailability() {
        System.out.println("filterByAvailability");
        List<ServiceProvider> spList = null;
        List<SchedulePreference> scheduleList = null;
        int duration = 0;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.filterByAvailability(spList, scheduleList, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAddress method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testFilterByAddress() {
        System.out.println("filterByAddress");
        List<ServiceProvider> spList = null;
        Address address = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.filterByAddress(spList, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of createAssignment method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testCreateAssignment() {
        System.out.println("createAssignment");
        ServiceRequestDescription service = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        ServiceAssignment expResult = null;
        ServiceAssignment result = instance.createAssignment(service);
        assertEquals(expResult, result);
    }
    
}
