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
public class ClientRegistryTest {
  
    /**
     * Test of validateClient method, of class ClientRegistry.
     */
    @Test
    public void testValidateClient() {
        System.out.println("validateClient");
        Client cli = null;
        ClientRegistry instance = new ClientRegistry();
        boolean expResult = false;
        boolean result = instance.validateClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of newClient method, of class ClientRegistry.
     */
    @Test
    public void testNewClient() {
        System.out.println("newClient");
        String name = "";
        String NIF = "";
        String telephone = "";
        String email = "";
        ClientRegistry instance = new ClientRegistry();
        Client expResult = null;
        Client result = instance.newClient(name, NIF, telephone, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of addClient method, of class ClientRegistry.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        Client cli = null;
        ClientRegistry instance = new ClientRegistry();
        boolean expResult = false;
        boolean result = instance.addClient(cli);
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientByEmail method, of class ClientRegistry.
     */
    @Test
    public void testGetClientByEmail() {
        System.out.println("getClientByEmail");
        String email = "";
        ClientRegistry instance = new ClientRegistry();
        Client expResult = null;
        Client result = instance.getClientByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerClient method, of class ClientRegistry.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        Client client = null;
        String pwd = "";
        ClientRegistry instance = new ClientRegistry();
        boolean expResult = false;
        boolean result = instance.registerClient(client, pwd);
        assertEquals(expResult, result);
    }
    
}
