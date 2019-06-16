package lapr.project.gpsd.model;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class AdapterXLS implements FileType {
    
    private String adapterFileType = "xls";
    private int rowNumber;
    private Workbook workbook;
    private Sheet sheet;
    
    /**
     * 
     * Creates an insance os AdapterXLS
     * 
     */
    public AdapterXLS() {
        rowNumber = 0;
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Sheet");
    }
    
    /**
     * 
     * Receives data and exports it to a XLS file
     * 
     * @param filename file name
     * @param line line to be written
     */
    @Override
    public void export(String filename, String[] line) {   
        ExportXLS.export(filename, line, rowNumber);
        rowNumber++;
    }
    
    /**
     * 
     * Returns the file type
     * 
     * @return File type
     */
    @Override
    public String toString() {
        return this.adapterFileType;
    }
    
}
