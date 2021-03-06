package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;

/**
 *
 * @author astfr
 */
public class GeographicAreaRegistry {

    /**
     * List of Geographic Areas known by the company
     */
    private List<GeographicArea> geoAreaList;

    /**
     * Protected string to use to generate and ID for each Geographic Area
     * Instance.
     */
    protected String geoIDModel = "GeoArea";

    /**
     * Construstor for the GeographicAreaRegistry instance. No parameters needed
     * - just iniciates a new ArrayList for GeoAreaList.
     */
    public GeographicAreaRegistry() {
        geoAreaList = new ArrayList<>();
    }

    /**
     * Method returns nearest GeograficArea instance from a given postal code
     * instance
     *
     * @param postalCode PostaCode instance to search
     * @return the nearest GeographicArea instance found or null
     */
    public GeographicArea getNearestGeographicArea(PostalCode postalCode) {
        double shorteDistance = 999999999;
        GeographicArea nearestGeoArea = null;
        for (GeographicArea geoArea : geoAreaList) {
            if (geoArea.getMainPostalCode().equals(postalCode)) {
                return geoArea;
            } else {
                double distance = geoArea.getDistanceToPostalCode(postalCode);
                if (distance < shorteDistance) {
                    nearestGeoArea = geoArea;
                    shorteDistance = distance;
                }
            }
        }
        return nearestGeoArea;
    }

    /**
     * Returns a new instance of Geographic Area.
     *
     * @param designation designaation
     * @param cost cost
     * @param strPC PostalCode in String format
     * @param radius radius for action area // * @param exService reference for
     * the ExternalService
     * @return new instance of GeographicArea
     */
    public GeographicArea newGeographicArea(String designation, double cost, String strPC, double radius) {
        IExternalService exService = ApplicationGPSD.getInstance().getCompany().getExternalService();
        PostalCodeRegistry pcReg = ApplicationGPSD.getInstance().getCompany().getPostalCodeRegistry();
        return new GeographicArea(designation, cost, radius, strPC, exService, pcReg);
    }

    /**
     * Initializes the registration of a given Geographic Area instance by
     * performing the process of validation and addition to the register list.
     *
     * @param geoA GeographicArea instance to register.
     * @return true if the register process was completed otherwise returns
     * false
     */
    public boolean registerGeographicArea(GeographicArea geoA) {
        if (validateGeoAreaExists(geoA)) {
            setNewGeoAreaID(geoA);
            return addGeoArea(geoA);
        } else {
            return false;
        }

    }

    /**
     * Validates if the given GeographicArea instance exists on the
     * GeographicAreaList
     *
     * @param geoA GeoArea instance to validate
     * @return false if an equal instance is found in the list or true otherwise
     */
    private boolean validateGeoAreaExists(GeographicArea geoA) {
        for (GeographicArea geographicArea : geoAreaList) {
            if (geographicArea.equals(geoA)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates if the given GeographicArea instance atributes has Designation and 
     * MainPostalCode are not empty
     *
     * @param geoA GeographicArea instance to validate.
     * @return true if the fields are not empty, otherwise false
     */
    public boolean validationGeoArea(GeographicArea geoA) {
        if (geoA.getDesignation().isEmpty() && geoA.getMainPostalCode().getPostalCode().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Adds to the geoAreaList and instance of GeographicArea
     *
     * @param geoA given instance to add
     * @return true if list was able to add otherwise returns false
     */
    private boolean addGeoArea(GeographicArea geoA) {
        return geoAreaList.add(geoA);
    }

    /**
     * returns a list of geographic areas
     *
     * @return geographic areas list
     */
    public List<GeographicArea> getGeographicAreas() {
        return geoAreaList;
    }

    /**
     * serches in the registry for a geographic area with a specific ID
     *
     * @param geoId ID to look for
     * @return Category with the ID. Null if none is found.
     */
    public GeographicArea getGeoAreaById(String geoId) {
        for (GeographicArea geo : geoAreaList) {
            if (geo.hasId(geoId)) {
                return geo;
            }
        }
        return null;
    }
    
    /**
     * serches in the registry for a geographic area with a specific ID
     *
     * @param desi Designation to look for
     * @return Category with the ID. Null if none is found.
     */
    public GeographicArea getGeoAreaByDesignation(String desi) {
        for (GeographicArea geo : geoAreaList) {
            if (geo.hasDesignation(desi)) {
                return geo;
            }
        }
        return null;
    }

    /**
     * Generates and ID for and give Geographic Area instance bases on a
     * protected atribute in this class and the number of elemets whitin the
     * GeoAreList List.
     *
     * @param geoA Instance of GeographicAre to set an ID
     */
    private void setNewGeoAreaID(GeographicArea geoA) {
        int numberGeoListEntries = geoAreaList.size();
        geoA.setGeoId(geoIDModel + numberGeoListEntries);
    }
    /**
     * Returns a List of GeographicArea instances that have a matching
     * PostalCode within the Locations List
     * @param pc PostalCode object to check for matched areas
     * @return List GeographicAre with reference to all that have a PostalCode
     * matching the given reference. If none are found returns null.
     */
    public List<GeographicArea> getAreasWithLocale(PostalCode pc){
        List<GeographicArea> matchedList = new ArrayList<>();
        for (GeographicArea geoArea : geoAreaList) {
            if (geoArea.checkLocationsForPC(pc)) {
                matchedList.add(geoArea);
            }
        }
        return matchedList;
    }
}
