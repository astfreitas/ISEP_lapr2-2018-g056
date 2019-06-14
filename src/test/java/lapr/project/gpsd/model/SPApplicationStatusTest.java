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
    }
    
}
