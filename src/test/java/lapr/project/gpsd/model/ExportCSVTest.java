package lapr.project.gpsd.model;

import java.io.File;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportCSVTest {
 
    /**
     * Test of export method, of class ExportCSV.
     */
    @Test
    public void testExport() {
        System.out.println("export");
        new File("./src/main/resources/testFiles/").mkdir();
        String filename = "src/main/resources/testFiles/test.csv";
        String[] line = {"cliName", "cliEmail", "Day", "Time", "Category", "Serv"};
        ExportCSV.export(filename, line);
        String[] line1 = {"cliName1", "cliEmail1", "Day1", "Time1", "Category1", "Serv1"};
        ExportCSV.export(filename, line1);
    }
    
}
