package lapr.project.gpsd.model;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCSV {

    /**
     * 
     * Exports data to a csv file
     * 
     * @param filename file name and path
     * @param line data to be written
     */
    public static void export(String filename, String[] line) {
        CSVWriter csvWriter = null;
        FileWriter writer = null;
        try {
            writer = new FileWriter(filename, true);

        } catch (IOException ex) {
        }
        csvWriter = new CSVWriter(writer,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        csvWriter.writeNext(line);
        try {
            csvWriter.close();
        } catch (IOException ex) {
        }
    }
}
