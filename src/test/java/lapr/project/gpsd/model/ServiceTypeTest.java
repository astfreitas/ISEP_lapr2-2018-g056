/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class ServiceTypeTest {
 
    /**
     * Test of getName method, of class ServiceType.
     */
    @Disabled
    public void testGetName() {
        System.out.println("getName");
        ServiceType instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasId method, of class ServiceType.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String typeName = "1";
        ServiceType instance = new ServiceType(typeName, "ExtendableService", "lapr.project.gpsd.model.ExtendableService");
        boolean expResult = true;
        boolean result = instance.hasId(typeName);
        assertEquals(expResult, result);
    }

    /**
     * Test of newService method, of class ServiceType.
     */
    @Test
    public void testNewService() {
        System.out.println("newService");
        String id = "1";
        String briefDescription = "testDesc";
        String fullDescription = "testDesc";
        double hourlyCost = 100;
        Category category = new Category("testCode", "testDesc");
        ServiceType instance = new ServiceType("1", "ExtendableService", "lapr.project.gpsd.model.ExtendableService");
        Service expResult = new ExtendableService(id, briefDescription, fullDescription, hourlyCost, category);
        Service result = instance.newService(id, briefDescription, fullDescription, hourlyCost, category);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ServiceType.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        ServiceType instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ServiceType.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ServiceType instance = new ServiceType("1", "ExtendableService", "lapr.project.gpsd.model.ExtendableService");
        String expResult = "1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }
    
}
