/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 *
 * @author joaoferreira
 */
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
