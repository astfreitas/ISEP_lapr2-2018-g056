/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.Category;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author astfr
 */
public class SpecifyCategoryControllerTest {
    
    private ApplicationGPSD app;
    /**
     * Initiating the GPSD aaplication and bootstrap to login with correct permissions
     */
    public SpecifyCategoryControllerTest() {
        this.app = ApplicationGPSD.getInstance();
        app.bootstrap();
        System.out.println("Login state: " + ApplicationGPSD.getInstance().doLogin("adm1@isep.ipp.pt", "123"));
    }
    
    /**
     * Test of newCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String code = "99";
        String description = "TestNewCategory";
        SpecifyCategoryController instance = new SpecifyCategoryController();
        boolean expResult = true;
        boolean result = instance.newCategory(code, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerCategory method, of class SpecifyCategoryController.
     */
    @Test
    public void testRegisterCategory() {
        System.out.println("registerCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
        instance.newCategory("5", "Painter");
        boolean expResult = false;
        boolean result = instance.registerCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class SpecifyCategoryController.
     */
    @Disabled
    public void testGetCategory() {
        System.out.println("getCategory");
        SpecifyCategoryController instance = new SpecifyCategoryController();
        Category expResult = new Category("2", "Locksmith");
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }
    
}
