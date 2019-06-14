package lapr.project.gpsd.model;

import java.util.Objects;
import lapr.project.gpsd.utils.Constants;

public class ServiceRequestDescription {

    //atributes of the decription of service request
    /**
     * Instance Service for the ServiceRequestDescription
     */
    private Service service;
    /**
     * String description for the Service Request Descriptio
     */
    private String description;
    /**
     * Duration of the service
     */
    private int duration;
    /**
     * Assigned value
     */
    private String assigned;

    /**
     * cosntructor with 3 parameters
     *
     * @param service
     * @param description
     * @param duration
     */
    public ServiceRequestDescription(Service service, String description, int duration) {
        this.service = service;
        this.description = description;
        this.duration = duration;
        this.assigned = Constants.SERVICE_NOT_ASSIGNED;
    }

    /**
     * returns the service cost
     *
     * @return service cost
     */
    public double getCost() {
        return this.service.getDurationCost(duration);
    }

    /**
     * Returns a description to the Service Request using the Service
     * BriefDescription and the duration. - used for Consult Service Orders
     *
     * @return string with service brief description and duration
     */
    @Override
    public String toString() {
        return "\nService: " + service.getBriefDescription() + " with Duration: " + duration;
    }

    /**
     * Sets the value for the atribute assigned
     *
     * @param assigned string value to set to assigned
     */
    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    /**
     * @return if the service is assigned
     */
    public boolean isAssigned() {
        return assigned.equals(Constants.SERVICE_ASSIGNED);
    }

    boolean isUnassigned() {
        return assigned.equals(Constants.SERVICE_NOT_ASSIGNED);
    }

    /**
     * @return if the service was acepted
     */
    public boolean isAccepted() {
        return assigned.equals(Constants.SERVICE_ACCEPTED);
    }

    /**
     * Returns the reference for the Service instance
     *
     * @return Service instance
     */
    public Service getService() {
        return service;
    }

    /**
     * Returns the Description for the Service Request Descrption
     *
     * @return description string
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the Duration of the Service Request Descrption
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Method returns Category of the Service Request Description
     *
     * @return Category of the Service Request Description
     */
    public String getPropertyCategory() {
        return this.service.getCategory().getDescription();
    }

    /**
     * Method returns Service Brief Desc
     *
     * @return Service Brief Desc
     */
    public String getPropertyService() {
        return this.service.getBriefDescription();
    }

    /**
     * Method returns Service Duration
     *
     * @return Service Duration
     */
    public String getPropertyDuration() {
        return String.valueOf(this.duration);
    }

    /**
     * Method returns Service Cost
     *
     * @return Service Cost
     */
    public String getPropertyCost() {
        return String.valueOf(this.getCost());
    }

    /**
     *
     * Compares two instances of ServiceRequestDescription and returns
     * true/false if they are equals or possess the same atributes
     *
     * @param otherServiceReqDesc ServiceRequestDescription to compare
     * @return True/false if they are equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherServiceReqDesc) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherServiceReqDesc) {
            return true;
        }
        // null check
        if (otherServiceReqDesc == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherServiceReqDesc.getClass()) {
            return false;
        }
        // field comparison
        ServiceRequestDescription obj = (ServiceRequestDescription) otherServiceReqDesc;
        return (Objects.equals(service, obj.service) || Objects.equals(description, obj.description)
                || Objects.equals(duration, obj.duration));
    }
//    /**
//     * Returns a copy of the ServiceRequest Description
//     * @param newServ Objecto of ServRequestDescr to copy
//     * @return new Instance for ServiceRequestDescription
//     */
//    public ServiceRequestDescription newServRequestDescriCopy(ServiceRequestDescription newServ){
//        return new ServiceRequestDescription(newServ.getService(), newServ.getDescription(), newServ.duration);
//    }

}
