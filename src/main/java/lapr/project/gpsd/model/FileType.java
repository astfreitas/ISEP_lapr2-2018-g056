package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.util.ArrayList;

public interface FileType {
    public abstract boolean export(ArrayList<ServiceOrder> servOrderList, LocalDate sDate, LocalDate eDate, ServiceProvider sp);
    public abstract String getAdapterFileType();
}
