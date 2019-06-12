/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.PostalCode;
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
public class GeographicAreaSpecControllerTest {
    
    public GeographicAreaSpecControllerTest() {
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
     * Test of newGeographicArea method, of class GeographicAreaSpecController.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "";
        double cost = 0.0;
        String strPC = "";
        double radius = 0.0;
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        boolean expResult = false;
        boolean result = instance.newGeographicArea(designation, cost, strPC, radius);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerGeographicArea method, of class GeographicAreaSpecController.
     */
    @Test
    public void testRegisterGeographicArea() {
        System.out.println("registerGeographicArea");
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        boolean expResult = false;
        boolean result = instance.registerGeographicArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMatchPostalCode method, of class GeographicAreaSpecController.
     */
    @Test
    public void testSearchMatchPostalCode() {
        System.out.println("searchMatchPostalCode");
        String strPC = "";
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        List<PostalCode> expResult = null;
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeoA method, of class GeographicAreaSpecController.
     */
    @Test
    public void testGetGeoA() {
        System.out.println("getGeoA");
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        GeographicArea expResult = null;
        GeographicArea result = instance.getGeoA();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
