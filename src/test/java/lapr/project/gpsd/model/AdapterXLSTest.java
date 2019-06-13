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

public class AdapterXLSTest {
    
    /**
     * Test of export method, of class AdapterXLS.
     */
    @Test
    public void testExport() {
        System.out.println("export");
       String filename = "./src/main/resources/testFiles/testExportXLS.xls";
        String[] line = {"teste1", "teste2", "teste3"};
        AdapterXLS instance = new AdapterXLS();
        instance.export(filename, line);
    }

    /**
     * Test of toString method, of class AdapterXLS.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        AdapterXLS instance = new AdapterXLS();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
