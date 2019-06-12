/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
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
public class ServiceDefinitionControllerTest {
    
    public ServiceDefinitionControllerTest() {
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
     * Test of getServiceTypes method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetServiceTypes() {
        System.out.println("getServiceTypes");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<ServiceType> expResult = null;
        List<ServiceType> result = instance.getServiceTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceTypeByID method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetServiceTypeByID() {
        System.out.println("getServiceTypeByID");
        String idType = "";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        ServiceType expResult = null;
        ServiceType result = instance.getServiceTypeByID(idType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategories method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newService method, of class ServiceDefinitionController.
     */
    @Test
    public void testNewService() {
        System.out.println("newService");
        String id = "";
        String bDesc = "";
        String fDesc = "";
        double hourlyCost = 0.0;
        String catId = "";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOtherAttributes method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<String> expResult = null;
        List<String> result = instance.getOtherAttributes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdditionalData method, of class ServiceDefinitionController.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setAdditionalData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class ServiceDefinitionController.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerService method, of class ServiceDefinitionController.
     */
    @Test
    public void testRegisterService() {
        System.out.println("registerService");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.registerService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getService method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        Service expResult = null;
        Service result = instance.getService();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
