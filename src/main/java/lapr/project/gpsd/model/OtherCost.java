package lapr.project.gpsd.model;

class OtherCost {

    private String description;
    private double value;

    /**
     * 
     * Creates an instance of OtherCost
     * 
     * @param description Description of the cost
     * @param value Value
     */
    public OtherCost(String description, double value) {
        this.description = description;
        this.value = value;
    }

    /**
     * 
     * Returns the Other Cost value
     * 
     * @return Other Cost value
     */
    public double getValue() {
        return value;
    }
}
