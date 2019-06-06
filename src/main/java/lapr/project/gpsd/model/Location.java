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
    public Location(String postalCode, double distance) {
        if (postalCode.isEmpty()) {
            throw new IllegalArgumentException("Postal Code String cannot be empty");
        } else if (distance < 0) {
            throw new IllegalArgumentException("Distance argument cannot be negative");
        }
        this.postalCode = new PostalCode(postalCode);
        this.distance = distance;
    }
}
