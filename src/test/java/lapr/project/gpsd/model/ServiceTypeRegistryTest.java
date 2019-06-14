/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileInputStream;
import java.io.InputStream;
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
        String idType = "1";
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        ServiceType expResult = new ServiceType("1", "ExtendableService", "lapr.project.gpsd.model.ExtendableService");
        instance.addServiceType(expResult);
        ServiceType result = instance.getServiceTypeByID(idType);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceType method, of class ServiceTypeRegistry.
     */
    @Test
    public void testAddServiceType() {
        System.out.println("addServiceType");
        ServiceType serviceType = new ServiceType("1", "ExtendableService", "lapr.project.gpsd.model.ExtendableService");
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        boolean expResult = true;
        boolean result = instance.addServiceType(serviceType);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSupportedServiceTypes method, of class ServiceTypeRegistry.
     */
    @Test
    public void testCreateSupportedServiceTypes() {
        System.out.println("createSupportedServiceTypes");
        Properties props = new Properties();
        try {
            InputStream in = new FileInputStream("config.properties");
            props.load(in);
            in.close();
        } catch (Exception ex) {
        }
        ServiceTypeRegistry instance = new ServiceTypeRegistry();
        instance.createSupportedServiceTypes(props);
    }

}
