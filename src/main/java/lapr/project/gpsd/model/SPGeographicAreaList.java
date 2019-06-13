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

    public SPGeographicAreaList() {
        geoAreaList = new ArrayList<>();
    }

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

    public boolean removeGeographicArea(GeographicArea area) {
        return geoAreaList.remove(area);
    }

    public boolean addGeographicArea(GeographicArea area) {
        if(validateArea(area)) {
            geoAreaList.add(area);
        }
        return false;
    }

}
