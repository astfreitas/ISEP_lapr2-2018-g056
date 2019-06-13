package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileTypeRegistry {
    /**
     * List for the FileType
     */
    public ArrayList<FileType> fileTypeList;
    
    /**
     * Constructor for the FileTypeRegistry by a new ArrayList
     */
    public FileTypeRegistry() {
        fileTypeList = new ArrayList<>();
    }

    /**
     * Returns the FileTypeRegistry list
     * @return FileTypeList
     */
    public ArrayList<FileType> getFileTypeList() {
        return fileTypeList;
    }
    /**
     * Returns the FileType
     * @param fileType
     * @return 
     */
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
        for (int i = 0; i < qtt; i++) {
            String classe = props.getProperty("Company.ImportType." + i + ".Class");
            FileType fileType = null;
            try {
                Class.forName(classe);
                fileType = (FileType) Class.forName(classe).getConstructor().newInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            fileTypeList.add(fileType);
        }
    }
}
