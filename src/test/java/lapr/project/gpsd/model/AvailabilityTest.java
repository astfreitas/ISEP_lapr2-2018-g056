package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AvailabilityTest {

    /**
     * Test of Availability Constructor, of class Availability.
     */
    @Test
    public void testConstructor_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Availability aval = new Availability(LocalDate.of(2019, 12, 5), LocalTime.of(5, 0), LocalTime.of(10, 0));
        });
    }
    
    /**
     * Test of Availability Constructor, of class Availability.
     */
    @Test
    public void testConstructorStr_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Availability aval = new Availability(LocalDate.of(2019, 12, 5), LocalTime.of(5, 0), LocalTime.of(10, 0),"");
        });
    }

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
        LocalDate date1 = LocalDate.of(2019, 6, 22);
        LocalTime time1 = LocalTime.of(10, 0);
        LocalTime time2 = LocalTime.of(13, 0);
        Object otherObject = new Availability(date1, time1, time2);
        LocalDate date2 = LocalDate.of(2019, 6, 22);
        LocalTime time3 = LocalTime.of(10, 0);
        LocalTime time4 = LocalTime.of(13, 0);
        Availability instance = new Availability(date2, time3, time4);
        boolean expResult = true;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Availability.
     */
    @Test
    public void testEquals_False() {
        System.out.println("equals");
        LocalDate date1 = LocalDate.of(2019, 8, 23);
        LocalTime time1 = LocalTime.of(10, 0);
        LocalTime time2 = LocalTime.of(13, 0);
        Object otherObject = new Availability(date1, time1, time2);
        LocalDate date2 = LocalDate.of(2019, 6, 22);
        LocalTime time3 = LocalTime.of(10, 0);
        LocalTime time4 = LocalTime.of(13, 0);
        Availability instance = new Availability(date2, time3, time4);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of contaisSchedulePref method, of class Availability.
     */
    @Test
    public void testContainsSchedulePref_True() {
        System.out.println("contaisSchedulePref");
        LocalDate date1 = LocalDate.of(2019, 6, 29);
        LocalTime time1 = LocalTime.of(12, 0);
        SchedulePreference schedulePref = new SchedulePreference(0, date1, time1);
        int duration = 30;
        LocalDate date2 = LocalDate.of(2019, 6, 29);
        LocalTime time3 = LocalTime.of(10, 0);
        LocalTime time4 = LocalTime.of(13, 0);
        Availability instance = new Availability(date2, time3, time4);
        boolean expResult = true;
        boolean result = instance.containsSchedulePref(schedulePref, duration);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of contaisSchedulePref method, of class Availability.
     */
    @Test
    public void testContainsSchedulePref_False() {
        System.out.println("contaisSchedulePref");
        LocalDate date1 = LocalDate.of(2019, 6, 29);
        LocalTime time1 = LocalTime.of(12, 0);
        SchedulePreference schedulePref = new SchedulePreference(0, date1, time1);
        int duration = 30;
        LocalDate date2 = LocalDate.of(2019, 6, 28);
        LocalTime time3 = LocalTime.of(10, 0);
        LocalTime time4 = LocalTime.of(13, 0);
        Availability instance = new Availability(date2, time3, time4);
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
