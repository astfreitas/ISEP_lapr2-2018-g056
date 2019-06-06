/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author astfr
 */
public class ExternalService1Test {
    
    public ExternalService1Test() {
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
     * Test of getActsOnLocationList method, of class ExternalService1.
     */
    @Ignore
    public void testGetActsOnLocationList() {
        System.out.println("getActsOnLocationList");
        PostalCode pCode= new PostalCode("4000-0013");
        double radius = 0.0;
        ExternalService1 instance = new ExternalService1();
        List<Location> expResult = null;
        List<Location> result = instance.getActsOnLocationList(pCode, radius);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPostalCodeExist method, of class ExternalService1.
     */
    @Test
    public void testCheckPostalCodeExist() {
        System.out.println("checkPostalCodeExist");
        String cp = "4000-0013";
        ExternalService1 instance = new ExternalService1();
        boolean expResult = true;
        boolean result = instance.checkPostalCodeExist(cp);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
