
package lapr.project.gpsd.model;


public class ServiceRequestDescription {
    
    /**
     * atributes of the decription of service request
     */
    private Service service;
    private String description;
    private double duration;

    /**
     * cosntructor with 3 parameters
     * @param service
     * @param description
     * @param duration 
     */
    public ServiceRequestDescription(Service service, String description, double duration) {
        this.service = service;
        this.description = description;
        this.duration = duration;
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
    
    
    
}
