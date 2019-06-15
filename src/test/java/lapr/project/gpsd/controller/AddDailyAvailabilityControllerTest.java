package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import lapr.project.gpsd.utils.Constants;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AddDailyAvailabilityControllerTest {
    
    public AddDailyAvailabilityControllerTest() {
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("10001@companylda.com", "password");        
    }
    
    /**
     * Test of newAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testNewAvailability_3args() {
        System.out.println("newAvailability");
        LocalDate date = LocalDate.of(2020, 6, 5);
        LocalTime sTime = LocalTime.of(11, 0);
        LocalTime eTime = LocalTime.of(12, 0);
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        int expResult = 1;
        int result = instance.newAvailability(date, sTime, eTime).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of newAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testNewAvailability_5args() {
        System.out.println("newAvailability");
        LocalDate date = LocalDate.of(2020, 6, 5);
        LocalTime sTime = LocalTime.of(11, 0);
        LocalTime eTime = LocalTime.of(12, 0);
        LocalDate eDate = LocalDate.of(2020, 7, 5);
        String repPattern = Constants.REPETITION_PATTERN_DAILY;
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        int expResult = 1;
        int result = instance.newAvailability(date, sTime, eTime, eDate, repPattern).size();
        assertEquals(expResult, result);
    }

    /**
     * Test of clearAvalList method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testClearAvalList() {
        System.out.println("clearAvalList");
        LocalDate date = LocalDate.of(2020, 6, 5);
        LocalTime sTime = LocalTime.of(11, 0);
        LocalTime eTime = LocalTime.of(12, 0);
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        instance.newAvailability(date, sTime, eTime);
        instance.clearAvalList();
        int expResult = 0;
        int result = instance.getAvalList().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testRegisterAvailability() {
        System.out.println("registerAvailability");
        LocalDate date = LocalDate.of(2020, 6, 5);
        LocalTime sTime = LocalTime.of(11, 0);
        LocalTime eTime = LocalTime.of(12, 0);
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        instance.newAvailability(date, sTime, eTime);
        instance.registerAvailability();
        int expResult = 1;
        int result = instance.getAvalList().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvalList method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testGetAvalList() {
        System.out.println("testGetAvalList");
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        int expResult = 0;
        int result = instance.getAvalList().size();
        assertEquals(expResult, result);
    }
    
}
