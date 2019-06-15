/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import lapr.project.gpsd.model.FileType;
import lapr.project.gpsd.model.ServiceOrder;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author astfr
 */
public class ConsultServiceOrderControllerTest {

    private ApplicationGPSD app;

    /**
     * Initiating the GPSD aaplication and bootstrap to login with correct
     * permissions
     */
    public ConsultServiceOrderControllerTest() {

        this.app = ApplicationGPSD.getInstance();
        app.bootstrap();
        System.out.println("Login state: " + ApplicationGPSD.getInstance().doLogin("10001@companylda.com", "password"));
    }

    /**
     * Test of getServiceOrderByDateAndSP method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testGetServiceOrderByDateAndSP_NoResult() {
        System.out.println("getServiceOrderByDateAndSP with results");
        LocalDate sDate = LocalDate.parse("2019-06-01");
        LocalDate eDate = LocalDate.parse("2019-06-30");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        int expResult = 1;
        ArrayList<ServiceOrder> resultList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        int result = resultList.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrderByDateAndSP method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testGetServiceOrderByDateAndSP() {
        System.out.println("getServiceOrderByDateAndSP");
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        int expResult = 0;
        ArrayList<ServiceOrder> resultList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        int result = resultList.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileTypes method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetFileTypes_qtyTrue() {
        System.out.println("getFileTypes - Test 3 types return");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        int expResult = 3;
        ArrayList<FileType> resultList = instance.getFileTypes();
        int result = resultList.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileTypes method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetFileTypes_CSV() {
        System.out.println("getFileTypes - Test CSV");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        String expResult = "csv";
        ArrayList<FileType> resultList = instance.getFileTypes();
        String result = resultList.get(0).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileTypes method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetFileTypes_XML() {
        System.out.println("getFileTypes - Test XML");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        String expResult = "xml";
        ArrayList<FileType> resultList = instance.getFileTypes();
        String result = resultList.get(1).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileTypes method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetFileTypes_XLS() {
        System.out.println("getFileTypes - Test XLS");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        String expResult = "xls";
        ArrayList<FileType> resultList = instance.getFileTypes();
        String result = resultList.get(2).toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of exportServiceOrdersByFileType method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testExportServiceOrdersByFileType_CSV() {
        System.out.println("exportServiceOrdersByFileType - CSV");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<FileType> fileList = instance.getFileTypes();
        LocalDate sDate = LocalDate.parse("2019-06-01");
        LocalDate eDate = LocalDate.parse("2019-06-30");
        FileType fileType = fileList.get(0);
        ArrayList<ServiceOrder> servOrderList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        boolean expResult = true;
        boolean result = instance.exportServiceOrdersByFileType(fileType);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of exportServiceOrdersByFileType method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testExportServiceOrdersByFileType_XML() {
        System.out.println("exportServiceOrdersByFileType - CSV");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<FileType> fileList = instance.getFileTypes();
        LocalDate sDate = LocalDate.parse("2019-06-01");
        LocalDate eDate = LocalDate.parse("2019-06-30");
        FileType fileType = fileList.get(1);
        ArrayList<ServiceOrder> servOrderList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        boolean expResult = true;
        boolean result = instance.exportServiceOrdersByFileType(fileType);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of exportServiceOrdersByFileType method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testExportServiceOrdersByFileType_XLS() {
        System.out.println("exportServiceOrdersByFileType - CSV");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<FileType> fileList = instance.getFileTypes();
        LocalDate sDate = LocalDate.parse("2019-06-01");
        LocalDate eDate = LocalDate.parse("2019-06-30");
        FileType fileType = fileList.get(2);
        ArrayList<ServiceOrder> servOrderList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        boolean expResult = true;
        boolean result = instance.exportServiceOrdersByFileType(fileType);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of exportServiceOrdersByFileType method, of class
     * ConsultServiceOrderController.
     */
    @Test
    public void testExportServiceOrdersByFileType_Failed() {
        System.out.println("exportServiceOrdersByFileType - Faied");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        ArrayList<FileType> fileList = instance.getFileTypes();
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        FileType fileType = fileList.get(0);
        ArrayList<ServiceOrder> servOrderList = instance.getServiceOrderByDateAndSP(sDate, eDate);
        boolean expResult = true;
        boolean result = instance.exportServiceOrdersByFileType(fileType);
        assertEquals(expResult, result);
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
    }
    
    /**
     * Test of setDatesToSearch method, of class ConsultServiceOrderController.
     */
    @Test
    public void testSetDatesToSearch_invalidDate() {
        assertThrows( DateTimeException.class, () -> {
        System.out.println("setDatesToSearch");
        LocalDate sDate = LocalDate.parse("01");
        LocalDate eDate = LocalDate.parse("01");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        instance.setDatesToSearch(sDate, eDate);
    });
    }
    
    
    /**
     * Test of setDatesToSearch method, of class ConsultServiceOrderController.
     */
    @Test
    public void testSetDatesToSearch_valid() {
        System.out.println("setDatesToSearch");
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        instance.setDatesToSearch(sDate, eDate);
    }
    

    /**
     * Test of getsDate method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetsDate() {
        System.out.println("getsDate");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        instance.setDatesToSearch(sDate, eDate);
        LocalDate result = instance.getsDate();
        LocalDate expResult = sDate;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getsDate method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGetsDateFailExp() {
        System.out.println("getsDate - fail exp");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        instance.setDatesToSearch(sDate, eDate);
        LocalDate result = instance.getsDate();
        LocalDate expResult = eDate;
        assertNotEquals(expResult, result);
    }
    

    /**
     * Test of geteDate method, of class ConsultServiceOrderController.
     */
    @Disabled
    public void testGeteDate() {
        System.out.println("geteDate");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        instance.setDatesToSearch(sDate, eDate);
        LocalDate result = instance.getsDate();
        LocalDate expResult = eDate;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getsDate method, of class ConsultServiceOrderController.
     */
    @Test
    public void testGeteDateFailExp() {
        System.out.println("getsDate - fail exp");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        LocalDate sDate = LocalDate.parse("2019-05-01");
        LocalDate eDate = LocalDate.parse("2019-05-30");
        instance.setDatesToSearch(sDate, eDate);
        LocalDate result = instance.geteDate();
        LocalDate expResult = sDate;
        assertNotEquals(expResult, result);
    }
    

    /**
     * Test of getFilePath method, of class ConsultServiceOrderController.
     */
    @Disabled
    public void testGetFilePath() {
        System.out.println("getFilePath");
        ConsultServiceOrderController instance = new ConsultServiceOrderController();
        String expResult = "";
        String result = instance.getFilePath();
        assertEquals(expResult, result);
    }

}
