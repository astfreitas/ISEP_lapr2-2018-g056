/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.authentication.model.UserRole;
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
public class AuthenticationControllerTest {
    
    public AuthenticationControllerTest() {
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
     * Test of doLogin method, of class AuthenticationController.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String strId = "";
        String strPwd = "";
        AuthenticationController instance = new AuthenticationController();
        boolean expResult = false;
        boolean result = instance.doLogin(strId, strPwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPapeisUtilizador method, of class AuthenticationController.
     */
    @Test
    public void testGetPapeisUtilizador() {
        System.out.println("getPapeisUtilizador");
        AuthenticationController instance = new AuthenticationController();
        List<UserRole> expResult = null;
        List<UserRole> result = instance.getPapeisUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doLogout method, of class AuthenticationController.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        AuthenticationController instance = new AuthenticationController();
        instance.doLogout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
