/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import lapr.project.gpsd.model.Availability;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaoferreira
 */
public class AddDailyAvailabilityControllerTest {
    
    public AddDailyAvailabilityControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testNewAvailability_3args() {
        System.out.println("newAvailability");
        LocalDate date = null;
        LocalTime sTime = null;
        LocalTime eTime = null;
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        ArrayList<Availability> expResult = null;
        ArrayList<Availability> result = instance.newAvailability(date, sTime, eTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testNewAvailability_5args() {
        System.out.println("newAvailability");
        LocalDate date = null;
        LocalTime sTime = null;
        LocalTime eTime = null;
        LocalDate eDate = null;
        String repPattern = "";
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        ArrayList<Availability> expResult = null;
        ArrayList<Availability> result = instance.newAvailability(date, sTime, eTime, eDate, repPattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerAvailability method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testRegisterAvailability() {
        System.out.println("registerAvailability");
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        boolean expResult = false;
        boolean result = instance.registerAvailability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvalList method, of class AddDailyAvailabilityController.
     */
    @Test
    public void testGetAvalList() {
        System.out.println("getAvalList");
        AddDailyAvailabilityController instance = new AddDailyAvailabilityController();
        ArrayList<Availability> expResult = null;
        ArrayList<Availability> result = instance.getAvalList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
