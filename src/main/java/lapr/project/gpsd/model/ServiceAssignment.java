package lapr.project.gpsd.model;

public class ServiceAssignment {

    private ServiceProvider serviceProvider;
    private ServiceRequestDescription serviceRequestDescription;
    private ServiceOrder serviceOrder;
    private SchedulePreference schedulePreference;

    /**
     * Constructor for ServiceAssignment
     *
     * @param serviceProvider
     * @param serviceRequestDescription
     * @param serviceOrder
     * @param schedulePreference
     */
    public ServiceAssignment(ServiceProvider serviceProvider, ServiceRequestDescription serviceRequestDescription, ServiceOrder serviceOrder, SchedulePreference schedulePreference) {
        this.serviceProvider = serviceProvider;
        this.serviceRequestDescription = serviceRequestDescription;
        this.serviceOrder = serviceOrder;
        this.schedulePreference = schedulePreference;
    }

    /**
     * Get the Service Provider assigned
     *
     * @return
     */
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Get the ServiceRequestDescription to which a Service Provider was
     * assigned
     *
     * @return
     */
    public ServiceRequestDescription getServiceRequestDescription() {
        return serviceRequestDescription;
    }

    /**
     * Get the ServiceOrder that originated the ServiceRequestDescription
     *
     * @return
     */
    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    /**
     * Get the SchedulePreference selected for the Service Provider to provide
     * it's service
     *
     * @return
     */
    public SchedulePreference getSchedulePreference() {
        return schedulePreference;
    }

}
