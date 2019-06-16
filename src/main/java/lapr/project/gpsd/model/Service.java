package lapr.project.gpsd.model;

import java.util.List;
import java.util.Objects;

public abstract class Service implements ServiceCostCalculation {

    /**
     * service atributes
     */
    private String id;
    private String briefDescription;
    private String fullDescription;
    private double hourlyCost;
    private Category category;

    /**
     * service constructor with 5 parameters
     *
     * @param id Service id
     * @param briefDescription brief description
     * @param fullDescription full description
     * @param hourlyCost hourly cost
     * @param category category
     *
     */
    public Service(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
        if ((id == null) || (briefDescription == null) || (fullDescription == null)
                || (hourlyCost < 0) || (category == null)
                || (id.isEmpty()) || (briefDescription.isEmpty()) || (fullDescription.isEmpty())) {
            throw new IllegalArgumentException("Neither of the argues should be null or empty");
        }

        this.id = id;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.hourlyCost = hourlyCost;
        this.category = category;
    }

    /**
     * return service id
     *
     * @return service id
     */
    public String getId() {
        return id;
    }

    /**
     * check if the service has id
     *
     * @param id service id
     * @return boolean
     */
    public boolean hasId(String id) {
        return this.id.equalsIgnoreCase(id);
    }

    /**
     * returns brief service description
     *
     * @return brief service description
     */
    public String getBriefDescription() {
        return briefDescription;
    }

    /**
     * returns full service description
     *
     * @return full service description
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * modifies full service description
     *
     * @param fullDescription
     */
    public void setfullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * returns hourly cost of the service
     *
     * @return hourly cost of the service
     */
    public double getHourlyCost() {
        return hourlyCost;
    }

    /**
     * returns category
     *
     * @return category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * modifies category
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }   
    
    /**
     * 
     * Creates an hashcode with the id
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * 
     * Compares two instances of Service and returns true/false if they are
     * equals or possess the same atributes
     * 
     * @param o Service to compare
     * @return True/false if they are
     * equals or possess the same atributes
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Service obj = (Service) o;
        return (Objects.equals(id, obj.id));
    }
    
    /**
     * Returns a description for the Service Object  by string.
     * Mostly used to display information to CreateServiceRequest UC.
     * @return description for the Service Object  by string
     */
    @Override
    public String toString() {
        return "Service Id: " + id + " - " + briefDescription +
                " - Cost (hour): " + hourlyCost +
                "\nComplete description: " + fullDescription + 
                 category;
    }

    

}
