package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTypeTest {
  
    /**
     * Test of export method, of class FileType.
     */
    @Disabled
    public void testExport() {
        System.out.println("export");
        String filename = "";
        String[] line = null;
        FileType instance = new FileTypeImpl();
        instance.export(filename, line);
    }

    /**
     * Test of toString method, of class FileType.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        FileType instance = new FileTypeImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    public class FileTypeImpl implements FileType {

        public void export(String filename, String[] line) {
        }

        public String toString() {
            return "";
        }
    }
    
}
