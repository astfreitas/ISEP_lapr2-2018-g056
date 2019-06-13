package lapr.project.gpsd.model;

import java.time.LocalDateTime;
import lapr.project.gpsd.utils.Constants;

public class ServiceAssignment {

    private ServiceProvider serviceProvider;
    private ServiceRequestDescription serviceRequestDescription;
    private ServiceRequest serviceRequest;
    private SchedulePreference schedulePreference;

    /**
     * Constructor for ServiceAssignment
     *
     * @param serviceProvider
     * @param serviceRequestDescription
     * @param serviceRequest
     * @param schedulePreference
     */
    public ServiceAssignment(ServiceProvider serviceProvider, ServiceRequestDescription serviceRequestDescription, ServiceRequest serviceRequest, SchedulePreference schedulePreference) {
        this.serviceProvider = serviceProvider;
        this.serviceRequestDescription = serviceRequestDescription;
        this.serviceRequest = serviceRequest;
        serviceRequestDescription.setAssigned(Constants.SERVICE_ASSIGNED);
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
     * Get the ServiceRequest that originated the ServiceRequestDescription
     *
     * @return
     */
    public ServiceRequest getServiceRequest() {
        return serviceRequest;
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

    /**
     * Method verifies if the ServiceAssignment has expired
     * @return true if it is
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(getSchedulePreference().getDateTime());
    }

}
