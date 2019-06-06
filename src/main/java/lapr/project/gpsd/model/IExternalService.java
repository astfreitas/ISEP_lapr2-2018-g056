/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;

/**
 *
 * @author astfr
 */
public interface IExternalService {
    
    public List<Location> getActsOnLocationList(String pCode, double radius);
    
    public boolean checkPostalCodeExist(String cp);
    
}