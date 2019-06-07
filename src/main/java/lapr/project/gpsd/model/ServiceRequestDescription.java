
package lapr.project.gpsd.model;


public class ServiceRequestDescription {
    
    /**
     * atributes of the decription of service request
     */
    private Service service;
    private String description;
    private int duration;
    private boolean assigned;

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
        this.assigned = false;
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

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isAssigned() {
        return assigned;
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
    
    
    
    
    
}
