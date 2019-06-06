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
public class ServiceProviderRegistry {
    
    private List<ServiceProvider> spList;

    public List<ServiceProvider> getServiceProviders() {
        return spList;
    }
    
    public ServiceProvider getServiceProviderByEmail(String email) {
        return null;
        // to-do
    }
    
    public List<Double> getAverageRatings() {
        return null;
        // to-do
    }
    
    
}
