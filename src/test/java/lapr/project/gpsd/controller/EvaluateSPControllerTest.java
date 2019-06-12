/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.ServiceProvider;
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
public class EvaluateSPControllerTest {
    
    public EvaluateSPControllerTest() {
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
     * Test of getServiceProviders method, of class EvaluateSPController.
     */
    @Test
    public void testGetServiceProviders() {
        System.out.println("getServiceProviders");
        EvaluateSPController instance = new EvaluateSPController();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.getServiceProviders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSPStatistics method, of class EvaluateSPController.
     */
    @Test
    public void testNewSPStatistics() {
        System.out.println("newSPStatistics");
        String email = "";
        EvaluateSPController instance = new EvaluateSPController();
        instance.newSPStatistics(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabels method, of class EvaluateSPController.
     */
    @Test
    public void testGetLabels() {
        System.out.println("getLabels");
        EvaluateSPController instance = new EvaluateSPController();
        List<String> expResult = null;
        List<String> result = instance.getLabels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLabel method, of class EvaluateSPController.
     */
    @Test
    public void testSetLabel() {
        System.out.println("setLabel");
        String label = "";
        EvaluateSPController instance = new EvaluateSPController();
        instance.setLabel(label);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabel method, of class EvaluateSPController.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        EvaluateSPController instance = new EvaluateSPController();
        String expResult = "";
        String result = instance.getLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSPClassification method, of class EvaluateSPController.
     */
    @Test
    public void testSetSPClassification() {
        System.out.println("setSPClassification");
        EvaluateSPController instance = new EvaluateSPController();
        instance.setSPClassification();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPopulationMeanAverageRating method, of class EvaluateSPController.
     */
    @Test
    public void testGetPopulationMeanAverageRating() {
        System.out.println("getPopulationMeanAverageRating");
        EvaluateSPController instance = new EvaluateSPController();
        double expResult = 0.0;
        double result = instance.getPopulationMeanAverageRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPopulationStdDeviation method, of class EvaluateSPController.
     */
    @Test
    public void testGetPopulationStdDeviation() {
        System.out.println("getPopulationStdDeviation");
        EvaluateSPController instance = new EvaluateSPController();
        double expResult = 0.0;
        double result = instance.getPopulationStdDeviation();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpAverageRating method, of class EvaluateSPController.
     */
    @Test
    public void testGetSpAverageRating() {
        System.out.println("getSpAverageRating");
        EvaluateSPController instance = new EvaluateSPController();
        double expResult = 0.0;
        double result = instance.getSpAverageRating();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpAbsoluteDifference method, of class EvaluateSPController.
     */
    @Test
    public void testGetSpAbsoluteDifference() {
        System.out.println("getSpAbsoluteDifference");
        EvaluateSPController instance = new EvaluateSPController();
        double expResult = 0.0;
        double result = instance.getSpAbsoluteDifference();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpRatings method, of class EvaluateSPController.
     */
    @Test
    public void testGetSpRatings() {
        System.out.println("getSpRatings");
        EvaluateSPController instance = new EvaluateSPController();
        List<Integer> expResult = null;
        List<Integer> result = instance.getSpRatings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
