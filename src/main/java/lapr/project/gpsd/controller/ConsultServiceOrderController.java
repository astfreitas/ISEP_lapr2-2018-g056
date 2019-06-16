package lapr.project.gpsd.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
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

    /**
     * Instance for the Company
     */
    private Company company;
    /**
     * Instance for the selected Service Provider
     */
    private ServiceProvider sp;
    /**
     * Instance for ServiceOrderRegistry
     */
    private ServiceOrderRegistry sor;
    /**
     * List for ServiceOrder list to be used from the search in the use case
     */
    private ArrayList<ServiceOrder> servOrderList;
    /**
     * List for the FileType objects from the system
     */
    private ArrayList<FileType> fileTypeList;
    /**
     * Instance for the FileTypeRegistry
     */
    private FileTypeRegistry fileTypeRegistry;
    /**
     * Start date for the search
     */
    private LocalDate sDate;
    /**
     * End date for the search
     */
    private LocalDate eDate;
    /**
     * Exported file path
     */
    private String filePath;

    /**
     * Constructos for the ConsultServiceOrderController - checks the current
     * session logged and returns the company instances and initiates a new
     * empty array list for the class atribute servOrderList to be used.
     */
    public ConsultServiceOrderController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_SERVICE_PROVIDER)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.servOrderList = new ArrayList<>();
    }

    /**
     * Returns a list of objects of ServiceOrder from the Registry searching by
     * the given start and end dates.
     *
     * @param sDate start date
     * @param eDate end date
     * @return List of ServiceOrders available between the start and end date
     */
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

    /**
     * Returns the list objects of FileType available in the FileTypeRegistry
     *
     * @return List of FileType objects
     */
    public ArrayList<FileType> getFileTypes() {
        this.fileTypeRegistry = this.company.getFileTypeRegistry();
        this.fileTypeList = fileTypeRegistry.getFileTypeList();
        return this.fileTypeList;
    }

    /**
     * Method start the execution of the export process checking the rigth
     * adapter for the export, setting the name of the file by the number of the
     * SP and the dates selected to export the service orders
     *
     * @param fileType filepty to export
     * @return true and only if the export was perfomed and the created file
     * exists, otherwise returns false
     */
    public boolean exportServiceOrdersByFileType(FileType fileType) {
        FileType adapter = this.fileTypeRegistry.getExportAdapterByFileType(fileType);
        this.filePath= "./exportedFiles/" + sp.getNumber() + "_" + sDate.toString() + "_" + eDate.toString() + "." + fileType.toString();

        sor.exportData(servOrderList, this.filePath, adapter);

        File file = new File(this.filePath);
        return file.getAbsoluteFile().exists();
    }

    /**
     * Sets the Start Date and End Date for the use case in controller
     *
     * @param sDate start date
     * @param eDate end date
     */
    public void setDatesToSearch(LocalDate sDate, LocalDate eDate) {
        this.sDate = sDate;
        this.eDate = eDate;
    }

    /**
     * Returns the StartDate saved in the controller
     *
     * @return startDate
     */
    public LocalDate getsDate() {
        return sDate;
    }

    /**
     * Returns the End Date saved in the controller
     *
     * @return endDate
     */
    public LocalDate geteDate() {
        return eDate;
    }
    /**
     * Returns the exported file path
     * @return the exported file path in Sring
     */
    public String getFilePath() {
        return filePath;
    }
    
}
