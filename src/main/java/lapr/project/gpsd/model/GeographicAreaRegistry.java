package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author astfr
 */
public class GeographicAreaRegistry {
    
    /**
     * List of Geographic Areas known by the company
     */
    private List<GeographicArea> geoAreaList = new ArrayList<>();
    /**
     * Method that returns nearest GeograficArea instance from a given postal code
     * @param postalCode
     * @return nearest GeograficArea instance from a given postal code
     */
    GeographicArea getNearestGeographicArea(PostalCode postalCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
