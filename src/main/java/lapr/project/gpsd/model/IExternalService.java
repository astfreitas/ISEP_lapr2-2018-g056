/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author astfr
 */
public interface IExternalService {

    /**
     * Returns a List of Locations within the given radius for the Geographic
     * Area.
     *
     * @param pCode Main (center) Postal Code of the Geographic Area
     * @param radius radius for the area of activity of the Geographic Area
     * @param pcRegistry reference for the PostalCodeRegistry to obtain the
     * PostalCodeList
     * @return List of Locations within the given radius for the Geographic Area
     */
    public List<Location> getActsOnLocationList(PostalCode pCode, double radius,
            PostalCodeRegistry pcRegistry);

    /**
     * Returns a List of existing Postal Codes to the system
     *
     * @return Postal Code List
     */
    public List<PostalCode> loadPostalCodeRegistry() throws IOException;

}
