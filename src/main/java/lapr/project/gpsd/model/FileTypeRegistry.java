package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.utils.Constants;

public class FileTypeRegistry {

    public ArrayList<FileType> fileTypeList;

    public FileTypeRegistry() {
        fileTypeList = new ArrayList<>();
    }

    public ArrayList<FileType> getFileTypeList() {
        return fileTypeList;
    }

    public FileType getExportAdapterByFileType(FileType fileType) {
        Class fileTypeClass;
        try {
            fileTypeClass = Class.forName(fileType.toString());
            FileType adapter = (FileType) fileTypeClass.getConstructor().newInstance();
            return adapter;
        } catch (ClassNotFoundException | IllegalAccessException 
                | IllegalArgumentException | InstantiationException 
                | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
        }
        return null;
    }
    
   /**
     * build supported file types
     *
     * @param props
     * @return list of supported file types
     */
    public List<FileType> createSupportedFileTypes(Properties props) {
        List<FileType> fileTypes = new ArrayList();
        
        // know how many ServiceTypes are supported
        String qttFileTypes = props.getProperty("Company.QuantityImportTypesSupported");
        int qtt = Integer.parseInt(qttFileTypes);
   
        // for each type of service supported creates the respective instance  
        for (int i = 1; i <= qtt; i++) {
            String classe = props.getProperty("Company.ImportType." + i + ".Class");
            FileType fileType = null;
            try {
                fileType = (FileType) Class.forName(classe).getConstructor().newInstance();
            } catch (Exception ex) {
            }
            fileTypes.add(fileType);
        }
        return fileTypes;
    } 
}
