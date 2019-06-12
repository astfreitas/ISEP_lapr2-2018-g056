/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class GeographicAreaRegistryTest {
    
    /**
     * Test of getNearestGeographicArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testGetNearestGeographicArea() {
        System.out.println("getNearestGeographicArea");
        PostalCode postalCode = null;
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        GeographicArea expResult = null;
        GeographicArea result = instance.getNearestGeographicArea(postalCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newGeographicArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "";
        double cost = 0.0;
        String strPC = "";
        double radius = 0.0;
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        GeographicArea expResult = null;
        GeographicArea result = instance.newGeographicArea(designation, cost, strPC, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerGeographicArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testRegisterGeographicArea() {
        System.out.println("registerGeographicArea");
        GeographicArea geoA = null;
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        boolean expResult = false;
        boolean result = instance.registerGeographicArea(geoA);
        assertEquals(expResult, result);
    }

    /**
     * Test of validationGeoArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testValidationGeoArea() {
        System.out.println("validationGeoArea");
        GeographicArea geoA = null;
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        boolean expResult = false;
        boolean result = instance.validationGeoArea(geoA);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicAreas method, of class GeographicAreaRegistry.
     */
    @Disabled
    public void testGetGeographicAreas() {
        System.out.println("getGeographicAreas");
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        List<GeographicArea> expResult = null;
        List<GeographicArea> result = instance.getGeographicAreas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeoAreaById method, of class GeographicAreaRegistry.
     */
    @Test
    public void testGetGeoAreaById() {
        System.out.println("getGeoAreaById");
        String geoId = "";
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        GeographicArea expResult = null;
        GeographicArea result = instance.getGeoAreaById(geoId);
        assertEquals(expResult, result);
    }
    
}
