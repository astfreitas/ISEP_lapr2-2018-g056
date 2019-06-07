package lapr.project.gpsd.model;

public class ServiceOrder {
    
    private ServiceRequest servRequest;
    private ServiceProvider servProvider;
    private ServiceRequestDescription servRequestDesc;
    private SchedulePreference schePref;
    private String status;
    private String detail;

    public ServiceOrder(ServiceRequest servRequest, ServiceProvider servProvider, ServiceRequestDescription servRequestDesc, SchedulePreference schePref) {
        this.servRequest = servRequest;
        this.servProvider = servProvider;
        this.servRequestDesc = servRequestDesc;
        this.schePref = schePref;
    }
    
    public ServiceProvider getServiceProvider() {
       return this.servProvider;
    }

    public ServiceRequestDescription getServiceRequestDescription() {
       return this.servRequestDesc;
    }

    public ServiceRequest getServiceRequest() {
       return this.servRequest;
    }

    public SchedulePreference getSchePref() {
        return schePref;
    }

    public String getStatus() {
        return status;
    } 
}
