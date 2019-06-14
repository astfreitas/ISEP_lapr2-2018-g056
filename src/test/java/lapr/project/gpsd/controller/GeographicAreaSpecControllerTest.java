/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.PostalCode;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author astfr
 */
public class GeographicAreaSpecControllerTest {
   
    /**
     * Test of newGeographicArea method, of class GeographicAreaSpecController.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "";
        double cost = 25.0;
        String strPC = "4000-008";
        double radius = 2500;
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        app.bootstrap();
        System.out.println(ApplicationGPSD.getInstance().doLogin("adm1@isep.ipp.pt", "123"));
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
