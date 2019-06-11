package lapr.project.gpsd.model;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class AdapterXLS implements FileType {
    
    private String adapterFileType = "XLS";
    private int rowNumber;
    private Workbook workbook;
    private Sheet sheet;
    
    public AdapterXLS() {
        rowNumber = 0;
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Sheet");
    }
    
    @Override
    public void export(String filename, String[] line) {   
        ExportXLS.export(filename, line, rowNumber);
        rowNumber++;
    }
    
    @Override
    public String toString() {
        return this.adapterFileType;
    }
    
}
