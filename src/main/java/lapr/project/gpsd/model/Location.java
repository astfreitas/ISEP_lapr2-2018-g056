package lapr.project.gpsd.model;

class Location {

    /**
     * Postal Code of Location
     */
    private PostalCode postalCode;
    /**
     * Distance from the Location to the center of the Geographic Area
     */
    private double distance;
    
    /**
     * Constructor for Location receiving the arguments in the method parameters
     * @param postalCode postal code as String
     * @param distance distance to the main postal code
     */
    public Location(PostalCode postalCode, double distance) {
        if (postalCode == null) {
            throw new IllegalArgumentException("Postal Code cannot be null");
        } else if (distance < 0) {
            throw new IllegalArgumentException("Distance argument cannot be negative");
        }
        this.postalCode = postalCode;
        this.distance = distance;
    }
    /**
     * Returns the PostalCode instance
     * @return postal code 
     */
    public PostalCode getPostalCode() {
        return postalCode;
    }
    /**
     * Returns distance value to the center of the GeoArea
     * @return distance value to center GeoArea
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "\n"+postalCode + " -> " + String.format("%.2f", distance);
    }
    
    /**
     * Compares the Location instance with an objet received by reference in
     * the method parameter.
     *
     * @param otherObject Objet to compare with the Location instance
     * @return true if the received object represent and equal object of the
     * instanced Location. Otherwise returns False.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Location otherLocation = (Location) otherObject;
        return this.postalCode.equals(otherLocation.postalCode)
                && this.distance == otherLocation.distance;
    }
    
    
}
