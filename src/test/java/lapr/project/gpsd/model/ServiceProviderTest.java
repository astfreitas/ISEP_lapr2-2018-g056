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
public class ServiceProviderTest {
    
    /**
     * Test of getNumber method, of class ServiceProvider.
     */
    @Disabled
    public void testGetNumber() {
        System.out.println("getNumber");
        ServiceProvider instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class ServiceProvider.
     */
    @Disabled
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        ServiceProvider instance = null;
        instance.setNumber(number);
    }

    /**
     * Test of getNif method, of class ServiceProvider.
     */
    @Disabled
    public void testGetNif() {
        System.out.println("getNif");
        ServiceProvider instance = null;
        String expResult = "";
        String result = instance.getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ServiceProvider.
     */
    @Disabled
    public void testGetName() {
        System.out.println("getName");
        ServiceProvider instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class ServiceProvider.
     */
    @Disabled
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        ServiceProvider instance = null;
        instance.setName(name);
    }

    /**
     * Test of getAbbrevName method, of class ServiceProvider.
     */
    @Disabled
    public void testGetAbbrevName() {
        System.out.println("getAbbrevName");
        ServiceProvider instance = null;
        String expResult = "";
        String result = instance.getAbbrevName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAbbrevName method, of class ServiceProvider.
     */
    @Disabled
    public void testSetAbbrevName() {
        System.out.println("setAbbrevName");
        String abbrevName = "";
        ServiceProvider instance = null;
        instance.setAbbrevName(abbrevName);
    }

    /**
     * Test of getEmail method, of class ServiceProvider.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        ServiceProvider instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class ServiceProvider.
     */
    @Disabled
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        ServiceProvider instance = null;
        instance.setEmail(email);
    }

    /**
     * Test of getSpAddress method, of class ServiceProvider.
     */
    @Disabled
    public void testGetSpAddress() {
        System.out.println("getSpAddress");
        ServiceProvider instance = null;
        Address expResult = null;
        Address result = instance.getSpAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSpAddress method, of class ServiceProvider.
     */
    @Disabled
    public void testSetSpAddress() {
        System.out.println("setSpAddress");
        Address spAddress = null;
        ServiceProvider instance = null;
        instance.setSpAddress(spAddress);
    }

    /**
     * Test of getSpGeoAreaList method, of class ServiceProvider.
     */
    @Disabled
    public void testGetSpGeoAreaList() {
        System.out.println("getSpGeoAreaList");
        ServiceProvider instance = null;
        SPGeographicAreaList expResult = null;
        SPGeographicAreaList result = instance.getSpGeoAreaList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpCatList method, of class ServiceProvider.
     */
    @Disabled
    public void testGetSpCatList() {
        System.out.println("getSpCatList");
        ServiceProvider instance = null;
        SPCategoryList expResult = null;
        SPCategoryList result = instance.getSpCatList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class ServiceProvider.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat = null;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of addGeoArea method, of class ServiceProvider.
     */
    @Test
    public void testAddGeoArea() {
        System.out.println("addGeoArea");
        GeographicArea geoArea = null;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.addGeoArea(geoArea);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpAvailabilityList method, of class ServiceProvider.
     */
    @Disabled
    public void testGetSpAvailabilityList() {
        System.out.println("getSpAvailabilityList");
        ServiceProvider instance = null;
        SPAvailabilityList expResult = null;
        SPAvailabilityList result = instance.getSpAvailabilityList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRatings method, of class ServiceProvider.
     */
    @Disabled
    public void testGetRatings() {
        System.out.println("getRatings");
        ServiceProvider instance = null;
        List<Integer> expResult = null;
        List<Integer> result = instance.getRatings();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAverageRating method, of class ServiceProvider.
     */
    @Disabled
    public void testGetAverageRating() {
        System.out.println("getAverageRating");
        ServiceProvider instance = null;
        double expResult = 0.0;
        double result = instance.getAverageRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAverageRating method, of class ServiceProvider.
     */
    @Disabled
    public void testSetAverageRating() {
        System.out.println("setAverageRating");
        double average = 0.0;
        ServiceProvider instance = null;
        instance.setAverageRating(average);
    }

    /**
     * Test of setClassification method, of class ServiceProvider.
     */
    @Disabled
    public void testSetClassification() {
        System.out.println("setClassification");
        String label = "";
        ServiceProvider instance = null;
        instance.setClassification(label);
    }

    /**
     * Test of registerEvaluation method, of class ServiceProvider.
     */
    @Test
    public void testRegisterEvaluation() {
        System.out.println("registerEvaluation");
        int rating = 0;
        ServiceOrder servOrder = null;
        ServiceProvider instance = null;
        instance.registerEvaluation(rating, servOrder);
    }

    /**
     * Test of recalculateAverage method, of class ServiceProvider.
     */
    @Test
    public void testRecalculateAverage() {
        System.out.println("recalculateAverage");
        ServiceProvider instance = null;
        instance.recalculateAverage();
    }

    /**
     * Test of hasGeographicArea method, of class ServiceProvider.
     */
    @Test
    public void testHasGeographicArea() {
        System.out.println("hasGeographicArea");
        GeographicArea area = null;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.hasGeographicArea(area);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasCategory method, of class ServiceProvider.
     */
    @Test
    public void testHasCategory() {
        System.out.println("hasCategory");
        Category category = null;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.hasCategory(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceProvider.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        ServiceProvider instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEvaluation method, of class ServiceProvider.
     */
    @Test
    public void testAddEvaluation() {
        System.out.println("addEvaluation");
        Evaluation eval = null;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.addEvaluation(eval);
        assertEquals(expResult, result);
    }

    /**
     * Test of isAvailable method, of class ServiceProvider.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        SchedulePreference schedule = null;
        int duration = 0;
        ServiceProvider instance = null;
        boolean expResult = false;
        boolean result = instance.isAvailable(schedule, duration);
        assertEquals(expResult, result);
    }
    
}