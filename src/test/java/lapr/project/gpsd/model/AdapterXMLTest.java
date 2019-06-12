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
public class AdapterXMLTest {
    
    /**
     * Test of export method, of class AdapterXML.
     */
    @Disabled
    public void testExport() {
        System.out.println("export");
        String filename = "";
        String[] line = null;
        AdapterXML instance = new AdapterXML();
        instance.export(filename, line);
    }

    /**
     * Test of toString method, of class AdapterXML.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        AdapterXML instance = new AdapterXML();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
