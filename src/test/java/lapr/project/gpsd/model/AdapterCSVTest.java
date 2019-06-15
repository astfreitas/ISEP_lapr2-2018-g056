package lapr.project.gpsd.model;

import java.io.File;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @Test
    public void testExport() {
        System.out.println("export");
        new File("./src/main/resources/testFiles/").mkdir();
        String filename = "./src/main/resources/testFiles/testExportCSV.csv";
        String[] line = {"teste1", "teste2", "teste3"};
        AdapterCSV instance = new AdapterCSV();
        instance.export(filename, line);
    }
    
}
