package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OtherCostTest {
    
    /**
     * Test of getValue method, of class OtherCost.
     */
    @Disabled
    public void testGetValue() {
        System.out.println("getValue");
        OtherCost instance = null;
        double expResult = 0.0;
        double result = instance.getValue();
        assertEquals(expResult, result, 0.0);
    }
    
}
