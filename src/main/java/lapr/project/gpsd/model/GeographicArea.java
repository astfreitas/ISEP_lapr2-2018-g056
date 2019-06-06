/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author astfr
 */
public class GeographicArea {

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
     * parameters and the PostalCode objeto created by the string received and
     * List of Locations by external Service. Throws Excepetion from PostalCode
     * Constructor.
     *
     * @param designation Designation string for the Geographic Area
     * @param cost Travel Cost to this Geographic Area
     * @param radius Radius double for the area of action of the GeoArea
     * @param mainPostalCode Postal Code string for the center of the GeoArea
     * @param exService reference for the External Service to use to obtain the
     * list of locations for this Geo Area
     * @throws IllegalArgumentException from PostalCode Constructor and from the
     * this constructor.
     */
    public GeographicArea(String designation, double cost, double radius,
            String mainPostalCode, IExternalService exService) {
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
        this.mainPostalCode = new PostalCode(mainPostalCode);
        this.LocationList = exService.getActsOnLocationList(this.mainPostalCode, radius);
        
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

}
