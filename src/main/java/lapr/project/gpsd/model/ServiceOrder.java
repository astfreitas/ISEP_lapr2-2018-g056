package lapr.project.gpsd.model;

import static lapr.project.gpsd.model.Constants.*;

public class ServiceOrder {

    private ServiceRequestDescription servDesc;
    private ServiceProvider servPorvider;
    private ServiceRequest serRequest;
    private SchedulePreference schedPreference;
    private String id;
    private String status;

    public ServiceOrder(ServiceRequestDescription servDesc, ServiceProvider servPorvider, ServiceRequest serRequest, SchedulePreference schedPreference, String id, String status) {
        this.servDesc = servDesc;
        this.servPorvider = servPorvider;
        this.serRequest = serRequest;
        this.schedPreference = schedPreference;
        this.id = id;
        this.status = status;
    }

    public ServiceRequestDescription getServDesc() {
        return servDesc;
    }

    public ServiceProvider getServPorvider() {
        return servPorvider;
    }

    public ServiceRequest getSerRequest() {
        return serRequest;
    }

    public SchedulePreference getSchedPreference() {
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
    public boolean hasId(String id)
    {
        return this.id.equalsIgnoreCase(id);
    }

}
