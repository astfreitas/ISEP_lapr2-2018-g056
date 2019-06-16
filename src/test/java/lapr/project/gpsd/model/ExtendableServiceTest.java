package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendableServiceTest {
  
    /**
     * Test of getDurationCost method, of class ExtendableService.
     */
    @Test
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 0.0;
        Category cat = new Category("Tes", "te");
        ExtendableService instance = new ExtendableService("4", "Prepare dinner", "Prepare dinner and clean kitchen", 80, cat);
        double expResult = 160.0;
        double result = instance.getDurationCost(120);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getOtherAtributes method, of class ExtendableService.
     */
    @Test
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        Category cat = new Category("Tes", "te");
        ExtendableService instance = new ExtendableService("4", "Prepare dinner", "Prepare dinner and clean kitchen", 80, cat);
        List<String> expResult = new ArrayList();
        List<String> result = instance.getOtherAtributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class ExtendableService.
     */
    @Test
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        Category cat = new Category("testCode", "testDesc");
        ExtendableService instance = new ExtendableService("testID", "testBriefDesc", "testFullDesc", 10, cat);
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class ExtendableService.
     */
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        Category cat = new Category("Tes", "te");
        ExtendableService instance = new ExtendableService("4", "Prepare dinner", "Prepare dinner and clean kitchen", 80, cat);
        boolean expResult = false;
        boolean result = instance.setAdditionalData(data);
        assertEquals(expResult, result);
    }
    
}
