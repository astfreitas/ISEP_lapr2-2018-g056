package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchedulePreferenceTest {
 
    /**
     * Test of getOrder method, of class SchedulePreference.
     */
    @Disabled
    public void testGetOrder() {
        System.out.println("getOrder");
        SchedulePreference instance = null;
        int expResult = 0;
        int result = instance.getOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDate method, of class SchedulePreference.
     */
    @Disabled
    public void testGetDate() {
        System.out.println("getDate");
        SchedulePreference instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTime method, of class SchedulePreference.
     */
    @Disabled
    public void testGetTime() {
        System.out.println("getTime");
        SchedulePreference instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class SchedulePreference.
     */
    @Disabled
    public void testSetOrder() {
        System.out.println("setOrder");
        int order = 0;
        SchedulePreference instance = null;
        instance.setOrder(order);
    }

    /**
     * Test of equals method, of class SchedulePreference.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        SchedulePreference instance = new SchedulePreference(0, LocalDate.of(2019,6,22), LocalTime.NOON);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SchedulePreference.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        SchedulePreference instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
