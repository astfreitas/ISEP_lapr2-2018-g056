package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedServiceTest {
   
    /**
     * Test of getDurationCost method, of class FixedService.
     */
    @Disabled
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 0.0;
        FixedService instance = null;
        double expResult = 0.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPredeterminedDuration method, of class FixedService.
     */
    @Disabled
    public void testGetPredeterminedDuration() {
        System.out.println("getPredeterminedDuration");
        FixedService instance = null;
        double expResult = 0.0;
        double result = instance.getPredeterminedDuration();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setPredeterminedDuration method, of class FixedService.
     */
    @Disabled
    public void testSetPredeterminedDuration() {
        System.out.println("setPredeterminedDuration");
        double predeterminedDuration = 0.0;
        FixedService instance = null;
        instance.setPredeterminedDuration(predeterminedDuration);
    }

    /**
     * Test of getOtherAtributes method, of class FixedService.
     */
    @Disabled
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        FixedService instance = null;
        List<String> expResult = null;
        List<String> result = instance.getOtherAtributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class FixedService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("testCode", "testDesc");
        FixedService instance = new FixedService("testID", "testBriefDesc", "testFullDesc", 100, cat);
        boolean expResult = true;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class FixedService.
     */
    @Disabled
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        FixedService instance = null;
        boolean expResult = false;
        boolean result = instance.setAdditionalData(data);
        assertEquals(expResult, result);
    }
    
}
