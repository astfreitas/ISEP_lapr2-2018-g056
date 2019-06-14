package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
        LocalDate date = LocalDate.of(2019,6,22);
        LocalTime bTime = LocalTime.of(12, 0);
        LocalTime eTime = LocalTime.of(19, 0);
        SPAvailabilityList instance = new SPAvailabilityList();
        Availability expResult = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(19, 0));
        Availability result = instance.newAvailability(date, bTime, eTime);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testAddAvailability_Availability() {
        System.out.println("addAvailability");
        Availability availability = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(19, 0));
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = true;
        boolean result = instance.addAvailability(availability);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testAddAvailability_ArrayList() {
        System.out.println("addAvailability");
        Availability aval1 = new Availability(LocalDate.of(2019,6,21), LocalTime.of(12, 0), LocalTime.of(19, 0));
        Availability aval2 = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(19, 0));
        ArrayList<Availability> availabilityList = new ArrayList<>();
        availabilityList.add(aval1);
        availabilityList.add(aval2);
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = true;
        boolean result = instance.addAvailability(availabilityList);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAvailabilityBySchedulePreference method, of class
     * SPAvailabilityList.
     */
    @Test
    public void testAddAvailabilityBySchedulePreference() {
        System.out.println("addAvailabilityBySchedulePreference");
        SchedulePreference schedulePreference = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.of(12, 0));
        int duration = 30;
        SPAvailabilityList instance = new SPAvailabilityList();
        boolean expResult = true;
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
        Availability aval1 = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(13, 0));
        Availability aval2 = new Availability(LocalDate.of(2019,6,22), LocalTime.of(13, 0), LocalTime.of(14, 0));
        Availability expResult = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(14, 0));
        SPAvailabilityList instance = new SPAvailabilityList();
        instance.addAvailability(aval1);
        instance.addAvailability(aval2);
        instance.mergeAvailabilities();
        Availability result = instance.getAvailabilityList().get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testHasAvailability() {
        System.out.println("hasAvailability");
        SchedulePreference schedule = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        int duration = 30;
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
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        List<SchedulePreference> scheduleList = new ArrayList<>();
        scheduleList.add(schedPref);
        int duration = 30;
        SPAvailabilityList instance = new SPAvailabilityList();
        Availability aval = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(13, 0));
        instance.addAvailability(aval);
        SchedulePreference expResult = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        SchedulePreference result = instance.matchSchedule(scheduleList, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of splitAvailability method, of class SPAvailabilityList.
     */
    @Test
    public void testSplitAvailability() {
        System.out.println("splitAvailability");
        SchedulePreference schedule = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        int duration = 60;
        SPAvailabilityList instance = new SPAvailabilityList();
        Availability aval = new Availability(LocalDate.of(2019,6,22), LocalTime.of(12, 0), LocalTime.of(14, 0));
        instance.addAvailability(aval);
        boolean expResult = true;
        boolean result = instance.splitAvailability(schedule, duration);
        assertEquals(expResult, result);
    }
}
