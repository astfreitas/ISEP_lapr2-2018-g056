package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExportXLSTest {
    
    /**
     * Test of export method, of class ExportXLS.
     */
    @Disabled
    public void testExport() {
        System.out.println("export");
        String filename = "";
        String[] line = null;
        int rowNumber = 0;
        ExportXLS.export(filename, line, rowNumber);
    }
    
}
