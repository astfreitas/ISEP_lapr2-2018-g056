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
    
    
}
