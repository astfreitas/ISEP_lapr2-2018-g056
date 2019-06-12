package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendableServiceTest {
  
    /**
     * Test of getDurationCost method, of class ExtendableService.
     */
    @Disabled
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 0.0;
        ExtendableService instance = null;
        double expResult = 0.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOtherAtributes method, of class ExtendableService.
     */
    @Disabled
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        ExtendableService instance = null;
        List<String> expResult = null;
        List<String> result = instance.getOtherAtributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class ExtendableService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        ExtendableService instance = null;
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class ExtendableService.
     */
    @Disabled
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        ExtendableService instance = null;
        boolean expResult = false;
        boolean result = instance.setAdditionalData(data);
        assertEquals(expResult, result);
    }
    
}
