package lapr.project.gpsd.model;

public class ServiceOrder {
    
    private ServiceRequest servRequest;
    private ServiceProvider servProvider;
    private ServiceRequestDescription servRequestDesc;
    private SchedulePreference schePref;

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
}
