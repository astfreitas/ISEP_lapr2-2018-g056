package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluationTest {

    /**
     * Test of getRating method, of class Evaluation.
     */
    @Disabled
    public void testGetRating() {
        System.out.println("getRating");
        Evaluation instance = null;
        int expResult = 0;
        int result = instance.getRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServOrder method, of class Evaluation.
     */
    @Disabled
    public void testGetServOrder() {
        System.out.println("getServOrder");
        Evaluation instance = null;
        ServiceOrder expResult = null;
        ServiceOrder result = instance.getServOrder();
        assertEquals(expResult, result);
    }
    
}
