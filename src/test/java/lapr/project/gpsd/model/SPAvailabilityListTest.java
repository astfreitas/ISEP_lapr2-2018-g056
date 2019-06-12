package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPAvailabilityListTest {
   
    /**
     * Test of newAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testNewAvailability() {
        System.out.println("newAvailability");
        LocalDate date = null;
        LocalTime bTime = null;
        LocalTime eTime = null;
        SPAvailabilityList instance = new SPAvailabilityList();
        Availability expResult = null;
        Availability result = instance.newAvailability(date, bTime, eTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testAddAvailability_Availability() {
        System.out.println("addAvailability");
        Availability availability = null;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = false;
        boolean result = instance.addAvailability(availability);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testAddAvailability_ArrayList() {
        System.out.println("addAvailability");
        ArrayList<Availability> availabilityList = null;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = false;
        boolean result = instance.addAvailability(availabilityList);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailabilityBySchedulePreference method, of class SPAvailabilityList.
     */
    @Test
    public void testAddAvailabilityBySchedulePreference() {
        System.out.println("addAvailabilityBySchedulePreference");
        SchedulePreference schedulePreference = null;
        int duration = 0;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = false;
        boolean result = instance.addAvailabilityBySchedulePreference(schedulePreference, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailabilityList method, of class SPAvailabilityList.
     */
    @Disabled
    public void testGetAvailabilityList() {
        System.out.println("getAvailabilityList");
        SPAvailabilityList instance = new SPAvailabilityList();
        List<Availability> expResult = null;
        List<Availability> result = instance.getAvailabilityList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mergeAvailabilities method, of class SPAvailabilityList.
     */
    @Test
    public void testMergeAvailabilities() {
        System.out.println("mergeAvailabilities");
        SPAvailabilityList instance = new SPAvailabilityList();
        instance.mergeAvailabilities();
    }

    /**
     * Test of hasAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testHasAvailability() {
        System.out.println("hasAvailability");
        SchedulePreference schedule = null;
        int duration = 0;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = false;
        boolean result = instance.hasAvailability(schedule, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of matchSchedule method, of class SPAvailabilityList.
     */
    @Test
    public void testMatchSchedule() {
        System.out.println("matchSchedule");
        List<SchedulePreference> scheduleList = null;
        int duration = 0;
        SPAvailabilityList instance = new SPAvailabilityList();
        SchedulePreference expResult = null;
        SchedulePreference result = instance.matchSchedule(scheduleList, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of splitAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testSplitAvailability() {
        System.out.println("splitAvailability");
        SchedulePreference schedule = null;
        int duration = 0;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = false;
        boolean result = instance.splitAvailability(schedule, duration);
        assertEquals(expResult, result);
    }
    
}
