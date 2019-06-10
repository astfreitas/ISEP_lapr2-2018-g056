package lapr.project.gpsd.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.FileType;
import lapr.project.gpsd.model.FileTypeRegistry;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceOrderRegistry;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProviderRegistry;
import lapr.project.gpsd.utils.Constants;

public class ConsultServiceOrderController {

    private Company company;
    private ServiceProvider sp;
    private ServiceOrderRegistry sor;
    private ArrayList<ServiceOrder> servOrderList;
    private ArrayList<FileType> fileTypeList;
    private FileTypeRegistry fileTypeRegistry;
    private LocalDate sDate;
    private LocalDate eDate;

    public ConsultServiceOrderController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_SERVICE_PROVIDER)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.servOrderList = new ArrayList<>();
    }

    public ArrayList<ServiceOrder> getServiceOrderByDateAndSP(LocalDate sDate, LocalDate eDate) {
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        sp = spr.getServiceProviderByEmail(email);
        this.sor = this.company.getServiceOrderRegistry();
        this.sDate = sDate;
        this.eDate = eDate;
        this.servOrderList = new ArrayList<>();
        this.servOrderList.addAll(this.sor.getServiceOrderByDateAndSP(this.sDate, this.eDate, sp));
        return servOrderList;
    }

    public ArrayList<FileType> getFileTypes() {
        this.fileTypeRegistry = this.company.getFileTypeRegistry();
        this.fileTypeList = fileTypeRegistry.getFileTypeList();
        return this.fileTypeList;
    }

    public boolean exportServiceOrdersByFileType(FileType fileType) {
        FileType adapter = this.fileTypeRegistry.getExportAdapterByFileType(fileType);
        String filename = "./"+sp.getNumber()+"_"+sDate.toString()+"_"+eDate.toString();
               
        sor.exportData(servOrderList,filename, adapter);

       File file = new File(filename);
       return file.exists();
    }
    
    /**
     * Sets the Start Date and End Date for the use case in controller
     * @param sDate start date
     * @param eDate end date
     */
    public void setDatesToSearch(LocalDate sDate, LocalDate eDate){
        this.sDate = sDate;
        this.eDate = eDate;
    }
    /**
     * Returns the StartDate saved in the controller
     * @return startDate
     */
    public LocalDate getsDate() {
        return sDate;
    }
    /**
     * Returns the End Date saved in the controller
     * @return endDate
     */
    public LocalDate geteDate() {
        return eDate;
    }
    
    
}
