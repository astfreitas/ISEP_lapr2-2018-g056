
package lapr.project.gpsd.model;

import lapr.project.gpsd.utils.Constants;


public class ServiceRequestDescription {
    
    /**
     * atributes of the decription of service request
     */
    private Service service;
    private String description;
    private int duration;
    private String assigned;
    /**
     * cosntructor with 3 parameters
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
     * @return service cost
     */
    public double getCost() {
        return this.service.getDurationCost(duration);
    }

    @Override
    public String toString() {
        return "ServiceRequestDescription{" + "service=" + service + ", description=" + description + ", duration=" + duration + '}';
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }
    
    /**
     * @return if the service is assigned
     */
    public boolean isAssigned() {
        return assigned.equals(Constants.SERVICE_ASSIGNED);
    }
    
    /**
     * @return if the service was acepted
     */    
    public boolean isAccepted() {
        return assigned.equals(Constants.SERVICE_ACCEPTED);
    }

    public Service getService() {
        return service;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
    
    /**
     * Method returns Category of the Service Request Description
     * @return Category of the Service Request Description
     */
    public String getPropertyCategory() {
        return this.service.getCategory().getDescription();
    }
    
    /**
     * Method returns Service Brief Desc
     * @return Service Brief Desc
     */
    public String getPropertyService() {
        return this.service.getBriefDescription();
    }
    
    /**
     * Method returns Service Duration
     * @return Service Duration
     */
    public String getPropertyDuration() {
        return String.valueOf(this.duration);
    }
    
    /**
     * Method returns Service Cost
     * @return Service Cost
     */
    public String getPropertyCost() {
        return String.valueOf(this.getCost());
    }
    
    
}
