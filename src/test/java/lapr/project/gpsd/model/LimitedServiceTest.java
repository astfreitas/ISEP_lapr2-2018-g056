package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LimitedServiceTest {
    
    /**
     * Test of getDurationCost method, of class LimitedService.
     */
    @Test
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 120.0;
        Category cat1 = new Category("teste", "teste");
        LimitedService instance = new LimitedService("2", "Heavy plumbing", "Pipeline repair", 40, cat1);
        double expResult = 80.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getOtherAtributes method, of class LimitedService.
     */
    @Test
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        Category cat1 = new Category("teste", "teste");
        LimitedService instance = new LimitedService("2", "Heavy plumbing", "Pipeline repair", 40, cat1);
        List<String> expResult = new ArrayList();
        List<String> result = instance.getOtherAtributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class LimitedService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("testCode", "testDesc");
        LimitedService instance = new LimitedService("testID", "testBriefDesc", "testFullDesc", 100, cat);
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class LimitedService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "any string value";
        Category cat = new Category("testCode", "testDesc");
        LimitedService instance = new LimitedService("testID", "testBriefDesc", "testFullDesc", 100, cat);
        boolean expResult = false;
        boolean result = instance.setAdditionalData(data);
        assertEquals(expResult, result);
    }
    
}
