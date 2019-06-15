/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.File;
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
    @Test
    public void testExport() {
        System.out.println("export");
        new File("./src/main/resources/testFiles/").mkdir();
        String filename = "./src/main/resources/testFiles/testExportXML.xml";
        String[] line = {"teste", "test2", "test3", "test4", "test5", "test6"};
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
