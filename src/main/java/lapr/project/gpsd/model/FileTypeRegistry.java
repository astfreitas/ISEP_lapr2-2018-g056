package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
     */
    public void createSupportedFileTypes(Properties props) {
        List<FileType> fileTypes = new ArrayList();
        
        // know how many ServiceTypes are supported
        String qttFileTypes = props.getProperty("Company.QuantityImportTypesSupported");
        int qtt = Integer.parseInt(qttFileTypes);
   
        // for each type of files supported creates the respective instance  
        for (int i = 1; i <= qtt; i++) {
            String classe = props.getProperty("Company.ImportType." + i + ".Class");
            FileType fileType = null;
            try {
                fileType = (FileType) Class.forName(classe).getConstructor().newInstance();
            } catch (Exception ex) {
            }
            fileTypeList.add(fileType);
        }
    } 
}
