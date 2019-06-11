package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
}
