/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import lapr.project.gpsd.model.FileType;
import lapr.project.gpsd.model.ServiceOrder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaoferreira
 */
public class ConsultServiceOrderControllerTest {
    
    public ConsultServiceOrderControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getServiceOrderByDateAndSP method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetServiceOrderByDateAndSP() {
        System.out.println("getServiceOrderByDateAndSP");
        LocalDate sDate = null;
        LocalDate eDate = null;
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<ServiceOrder> expResult = null;
        ArrayList<ServiceOrder> result = instance.getServiceOrderByDateAndSP(sDate, eDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileTypes method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetFileTypes() {
        System.out.println("getFileTypes");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<FileType> expResult = null;
        ArrayList<FileType> result = instance.getFileTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportServiceOrdersByFileType method, of class ConsultServiceOrderController.
     */
    @Test
    public void testExportServiceOrdersByFileType() {
        System.out.println("exportServiceOrdersByFileType");
        FileType fileType = null;
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        boolean expResult = false;
        boolean result = instance.exportServiceOrdersByFileType(fileType);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatesToSearch method, of class ConsultServiceOrderController.
     */
    @Test
    public void testSetDatesToSearch() {
        System.out.println("setDatesToSearch");
        LocalDate sDate = null;
        LocalDate eDate = null;
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        instance.setDatesToSearch(sDate, eDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getsDate method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetsDate() {
        System.out.println("getsDate");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate expResult = null;
        LocalDate result = instance.getsDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geteDate method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGeteDate() {
        System.out.println("geteDate");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate expResult = null;
        LocalDate result = instance.geteDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
