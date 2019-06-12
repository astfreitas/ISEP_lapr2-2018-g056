/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.SPApplication;
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
public class SubmitApplicationControllerTest {
    
    public SubmitApplicationControllerTest() {
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
     * Test of addAcademicCompetence method, of class SubmitApplicationController.
     */
    @Test
    public void testAddAcademicCompetence() {
        System.out.println("addAcademicCompetence");
        String course = "";
        String level = "";
        double grade = 0.0;
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.addAcademicCompetence(course, level, grade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProfessionalCompetence method, of class SubmitApplicationController.
     */
    @Test
    public void testAddProfessionalCompetence() {
        System.out.println("addProfessionalCompetence");
        String description = "";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.addProfessionalCompetence(description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newSPApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testNewSPApplication() {
        System.out.println("newSPApplication");
        String name = "";
        String NIF = "";
        String phone = "";
        String email = "";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.newSPApplication(name, NIF, phone, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newAddress method, of class SubmitApplicationController.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String catId = "";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.addCategory(catId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class SubmitApplicationController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        SubmitApplicationController instance = new SubmitApplicationController();
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.registerApplication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testValidateApplication() {
        System.out.println("validateApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.validateApplication();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testGetApplication() {
        System.out.println("getApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        SPApplication expResult = null;
        SPApplication result = instance.getApplication();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testValidateCategory() {
        System.out.println("validateCategory");
        String catId = "";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = false;
        boolean result = instance.validateCategory(catId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
