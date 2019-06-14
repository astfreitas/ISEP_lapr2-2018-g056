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
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author astfr
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
    @Disabled
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "";
        double cost = 25.0;
        String strPC = "4000-008";
        double radius = 2500;
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        System.out.println(ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190"));
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        boolean expResult = true;
        boolean result = instance.newGeographicArea(designation, cost, strPC, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerGeographicArea method, of class GeographicAreaSpecController.
     */
    @Disabled
    public void testRegisterGeographicArea() {
        System.out.println("registerGeographicArea");
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        boolean expResult = false;
        boolean result = instance.registerGeographicArea();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of searchMatchPostalCode method, of class GeographicAreaSpecController.
     */
    @Disabled
    public void testSearchMatchPostalCode() {
        System.out.println("searchMatchPostalCode");
        String strPC = "";
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        List<PostalCode> expResult = null;
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeoA method, of class GeographicAreaSpecController.
     */
    @Disabled
    public void testGetGeoA() {
        System.out.println("getGeoA");
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        GeographicArea expResult = null;
        GeographicArea result = instance.getGeoA();
        assertEquals(expResult, result);
    }
    
}
