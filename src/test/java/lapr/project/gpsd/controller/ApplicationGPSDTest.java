/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.Company;
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
public class ApplicationGPSDTest {
    
    public ApplicationGPSDTest() {
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
     * Test of getCompany method, of class ApplicationGPSD.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        ApplicationGPSD instance = new ApplicationGPSD();
        Company expResult = null;
        Company result = instance.getCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSession method, of class ApplicationGPSD.
     */
    @Test
    public void testGetCurrentSession() {
        System.out.println("getCurrentSession");
        ApplicationGPSD instance = new ApplicationGPSD();
        UserSession expResult = null;
        UserSession result = instance.getCurrentSession();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogin method, of class ApplicationGPSD.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String id = "";
        String pwd = "";
        ApplicationGPSD instance = new ApplicationGPSD();
        boolean expResult = false;
        boolean result = instance.doLogin(id, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogout method, of class ApplicationGPSD.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        ApplicationGPSD instance = new ApplicationGPSD();
        instance.doLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstance method, of class ApplicationGPSD.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ApplicationGPSD expResult = null;
        ApplicationGPSD result = ApplicationGPSD.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
