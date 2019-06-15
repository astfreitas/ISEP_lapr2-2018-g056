package lapr.project.gpsd.model;

import java.io.File;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportXMLTest {

    /**
     * Test of export method, of class ExportXML.
     */
    @Test
    public void testExport() {
        System.out.println("export");
        new File("./src/main/resources/testFiles/").mkdir();
        String filename = "src/main/resources/testFiles/test.xml";
        String[] line = {"cliName", "cliEmail", "Day", "Time", "Category", "Serv"};
        ExportXML.export(filename, line);
    }

}
