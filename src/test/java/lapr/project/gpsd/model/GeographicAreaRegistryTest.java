/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
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
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea geoArea = new GeographicArea("150", "GeoArea1", 150, 2500, "4000-007", exService, pcReg);
        GeographicArea geoArea2 = new GeographicArea("165", "GeoArea2", 350, 3000, "4000-015", exService, pcReg);
        PostalCode postalCode = new PostalCode("4000-007", 41.1469459, -8.6064074);;
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        instance.getGeographicAreas().add(geoArea);
        GeographicArea expResult = geoArea;
        GeographicArea result = instance.getNearestGeographicArea(postalCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of newGeographicArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testNewGeographicArea() {
        System.out.println("newGeographicArea");
        String designation = "GeoAreaTest";
        double cost = 150;
        String strPC = "4000-007";
        double radius = 2500;
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea geoArea = new GeographicArea("150", "GeoAreaTest", 150, 2500, "4000-007", exService, pcReg);
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        GeographicArea expResult = geoArea;
        GeographicArea result = instance.newGeographicArea(designation, cost, strPC, radius);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerGeographicArea method, of class GeographicAreaRegistry.
     */
    @Test
    public void testRegisterGeographicArea() {
        System.out.println("registerGeographicArea");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        }        
        GeographicArea geoArea1 = new GeographicArea("150", "GeoAreaTest", 150, 2500, "4000-007", exService, pcReg);
        GeographicArea geoArea2 = new GeographicArea("250", "GeoAreaTest2", 150, 2500, "4000-015", exService, pcReg);
        GeographicArea geoA = new GeographicArea("250", "GeoAreaTest2", 150, 2500, "4000-015", exService, pcReg);
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        instance.getGeographicAreas().add(geoArea1);
        instance.getGeographicAreas().add(geoArea2);
        instance.getGeographicAreas().add(geoA);
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
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        } 
        GeographicArea geoA = new GeographicArea("150", "GeoAreaTest", 150, 2500, "4000-007", exService, pcReg);
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        boolean expResult = true;
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
    
    /**
     * Test of getGeoAreaById method, of class GeographicAreaRegistry.
     */
    @Test
    public void testGetGeoAreaById2() {
        System.out.println("getGeoAreaById-2");
        ExternalService1 exService = new ExternalService1("src/main/resources/testFiles/codigos_postaisTest.csv");
        PostalCodeRegistry pcReg = new PostalCodeRegistry();
        try {
            ArrayList<PostalCode> listPC = exService.loadPostalCodeList();
            pcReg.setPostalCodeList(listPC);
        } catch (Exception e) {
            System.out.println("Failed to Load Postal Code List");
        } 
        GeographicArea geoA = new GeographicArea("150", "GeoAreaTest", 150, 2500, "4000-007", exService, pcReg);
        GeographicArea geoA2 = new GeographicArea("15", "GeoAreaTest", 250, 5000, "4000-015", exService, pcReg);
        
        String geoId = "150";
        GeographicAreaRegistry instance = new GeographicAreaRegistry();
        instance.getGeographicAreas().add(geoA);
        instance.getGeographicAreas().add(geoA2);
        GeographicArea expResult = geoA;
        GeographicArea result = instance.getGeoAreaById(geoId);
        assertEquals(expResult, result);
    }
    
}
