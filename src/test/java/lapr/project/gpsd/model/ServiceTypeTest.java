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
     * Test of getTypeName method, of class ServiceType.
     */
    @Test
    public void testGetTypeName() {
        System.out.println("getTypeName");
        ServiceType instance = null;
        String expResult = "";
        String result = instance.getTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasId method, of class ServiceType.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String typeName = "";
        ServiceType instance = null;
        boolean expResult = false;
        boolean result = instance.hasId(typeName);
        assertEquals(expResult, result);
    }

    /**
     * Test of newService method, of class ServiceType.
     */
    @Test
    public void testNewService() {
        System.out.println("newService");
        String id = "";
        String briefDescription = "";
        String fullDescription = "";
        double hourlyCost = 0.0;
        Category category = null;
        ServiceType instance = null;
        Service expResult = null;
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
    }
    
}
