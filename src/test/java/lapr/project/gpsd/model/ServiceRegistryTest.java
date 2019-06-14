/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceRegistryTest {

    /**
     * Test of validateService method, of class ServiceRegistry.
     */
    @Test
    public void testValidateService() {
        System.out.println("validateService");
        Category cat = new Category("codeTest", "descTest");
        Service serv = new FixedService("idTest", "testDesc", "testDesc", 100, cat);
        ServiceRegistry instance = new ServiceRegistry();
        boolean expResult = true;
        boolean result = instance.validateService(serv);
        assertEquals(expResult, result);
    }

    /**
     * Test of addService method, of class ServiceRegistry.
     */
    @Test
    public void testAddService() {
        System.out.println("addService");
        Category cat = new Category("codeTest", "descTest");
        Service serv = new FixedService("idTest", "testDesc", "testDesc", 100, cat);
        ServiceRegistry instance = new ServiceRegistry();
        boolean expResult = true;
        boolean result = instance.addService(serv);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerService method, of class ServiceRegistry.
     */
    @Test
    public void testRegisterService() {
        System.out.println("registerService");
        Category cat = new Category("codeTest", "descTest");
        Service serv = new FixedService("idTest", "testDesc", "testDesc", 100, cat);
        ServiceRegistry instance = new ServiceRegistry();
        boolean expResult = true;
        boolean result = instance.registerService(serv);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServices method, of class ServiceRegistry.
     */
    @Disabled
    public void testGetServices() {
        System.out.println("getServices");
        ServiceRegistry instance = new ServiceRegistry();
        List<Service> expResult = null;
        List<Service> result = instance.getServices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceById method, of class ServiceRegistry.
     */
    @Test
    public void testGetServiceById() {
        System.out.println("getServiceById");
        String idServ = "idTest";
        Category cat = new Category("codeTest", "descTest");
        Service serv = new FixedService(idServ, "testDesc", "testDesc", 100, cat);
        ServiceRegistry instance = new ServiceRegistry();
        instance.addService(serv);
        Service expResult = serv;
        Service result = instance.getServiceById(idServ);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServicesFromCategory method, of class ServiceRegistry.
     */
    @Test
    public void testGetServicesFromCategory() {
        System.out.println("getServicesFromCategory");
        String idCat = "codeTest";
        Category cat = new Category("codeTest", "descTest");
        Service serv = new FixedService("idTest", "testDesc", "testDesc", 100, cat);
        ServiceRegistry instance = new ServiceRegistry();
        instance.addService(serv);
        List<Service> expResult = new ArrayList<>();
        expResult.add(serv);
        List<Service> result = instance.getServicesFromCategory(idCat);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRequest method, of class ServiceRegistry.
     */
    @Disabled
    public void testValidateRequest() {
        System.out.println("validateRequest");
        ServiceRequest serviceRequest = null;
        ServiceRegistry instance = new ServiceRegistry();
        boolean expResult = false;
        boolean result = instance.validateRequest(serviceRequest);
        assertEquals(expResult, result);
    }
}
