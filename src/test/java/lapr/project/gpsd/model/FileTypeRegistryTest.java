/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTypeRegistryTest {
    
    /**
     * Test of getFileTypeList method, of class FileTypeRegistry.
     */
    @Disabled
    public void testGetFileTypeList() {
        System.out.println("getFileTypeList");
        FileTypeRegistry instance = new FileTypeRegistry();
        ArrayList<FileType> expResult = null;
        ArrayList<FileType> result = instance.getFileTypeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExportAdapterByFileType method, of class FileTypeRegistry.
     */
    @Test
    public void testGetExportAdapterByFileType() {
        System.out.println("getExportAdapterByFileType");
        FileType fileType1 = new AdapterCSV();
        FileType fileType2 = new AdapterXLS();
        FileType fileType3 = new AdapterXML();
        FileTypeRegistry instance = new FileTypeRegistry();
        instance.getFileTypeList().add(fileType3);
        instance.getFileTypeList().add(fileType2);
        instance.getFileTypeList().add(fileType1);
        FileType expResult = fileType3;
        FileType result = instance.getExportAdapterByFileType(fileType3);
        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of createSupportedFileTypes method, of class FileTypeRegistry.
     */
    @Disabled
    public void testCreateSupportedFileTypes() {
        System.out.println("createSupportedFileTypes");
        Properties props = null;
        FileTypeRegistry instance = new FileTypeRegistry();
        instance.createSupportedFileTypes(props);
    }
    
}
