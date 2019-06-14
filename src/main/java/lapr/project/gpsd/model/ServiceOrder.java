package lapr.project.gpsd.model;

import lapr.project.gpsd.utils.Constants;
import static lapr.project.gpsd.utils.Constants.*;

public class ServiceOrder {

    /**
     * atribtes of class ServiceOrder
     */
    private ServiceProvider servProvider;
    private ServiceRequest servRequest;
    private ServiceRequestDescription servRequestDesc;
    private SchedulePreference schedPreference;
    private int orderNumber;
    private ServiceOrderStatus status;
    private boolean serviceRated;

    /**
     * Constructor instantiates a service order with a service assignment
     *
     * @param serviceAssignment
     */
    public ServiceOrder(ServiceAssignment serviceAssignment) {
        if (serviceAssignment == null) {
            throw new IllegalArgumentException("serviceAssignment value is null");
        }
        this.servRequest = serviceAssignment.getServiceRequest();
        this.servProvider = serviceAssignment.getServiceProvider();
        this.servRequestDesc = serviceAssignment.getServiceRequestDescription();
        this.schedPreference = serviceAssignment.getSchedulePreference();
        this.servRequestDesc.setAssigned(Constants.SERVICE_ACCEPTED);
        this.status = new ServiceOrderStatus(Constants.PENDING_ORDER);
        this.serviceRated = false;
    }

    /**
     * Method that sets the Order Number.
     *
     * @param orderNumber number associated with the Service Order.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Method that sets the serviceRated flag
     *
     * @param serviceRated service rate status
     */
    public void setServiceRated(boolean serviceRated) {
        this.serviceRated = serviceRated;
    }

    /**
     * 
     * Method that returns the serviceRated flag
     * 
     * @return Service rate status
     */
    public boolean getServiceRated() {
        return serviceRated;
    }
    
    /**
     *
     * Returns the Service Order number
     *
     * @return Service Order number
     */
    public int getOrderNumber() {
        return orderNumber;
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
     * Returns full description of the Service Order in string
     *
     * @return full description of the Service Order in string
     */
    @Override
    public String toString() {
        return "Service Order Number: " + orderNumber + " | " + status
                + "| for: " + servProvider.getAbbrevName() + servRequest
                + servRequestDesc + " | SchedulePreference is " + schedPreference;
    }

}
