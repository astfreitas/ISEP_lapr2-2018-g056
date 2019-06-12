/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class ServiceTypeRegistryTest {
 
    /**
     * Test of getServiceTypes method, of class ServiceTypeRegistry.
     */
    @Disabled
    public void testGetServiceTypes() {
        System.out.println("getServiceTypes");
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        List<ServiceType> expResult = null;
        List<ServiceType> result = instance.getServiceTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceTypeByID method, of class ServiceTypeRegistry.
     */
    @Test
    public void testGetServiceTypeByID() {
        System.out.println("getServiceTypeByID");
        String idType = "";
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        ServiceType expResult = null;
        ServiceType result = instance.getServiceTypeByID(idType);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateServiceType method, of class ServiceTypeRegistry.
     */
    @Test
    public void testValidateServiceType() {
        System.out.println("validateServiceType");
        String idType = "";
        String className = "";
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        boolean expResult = false;
        boolean result = instance.validateServiceType(idType, className);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceType method, of class ServiceTypeRegistry.
     */
    @Test
    public void testAddServiceType() {
        System.out.println("addServiceType");
        String idType = "";
        String className = "";
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        boolean expResult = false;
        boolean result = instance.addServiceType(idType, className);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSupportedServiceTypes method, of class ServiceTypeRegistry.
     */
    @Test
    public void testCreateSupportedServiceTypes() {
        System.out.println("createSupportedServiceTypes");
        Properties props = null;
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        instance.createSupportedServiceTypes(props);
    }
    
}
