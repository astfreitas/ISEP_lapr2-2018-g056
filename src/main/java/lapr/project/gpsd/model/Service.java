package lapr.project.gpsd.model;

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
    private ServiceType serviceType;

    /**
     * service constructor with 5 parameters
     *
     * @param id
     * @param briefDescription
     * @param fullDescription
     * @param hourlyCost
     * @param category
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
        this.serviceType = null;
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
     * returns service type
     *
     * @return service type
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * modifies service type
     *
     * @param serviceType
     */
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }    

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

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f - Categoria: %s", this.id, this.briefDescription, this.fullDescription, this.hourlyCost, this.category.toString());
    }

}
