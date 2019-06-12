package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
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
        SPApplicationRegistry instance = new SPApplicationRegistry();
        List<SPApplication> expResult = null;
        List<SPApplication> result = instance.getApplications();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplicationByNIF method, of class SPApplicationRegistry.
     */
    @Test
    public void testGetApplicationByNIF() {
        System.out.println("getApplicationByNIF");
        String NIF = "";
        SPApplicationRegistry instance = new SPApplicationRegistry();
        SPApplication expResult = null;
        SPApplication result = instance.getApplicationByNIF(NIF);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAcceptedApplications method, of class SPApplicationRegistry.
     */
    @Test
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
    @Test
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
    @Test
    public void testValidateApplication() {
        System.out.println("validateApplication");
        SPApplication spa = null;
        SPApplicationRegistry instance = new SPApplicationRegistry();
        instance.validateApplication(spa);
    }

    /**
     * Test of registerApplication method, of class SPApplicationRegistry.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        SPApplication spa = null;
        SPApplicationRegistry instance = new SPApplicationRegistry();
        boolean expResult = false;
        boolean result = instance.registerApplication(spa);
        assertEquals(expResult, result);
    }
    
}
