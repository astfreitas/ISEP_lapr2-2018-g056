package lapr.project.gpsd.model;

import static lapr.project.gpsd.utils.Constants.*;

public class ServiceOrder {

    /**
     * atribtes of class ServiceOrder
     */
    private ServiceProvider servProvider;
    private ServiceRequest servRequest;
    private ServiceRequestDescription servRequestDesc;
    private SchedulePreference schedPreference;
    private String id;
    private ServiceOrderStatus status;

    /**
     * constructor of ServiceOrder with 6 parameters
     *
     * @param servRequestDesc
     * @param servProvider
     * @param servRequest
     * @param schedPreference
     * @param id
     * @param status
     */
    public ServiceOrder(ServiceRequestDescription servRequestDesc, ServiceProvider servProvider, ServiceRequest servRequest, SchedulePreference schedPreference, String id, ServiceOrderStatus status) {
        this.servRequestDesc = servRequestDesc;
        this.servProvider = servProvider;
        this.servRequest = servRequest;
        this.schedPreference = schedPreference;
        this.id = id;
        this.status = status;
    }

    /**
     * returns the service provider associated to the service order
     *
     * @return service provider
     */
    public ServiceProvider getServiceProvider() {
        return servProvider;
    }

    /**
     * returns the service request associated to the service order
     *
     * @return service request
     */
    public ServiceRequest getServiceRequest() {
        return servRequest;
    }

    /**
     * returns the service request description associated to the service order
     *
     * @return service request description
     */
    public ServiceRequestDescription getServiceRequestDescription() {
        return this.servRequestDesc;
    }

    /**
     * returns the schedule preference associated to the service order
     *
     * @return schedule preference
     */
    public SchedulePreference getSchePref() {
        return schedPreference;
    }

    /**
     * returns the service order id associated to the service order
     *
     * @return service order id
     */
    public String getId() {
        return id;
    }

    /**
     * returns the service order status associated to the service order
     *
     * @return service order status
     */
    public ServiceOrderStatus getStatus() {
        return status;

    }

    /**
     * verifies if a service order has a pending state
     *
     * @param status of the service order
     * @return true or false
     */
    public boolean isPending(String status) {
        return this.status.getServOrderStatus().equalsIgnoreCase(PENDING_ORDER);
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
