/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class SPCategoryListTest {
  
    /**
     * Test of getCategorylist method, of class SPCategoryList.
     */
    @Disabled
    public void testGetCategorylist() {
        System.out.println("getCategorylist");
        SPCategoryList instance = new SPCategoryList();
        List<Category> expResult = null;
        List<Category> result = instance.getCategorylist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
