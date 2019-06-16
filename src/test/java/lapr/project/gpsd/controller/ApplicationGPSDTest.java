package lapr.project.gpsd.controller;

import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Company;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationGPSDTest {

    public ApplicationGPSDTest() {
    }

    /**
     * Test of getCompany method, of class ApplicationGPSD.
     */
    @Disabled
    public void testGetCompany() {
        System.out.println("getCompany");
        ApplicationGPSD instance = new ApplicationGPSD();
        Company expResult = ApplicationGPSD.getInstance().getCompany();
        Company result = instance.getCompany();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of doLogin method, of class ApplicationGPSD.
     */
    @Test
    public void testDoLogin_False() {
        System.out.println("doLogin_False");
        String id = "fwafwa@isep.ipp.pt";
        String pwd = "123";
        ApplicationGPSD instance = new ApplicationGPSD();
        boolean expResult = false;
        boolean result = instance.doLogin(id, pwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogin method, of class ApplicationGPSD.
     */
    @Disabled
    public void testDoLogin_True() {
        System.out.println("doLogin_True");
        String id = "adm1@isep.ipp.pt";
        Client cli = new Client("1", "2", "3", "adm1@isep.ipp.pt");
        String pwd = "123";
        ApplicationGPSD instance = new ApplicationGPSD();
        instance.getCompany().getClientRegistry().registerClient(cli, pwd);
        boolean expResult = true;
        boolean result = instance.doLogin(id, pwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of doLogout method, of class ApplicationGPSD.
     */
    @Test
    public void testDoLogout() {
        System.out.println("doLogout");
        ApplicationGPSD instance = new ApplicationGPSD();
        instance.doLogout();
        Object result = instance.getCurrentSession();
        Object expResult = null;
        assertEquals(expResult, result);
    }

    /**
     * Test of bootstrap method, of class ApplicationGPSD.
     */
    @Disabled
    public void testBootstrap() {
        System.out.println("bootstrap");
        ApplicationGPSD instance = new ApplicationGPSD();
        instance.bootstrap();
        String id = "adm1@isep.ipp.pt";
        String pwd = "123";
        boolean expResult = true;
        boolean result = instance.doLogin(id, pwd);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstance method, of class ApplicationGPSD.
     */
    @Disabled
    public void testGetInstance() {
        System.out.println("getInstance");
        ApplicationGPSD expResult = null;
        ApplicationGPSD result = ApplicationGPSD.getInstance();
        assertEquals(expResult, result);
    }

}
