package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class AdapterXLS implements FileType{
    
    private String adapterFileType = "XLS";

    public AdapterXLS() {
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
