/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class SPGeographicAreaList {

    private List<GeographicArea> geoAreaList;

    /**
     * 
     * Creates an instance of SPGeographicAreaList
     */
    public SPGeographicAreaList() {
        geoAreaList = new ArrayList<>();
    }

    /**
     * Returns the GeoAreas list
     * @return GeoAreas list
     */
    public List<GeographicArea> getGeoAreaList() {
        return geoAreaList;
    }

    /**
     * validates if area is already in registry
     *
     * @param area
     * @return false if area is already in registry. true if it is not
     */
    public boolean validateArea(GeographicArea area) {
        if (geoAreaList.contains(area)) {
            return false;
        }
        return true;
    }

    /**
     * Removes a GeoArea from the registry
     * @param area GeoArea
     * @return success of the operation
     */
    public boolean removeGeographicArea(GeographicArea area) {
        return geoAreaList.remove(area);
    }

    /**
     * 
     * Adds a GeoArea to the registry
     * @param area GeoArea
     * @return success of the operation
     */
    public boolean addGeographicArea(GeographicArea area) {
        if(validateArea(area)) {
            return geoAreaList.add(area);
        }
        return false;
    }

    /**
     * 
     * Returns the SPGeographicAreaList info
     * @return SPGeographicAreaList info
     */
    @Override
    public String toString() {
        String text = "";
        for(GeographicArea area : geoAreaList) {
            text += area.toString() + "\n";
        }
        return text;
    }
    
    

}
