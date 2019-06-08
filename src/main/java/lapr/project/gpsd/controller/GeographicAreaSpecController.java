package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.GeographicAreaRegistry;
import lapr.project.gpsd.model.PostalCode;
import lapr.project.gpsd.model.PostalCodeRegistry;
import lapr.project.gpsd.utils.Constants;

/**
 *
 * @author astfr
 */
public class GeographicAreaSpecController {
    /**
     * Reference to the company instance
     */
    private Company company;
    /**
     * Reference to the GeoGraphicAreaRegistry instance saved in company
     */
    private GeographicAreaRegistry geoAreg;
    /**
     * GeographicArea instance to create, validate and add to the system.
     */
    private GeographicArea geoA;
    /**
     * Reference to Postal Code Registry instance
     */
    private PostalCodeRegistry pCodeReg;
    
    /**
     * Constructor for the GeographicAreaController. No parameters needed.
     * Verifies if the authenticated user has the correct permissions for this 
     * controller, if not throws IllegalStateException.
     */
    public GeographicAreaSpecController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.pCodeReg = company.getPostalCodeRegistry();
    }
    /**
     * Returns a new GeographicArea instance.
     * @param designation designation string
     * @param cost Travel Cost to this Geographic Area
     * @param strPC Postal Code string for the center of the GeoArea
     * @param radius Radius double for the area of action of the GeoArea
     * @return new GeographicArea instance
     */
    public GeographicArea newGeographicArea(String designation, double cost,
            String strPC, double radius) {
        geoAreg = company.getGeographicAreaRegistry();
        geoA = geoAreg.newGeographicArea(designation, cost, strPC, radius);
        return geoA;
    }
    
    /**
     * Registers the previous created GeographicArea by validating the instance
     * in the GeographicAreaRegistry and adding to the existing list.
     * @return True if the GeoArea instance was correctly added to the 
     * GeographicRegistry list
     */
    public boolean registerGeographicArea() {
        return geoAreg.registerGeographicArea(geoA);
    }
    
    public List<PostalCode> searchMatchPostalCode(String strPC){
        return pCodeReg.searchMatchPostalCode(strPC);
    }
}
