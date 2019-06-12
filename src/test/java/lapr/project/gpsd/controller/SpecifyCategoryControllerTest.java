/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Category;
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
public class SpecifyCategoryControllerTest {
    
    public SpecifyCategoryControllerTest() {
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
     * Test of newCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String code = "";
        String description = "";
        SpecifyCategoryController instance = new SpecifyCategoryController();
        boolean expResult = false;
        boolean result = instance.newCategory(code, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testRegisterCategory() {
        System.out.println("registerCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
        boolean expResult = false;
        boolean result = instance.registerCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
        Category expResult = null;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
