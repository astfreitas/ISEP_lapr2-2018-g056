/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;

/**
 *
 * @author astfr
 */
public class GeographicArea {

    private String geoId;
    /**
     * Geographic area designation
     */
    private String designation;
    /**
     * Cost of travel associated with the geographic area
     */
    private double travelCost;
    /**
     * Area of activity of the Geographic Area
     */
    private double radius;
    /**
     * List of locations of action being this the list of action of the
     * Geographic area
     */
    private List<Location> LocationList;
    /**
     * Main postal code representing the center of the Geographic Area
     */
    private PostalCode mainPostalCode;

    /**
     * Geographic Area constructor with some atributos received by as method
     * parameters and the PostalCode object created by the string received and
     * List of Locations by external Service. Throws Excepetion from PostalCode
     * Constructor.
     *
     * @param geoId if of the Geographic Area
     * @param designation Designation string for the Geographic Area
     * @param cost Travel Cost to this Geographic Area
     * @param radius Radius double for the area of action of the GeoArea
     * @param mainPostalCode Postal Code string for the center of the GeoArea
     * @param exService reference for the External Service to use to obtain the
     * list of locations for this Geo Area
     * @param pcReg PostalCodeRegistry needed to obtain the existing PostalCode
     * List in system
     * @throws IllegalArgumentException from PostalCode Constructor and from the
     * this constructor.
     */
    public GeographicArea(String geoId, String designation, double cost, double radius, String mainPostalCode, IExternalService exService, PostalCodeRegistry pcReg) {
        if ((geoId == null) || (designation == null) || (mainPostalCode == null)
                || (exService == null) || (geoId.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        } else if (cost <= 0 || radius <= 0) {
            throw new IllegalArgumentException("Travel Cost or Radius cannot"
                    + "have zero or negative values");
        }
        this.geoId = geoId;
        this.designation = designation;
        this.travelCost = cost;
        this.radius = radius;
        this.mainPostalCode = ApplicationGPSD.getInstance().getCompany().getPostalCodeRegistry().getMatchingPostalCode(mainPostalCode);
        this.LocationList = exService.getActsOnLocationList(this.mainPostalCode, radius, pcReg);

    }

    /**
     * Geographic Area constructor with some atributos received by as method
     * parameters and the PostalCode object created by the string received and
     * List of Locations by external Service. Throws Excepetion from PostalCode
     * Constructor.
     *
     * @param designation Designation string for the Geographic Area
     * @param cost Travel Cost to this Geographic Area
     * @param radius Radius double for the area of action of the GeoArea
     * @param mainPostalCode Postal Code string for the center of the GeoArea
     * @param exService reference for the External Service to use to obtain the
     * list of locations for this Geo Area
     * @param pcReg PostalCodeRegistry needed to obtain the existing PostalCode
     * List in system
     * @throws IllegalArgumentException from PostalCode Constructor and from the
     * this constructor.
     */
    public GeographicArea(String designation, double cost, double radius, String mainPostalCode, IExternalService exService, PostalCodeRegistry pcReg) {
        if ((designation == null) || (mainPostalCode == null)
                || (exService == null)) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        } else if (cost <= 0 || radius <= 0) {
            throw new IllegalArgumentException("Travel Cost or Radius cannot"
                    + "have zero or negative values");
        }
        this.designation = designation;
        this.travelCost = cost;
        this.radius = radius;
        this.mainPostalCode = ApplicationGPSD.getInstance().getCompany().getPostalCodeRegistry().getMatchingPostalCode(mainPostalCode);
        this.LocationList = exService.getActsOnLocationList(this.mainPostalCode, radius, pcReg);
    }

    /**
     * Gets the Geographic area unique ID
     *
     * @return Geographic area unique ID
     */
    public String getGeoId() {
        return geoId;
    }

    /**
     * Checks if the Geographic area has a determined ID
     *
     * @param id ID to check
     * @return True/false if the Geographic area has/hasn't the ID
     */
    public boolean hasId(String id) {
        return this.geoId.equalsIgnoreCase(id);
    }

