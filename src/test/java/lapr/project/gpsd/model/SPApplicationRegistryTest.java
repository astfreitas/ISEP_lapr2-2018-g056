package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPApplicationRegistryTest {
  
    /**
     * Test of getApplications method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testGetApplications() {
        System.out.println("getApplications");
        ApplicationGPSD testApp = ApplicationGPSD.getInstance();
        SPApplicationRegistry instance = testApp.getCompany().getSPApplicationRegistry();
        testApp.bootstrap();
        int expResult = 2;
        List<SPApplication> spaList = instance.getApplications();
        int result = spaList.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of getApplicationByNIF method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testGetApplicationByNIF() {
        System.out.println("getApplicationByNIF");
        ApplicationGPSD testApp = ApplicationGPSD.getInstance();
        SPApplicationRegistry instance = testApp.getCompany().getSPApplicationRegistry();
        
        String NIF = "510324896";
        SPApplication expResult = new SPApplication("TestNot", "503080230", "919997458", "test@testAt.com");
        SPApplication result = instance.getApplicationByNIF(NIF);
        Assertions.assertNotEquals(expResult, result);
//        assertEquals(expResult, result);
    }

    /**
     * Test of getAcceptedApplications method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testGetAcceptedApplications() {
        System.out.println("getAcceptedApplications");
        String applicationStatus = "";
        SPApplicationRegistry instance = new SPApplicationRegistry();
        ArrayList<SPApplication> expResult = null;
        ArrayList<SPApplication> result = instance.getAcceptedApplications(applicationStatus);
        assertEquals(expResult, result);
    }

    /**
     * Test of newSPApplication method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testNewSPApplication() {
        System.out.println("newSPApplication");
        String name = "";
        String NIF = "";
        String phone = "";
        String email = "";
        SPApplicationRegistry instance = new SPApplicationRegistry();
        SPApplication expResult = null;
        SPApplication result = instance.newSPApplication(name, NIF, phone, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateApplication method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testValidateApplication() {
        System.out.println("validateApplication");
        SPApplication spa = null;
        SPApplicationRegistry instance = new SPApplicationRegistry();
        instance.validateApplication(spa);
    }

    /**
     * Test of registerApplication method, of class SPApplicationRegistry.
     */
    @Disabled
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        SPApplication spa = null;
        SPApplicationRegistry instance = new SPApplicationRegistry();
        boolean expResult = false;
        boolean result = instance.registerApplication(spa);
        assertEquals(expResult, result);
    }
    
}
