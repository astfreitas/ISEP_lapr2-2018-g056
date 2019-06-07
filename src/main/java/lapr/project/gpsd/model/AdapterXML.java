package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class AdapterXML implements FileType{
    
    private String adapterFileType = "XML";

    public AdapterXML() {
    }

    @Override
    public boolean export(ArrayList<ServiceOrder> servOrderList, LocalDate sDate, LocalDate eDate, ServiceProvider sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdapterFileType() {
        return this.adapterFileType;
    }

}
