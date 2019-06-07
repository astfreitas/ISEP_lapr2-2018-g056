package lapr.project.gpsd.model;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdapterCSV implements FileType {

    private final String adapterFileType = "CSV";

    public AdapterCSV() {
    }

    @Override
    public String getAdapterFileType() {
        return adapterFileType;
    }

    /**
     *
     * Exports the Service Orders list to a .csv file.Implemented using OpenCSV
     * library.
     *
     * @param servOrderList Service order list to export
     * @param sDate Start date of the list
     * @param eDate End date of the list
     * @param sp Service Provider
     * @return The success of the operation
     */
    @Override
    public boolean export(ArrayList<ServiceOrder> servOrderList, LocalDate sDate, LocalDate eDate, ServiceProvider sp) {
        String filename = "./" + sp.getNumber() + "_" + sDate.toString() + "_" + eDate.toString();
        CSVWriter csvWriter = null;
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(filename));
            csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        } catch (IOException ex) {
        }
        String[] headerRecord = {"ClientName", "SchedulePreferenceDay", "SchedulePreferenceTime", "Category", "Service"};
        csvWriter.writeNext(headerRecord);
        for(ServiceOrder servOrder : servOrderList){
            String clientName = servOrder.getServiceRequest().getClient().getName();
            String clientEmail = servOrder.getServiceRequest().getClient().getEmail();
            String schePrefDay = servOrder.getSchePref().getDate().toString();
            String schePrefTime = servOrder.getSchePref().getTime().toString();
            String category = servOrder.getServiceRequestDescription().getService().getCategory().getDescription();
            String service = servOrder.getServiceRequestDescription().getService().getBriefDescription();
            String[] line = {clientName, clientEmail, schePrefDay, schePrefTime, category, service};
            csvWriter.writeNext(line);
        }
        File fileCSV = new File("./" + sp.getNumber() + "_" + sDate.toString() + "_" + eDate.toString());
        return fileCSV.exists();
    }

}
