/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.PostalCode;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author astfr
 */
public class GeographicAreaSpecControllerTest {

    private ApplicationGPSD app;

    public GeographicAreaSpecControllerTest() {
        this.app = ApplicationGPSD.getInstance();
        app.bootstrap();
        System.out.println("Login state: " + ApplicationGPSD.getInstance().doLogin("adm1@isep.ipp.pt", "123"));
    }

    /**
     * Test of newGeographicArea method, of class GeographicAreaSpecController.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "TestGeoArea";
        double cost = 25.0;
        String strPC = "4000-008";
        double radius = 2500;
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        boolean expResult = true;
        boolean result = instance.newGeographicArea(designation, cost, strPC, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerGeographicArea method, of class
     * GeographicAreaSpecController.
     */
    @Test
    public void testRegisterGeographicArea() {
        System.out.println("registerGeographicArea");
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        String designation = "TestGeoArea";
        double cost = 25.0;
        String strPC = "4000-008";
        double radius = 2500;
        instance.newGeographicArea(designation, cost, strPC, radius);
        boolean expResult = true;
        boolean result = instance.registerGeographicArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of searchMatchPostalCode method, of class
     * GeographicAreaSpecController.
     */
    @Test
    public void testSearchMatchPostalCode() {
        System.out.println("searchMatchPostalCode");
        String strPC = "4000-015";
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        String expResult = "4000-015";
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        assertEquals(expResult, result.get(0).getPostalCode());
    }
    
    /**
     * Test of searchMatchPostalCode method, of class
     * GeographicAreaSpecController.
     */
    @Test
    public void testSearchMatchPostalCode2() {
        System.out.println("searchMatchPostalCode 2 ");
        String strPC = "4000-00";
        GeographicAreaSpecController instance = new GeographicAreaSpecController();
        List<PostalCode> result = instance.searchMatchPostalCode(strPC);
        boolean resultB = false;
        for (PostalCode postalCode : result) {
            if (postalCode.getPostalCode().contains(strPC)) resultB = true;
            break;
        }
        assertTrue(resultB);
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