    /**
     * Checks if the Geographic area has a determined designation
     *
     * @param desig Designation to check
     * @return True/false if the Geographic area has/hasn't the Designation
     */
    public boolean hasDesignation(String desig){
        return this.designation.equalsIgnoreCase(desig);
    }
    
    /**
     * Returns the designation atribute of Geographic Area
     *
     * @return designation string
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the designation atribute of the Geographic Area a new value
     *
     * @param designation designation string
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Returns the travel coste to the of Geographic Area
     *
     * @return travel cost
     */
    public double getTravelCost() {
        return travelCost;
    }

    /**
     * Sets the travel cost to this Geographic Area
     *
     * @param travelCost
     */
    public void setTravelCost(double travelCost) {
        this.travelCost = travelCost;
    }

    /**
     * Returns the radius of the area of action of the Geographic Area
     *
     * @return radius of the area of action
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the area of action of the Geographic Area
     *
     * @param radius area of action by radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the List of locations of action being this the list of action of
     * the Geographic area
     *
     * @return location list
     */
    public List<Location> getLocationList() {
        return LocationList;
    }

    /**
     * Sets the List of locations of action being this the list of action of the
     * Geographic area
     *
     * @param LocationList List of Locations
     */
    public void setLocationList(List<Location> LocationList) {
        this.LocationList = LocationList;
    }

    /**
     * Returns the main postal coste of the Geographic Area (center)
     *
     * @return main(center) postal code
     */
    public PostalCode getMainPostalCode() {
        return mainPostalCode;
    }

    /**
     * Sets the main postal coste of the Geographic Area (center)
     *
     * @param mainPostalCode postal code
     */
    public void setMainPostalCode(PostalCode mainPostalCode) {
        this.mainPostalCode = mainPostalCode;
    }

    /**
     * Search for location listings by location with same postal code and return
     * distance.
     *
     * @param pc Posta Code to searh
     * @return the distance of the found Postal Code otherwise returns -1
     */
    public double getDistanceToPostalCode(PostalCode pc) {
        for (Location location : LocationList) {
            if (location.getPostalCode().equals(pc)) {
                return location.getDistance();
            }
        }
        return -1;
    }

    /**
     * Returns string with the desciption of Geohraphic Area with all atributes
     * to present to the textArea field
     *
     * @return string describing geogrphic Area instance
     */
    public String display() {
        return "Designation: '" + designation + "' and central PostalCode is "
                + mainPostalCode + ". \nTravel Cost is " + travelCost
                + "€, and radius of the area of action is " + radius + "."
                + "\nLocations that are part of this area are the following: \n"
                + "\n(postal code | distance to center)"
                + LocationList;
    }

    /**
     * Compares the GeographicArea instance with an objet received by reference
     * in the method parameter.
     *
     * @param otherObject Objet to compare with the GeographicArea instance
     * @return true if the received object represent and equal object of the
     * instanced GeographicArea. Otherwise returns False.
     */
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        GeographicArea otherGeoArea = (GeographicArea) otherObject;
        return this.designation.equals(otherGeoArea.designation)
                && this.mainPostalCode.equals(otherGeoArea.mainPostalCode)
                && this.radius == otherGeoArea.radius
                && this.travelCost == otherGeoArea.travelCost;
    }

    /**
     * Sets the value for the GeographicAre ID atribute
     *
     * @param geoId give strin ID to set
     */
    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    /**
     * Returns a String with the description of Geographic Area with Designation
     * and ID
     *
     * @return string description
     */
    @Override
    public String toString() {
        return designation + " (id: " + geoId + ")";
    }
    /**
     * Checks if the Location list within the current GeographicArea instance
     * has a location with the given PostalCode instance to check
     * @param pc PostalCode instance to check
     * @return true if a equal PostalCode is found, otherwise returns false
     */
    public boolean checkLocationsForPC(PostalCode pc) {
        for (Location location : LocationList) {
            if (location.getPostalCode().equals(pc)) {
                return true;
            }
        }
        return false;
    }

}
