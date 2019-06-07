package lapr.project.gpsd.model;

import static lapr.project.gpsd.utils.Constants.*;



public class ServiceOrder {

    private ServiceRequestDescription servDesc;
    private ServiceProvider servProvider;
    private ServiceRequest servRequest;
    private ServiceRequestDescription servRequestDesc;
    private SchedulePreference schedPreference;
    private String id;
    private String status;
    private int orderNumber;
    
    ServiceOrder(ServiceAssignment serviceAssignment) {
        this.servRequest = serviceAssignment.getServiceRequest();
        this.servProvider = serviceAssignment.getServiceProvider();
        this.servRequestDesc = serviceAssignment.getServiceRequestDescription();
        this.schedPreference = serviceAssignment.getSchedulePreference();
    }
    
    public ServiceOrder(ServiceRequestDescription servDesc, ServiceProvider servProvider, ServiceRequest servRequest, SchedulePreference schedPreference, String id, String status) {
        this.servDesc = servDesc;
        this.servProvider = servProvider;
        this.servRequest = servRequest;
        this.schedPreference = schedPreference;
        this.id = id;
        this.status = status;
    }

    public ServiceOrder(ServiceRequest servRequest, ServiceProvider servProvider, ServiceRequestDescription servRequestDesc, SchedulePreference schePref) {
        this.servRequest = servRequest;
        this.servProvider = servProvider;
        this.servRequestDesc = servRequestDesc;
        this.schedPreference = schePref;
    }

    /**
     * Method that sets the Order Number.
     * @param orderNumber number associated with the Service Order.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    
    public ServiceRequestDescription getServDesc() {
        return servDesc;
    }

    public ServiceProvider getServiceProvider() {
        return servProvider;
    }

    public ServiceRequest getServiceRequest() {
        return servRequest;
    }

    public ServiceRequestDescription getServiceRequestDescription() {
        return this.servRequestDesc;
    }

    public SchedulePreference getSchePref() {
        return schedPreference;
    }

    public String getId() {
        return id;

    }

    public String getStatus() {
        return status;

    }

    

    public boolean isPending(String status) {
        return this.status == PENDING_ORDER;
    }

    /**
     * Checks if the Service Order has a determined ID
     *
     * @param id ID to check
     * @return true or false
     */
    public boolean hasId(String id) {
        return this.id.equalsIgnoreCase(id);
    }

}


