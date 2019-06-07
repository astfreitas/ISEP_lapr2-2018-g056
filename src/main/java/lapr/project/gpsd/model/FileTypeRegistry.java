package lapr.project.gpsd.model;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
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
            fileTypeClass = Class.forName(fileType.getAdapterFileType());
            FileType adapter = (FileType) fileTypeClass.getConstructor().newInstance();
            return adapter;
        } catch (ClassNotFoundException | IllegalAccessException 
                | IllegalArgumentException | InstantiationException 
                | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
        }
        return null;
    }
    
    public boolean exportData(ArrayList<ServiceOrder> serviceOrderList, FileType adapter, LocalDate sDate, LocalDate eDate, ServiceProvider sp){
        return adapter.export(serviceOrderList,sDate,eDate,sp);
    }
}
