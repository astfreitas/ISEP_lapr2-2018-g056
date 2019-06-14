/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class SortingFIFOTest {
  
    /**
     * Test of sortServiceList method, of class SortingFIFO.
     */
    @Disabled
    public void testSortServiceList() {
        System.out.println("sortServiceList");
        List<ServiceRequestDescription> services = null;
        SortingFIFO instance = new SortingFIFO();
        instance.sortServiceList(services);
    }
    
}
