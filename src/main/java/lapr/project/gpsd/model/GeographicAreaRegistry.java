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

    public GeographicAreaRegistry() {
         geoAreaList = new ArrayList<>();
    }

    
    
    /**
     * Method returns nearest GeograficArea instance from a given postal
     * code instance 
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
                if (distance<shorteDistance) {
                    nearestGeoArea= geoArea;
                    shorteDistance = distance;
                }
            }
        }
        return nearestGeoArea;
    }


    List<GeographicArea> getAreasWithLocale(PostalCode postalCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns a new instance of Geographic Area.
     *
     * @param designation designaation
     * @param cost cost
     * @param strPC PostalCode in String format
     * @param radius radius for action area // * @param exService reference for
     * the ExternalService
     * @param pcReg reference for the PostalCodeRegistry
     * @return new instance of GeographicArea
     */
    public GeographicArea newGeographicArea(String designation, double cost,
            String strPC, double radius) {
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
        if (validationGeoArea(geoA)) {
            return addGeoArea(geoA);
        } else {
            return false;
        }

    }

    /**
     * Validates if the given GeographicArea instance alredy exists in the
     * geoAreaList.
     *
     * @param geoA GeographicArea instance to validate.
     * @return true if an equal instance of GeoArea is not found in the list
     * otherwise returns false
     */
    private boolean validationGeoArea(GeographicArea geoA) {
        for (GeographicArea geographicArea : geoAreaList) {
            if (geographicArea.equals(geoA)) {
                return false;
            }
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

}
