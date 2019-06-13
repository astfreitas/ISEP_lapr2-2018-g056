package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportXLSTest {

    /**
     * Test of export method, of class ExportXLS.
     */
    @Test
    public void testExport() {
        System.out.println("export");
        String filename = "src/main/resources/exportedFiles/test.xls";
        String[] line = {"cliName", "cliEmail", "Day", "Time", "Category", "Serv"};
        int rowNumber = 0;
        ExportXLS.export(filename, line, rowNumber);
        rowNumber++;
        String[] line1 = {"cliName1", "cliEmail1", "Day1", "Time1", "Category1", "Serv1"};
        ExportXLS.export(filename, line1, rowNumber);
    }

}
