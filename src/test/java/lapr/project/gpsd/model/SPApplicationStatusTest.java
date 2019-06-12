package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPApplicationStatusTest {
    
    /**
     * Test of getSPApplicationStatus method, of class SPApplicationStatus.
     */
    @Disabled
    public void testGetSPApplicationStatus() {
        System.out.println("getSPApplicationStatus");
        SPApplicationStatus instance = new SPApplicationStatus();
        String expResult = "";
        String result = instance.getSPApplicationStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSPApplicationStatus method, of class SPApplicationStatus.
     */
    @Disabled
    public void testSetSPApplicationStatus() {
        System.out.println("setSPApplicationStatus");
        String spApplicationStatus = "";
        SPApplicationStatus instance = new SPApplicationStatus();
        instance.setSPApplicationStatus(spApplicationStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
