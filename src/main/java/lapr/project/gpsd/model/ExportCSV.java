package lapr.project.gpsd.model;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCSV {

    public static void export(String filename, String[] line) {
        CSVWriter csvWriter = null;
        try {
            FileWriter writer = new FileWriter(filename, true);
            csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        } catch (IOException ex) {
        }   
        csvWriter.writeNext(line);
        try {
            csvWriter.close();
        } catch (IOException ex) {
        }
    }
}
