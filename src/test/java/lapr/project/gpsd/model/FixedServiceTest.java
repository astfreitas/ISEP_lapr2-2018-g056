package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.utils.Constants;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixedServiceTest {
    /**
     * Test of getDurationCost method, of class FixedService.
     */
    
    //FixedService fs1 = new FixedService("1", "Light plumbing", "Install water tap", 100, this.company.getCategoryRegistry().getCatById("1"));
    @Test
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 0.0;
        Category cat1 = new Category("teste", "teste");
        FixedService instance = new FixedService("1", "Light plumbing", "Install water tap", 100, cat1);
        double expResult = 100.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getPredeterminedDuration method, of class FixedService.
     */
    @Test
    public void testGetPredeterminedDuration() {
        System.out.println("getPredeterminedDuration");
        Category cat1 = new Category("teste", "teste");
        FixedService instance = new FixedService("1", "Light plumbing", "Install water tap", 100, cat1);
        double expResult = 60.0;
        double result = instance.getPredeterminedDuration();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setPredeterminedDuration method, of class FixedService.
     */
    @Test
    public void testSetPredeterminedDuration() {
        System.out.println("setPredeterminedDuration");
        double predeterminedDuration = 2.0;
        Category cat1 = new Category("teste", "teste");
        FixedService instance = new FixedService("1", "Light plumbing", "Install water tap", 100, cat1);
        instance.setPredeterminedDuration(predeterminedDuration);
    }

    /**
     * Test of getOtherAtributes method, of class FixedService.
     */
    @Test
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        Category cat1 = new Category("teste", "teste");
        FixedService instance = new FixedService("1", "Light plumbing", "Install water tap", 100, cat1);
        String expResult = Constants.OTHER_SERV_ATRIB_PREDETERMINED_DURATION;
        String result = instance.getOtherAtributes().get(0);
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
    @Test
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        Category cat = new Category("testCode", "testDesc");
        FixedService instance = new FixedService("testID", "testBriefDesc", "testFullDesc", 100, cat);
        boolean expResult = true;
        boolean result = instance.setAdditionalData(String.format("500"));
        assertEquals(expResult, result);
    }
    
}
