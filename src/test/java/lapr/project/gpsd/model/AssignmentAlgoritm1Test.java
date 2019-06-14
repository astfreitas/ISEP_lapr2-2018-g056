package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.util.converter.LocalDateStringConverter;
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
    @Disabled
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
    @Disabled
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
    @Disabled
    public void testFilterByCategory() {
        System.out.println("filterByCategory");
        Category cat1 = new Category("code1", "desc1");
        Category cat2 = new Category("code2", "desc2");
        ServiceProvider sp1 = new ServiceProvider("name1", "nif1", "email1", "abNAme1");
        sp1.addCategory(cat1);
        ServiceProvider sp2 = new ServiceProvider("name2", "nif2", "email2", "abName2");
        sp2.addCategory(cat2);
        List<ServiceProvider> spList = new ArrayList<>();
        spList.add(sp1);
        spList.add(sp2);
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = new ArrayList<>();
        expResult.add(sp1);
        List<ServiceProvider> result = instance.filterByCategory(spList, cat1);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAvailability method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testFilterByAvailability() {
        System.out.println("filterByAvailability");
        
        ServiceProvider sp1 = new ServiceProvider("name1", "nif1", "email1", "abName1");
        LocalDate date1 = LocalDate.of(2019,6,22);
        LocalTime time1 = LocalTime.of(9, 0);
        LocalTime time2 = LocalTime.of(18, 0);
        Availability aval1 = new Availability(date1, time1, time2);
        sp1.getSpAvailabilityList().addAvailability(aval1);
        
        ServiceProvider sp2 = new ServiceProvider("name2", "nif2", "email2", "abName2");
        LocalDate date2 = LocalDate.of(2019,6,23);
        LocalTime time3 = LocalTime.of(9, 0);
        LocalTime time4 = LocalTime.of(18, 0);
        Availability aval2 = new Availability(date2, time3, time4);
        sp2.getSpAvailabilityList().addAvailability(aval2);
        
        List<ServiceProvider> spList = new ArrayList<>();
        spList.add(sp1);
        spList.add(sp2);
        
        
        List<SchedulePreference> scheduleList = new ArrayList<>();
        SchedulePreference schedPref = new SchedulePreference(1, date1, time1);
        int duration = 60;
        
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        
        List<ServiceProvider> expResult = new ArrayList<>();
        expResult.add(sp1);
        List<ServiceProvider> result = instance.filterByAvailability(spList, scheduleList, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAddress method, of class AssignmentAlgoritm1.
     */
    @Disabled
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
    @Disabled
    public void testCreateAssignment() {
        System.out.println("createAssignment");
        ServiceRequestDescription service = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        ServiceAssignment expResult = null;
        ServiceAssignment result = instance.createAssignment(service);
        assertEquals(expResult, result);
    }

}
