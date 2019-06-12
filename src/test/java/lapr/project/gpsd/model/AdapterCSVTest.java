package lapr.project.gpsd.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;

public class AdapterCSVTest {
    
    /**
     * Test of toString method, of class AdapterCSV.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        AdapterCSV instance = new AdapterCSV();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of export method, of class AdapterCSV.
     */
    @Disabled
    public void testExport() {
        System.out.println("export");
        String filename = "";
        String[] line = null;
        AdapterCSV instance = new AdapterCSV();
        instance.export(filename, line);
    }
    
}
