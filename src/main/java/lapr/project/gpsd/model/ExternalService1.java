/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;

/**
 * External Service classe is responsible to obtain all locations from a external
 * file with postalCodes and coordinates 
 * @author astfr
 */
public class ExternalService1 implements IExternalService{

    @Override
    public List<Location> getActsOnLocationList(String pCode, double radius) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkPostalCodeExist(String cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
