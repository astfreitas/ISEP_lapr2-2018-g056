package lapr.project.gpsd.model;

class Location {

    private PostalCode postalCode;
    private double distance;

    public Location(PostalCode postalCode, double distance) {
        this.postalCode = postalCode;
        this.distance = distance;
    }
}
