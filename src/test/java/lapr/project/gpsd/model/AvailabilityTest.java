package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvailabilityTest {
 
    /**
     * Test of getDate method, of class Availability.
     */
    @Disabled
    public void testGetDate() {
        System.out.println("getDate");
        Availability instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Availability.
     */
    @Disabled
    public void testSetDate() {
        System.out.println("setDate");
        LocalDate date = null;
        Availability instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSTime method, of class Availability.
     */
    @Disabled
    public void testGetSTime() {
        System.out.println("getSTime");
        Availability instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getSTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSTime method, of class Availability.
     */
    @Disabled
    public void testSetSTime() {
        System.out.println("setSTime");
        LocalTime bTime = null;
        Availability instance = null;
        instance.setSTime(bTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getETime method, of class Availability.
     */
    @Disabled
    public void testGetETime() {
        System.out.println("getETime");
        Availability instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getETime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setETime method, of class Availability.
     */
    @Disabled
    public void testSetETime() {
        System.out.println("setETime");
        LocalTime eTime = null;
        Availability instance = null;
        instance.setETime(eTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        Availability instance = null;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of contaisSchedulePref method, of class Availability.
     */
    @Test
    public void testContainsSchedulePref() {
        System.out.println("contaisSchedulePref");
        SchedulePreference schedulePref = null;
        int duration = 0;
        Availability instance = null;
        boolean expResult = false;
        boolean result = instance.containsSchedulePref(schedulePref, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Availability.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        Availability instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
