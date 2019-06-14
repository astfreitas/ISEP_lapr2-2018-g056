package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortRandomTest {
 
    /**
     * Test of sortServiceList method, of class SortRandom.
     */
    @Disabled
    public void testSortServiceList() {
        System.out.println("sortServiceList");
        Client cli0 = new Client("Cliente0", "502090210", "229046713", "client0@defaullda.com");
        Address addr0 = new Address("Address", "4000-008", "Street for testing purpose");
        
        ServiceRequest serReq0 = new ServiceRequest(cli0, addr0);
        Service ser0 = new FixedService("Serv0", "DescriptionTeste", 
                "FullDescriptionTeste", 150, 
                new Category("cat1", "categoryTeste"));
        Service ser1 = new FixedService("Serv1", "TestingServices", 
                "FullDescriptionTeste", 250, 
                new Category("cat3", "categoryTeste3"));
        Service ser2 = new FixedService("Serv2", "TestingServices 2", 
                "FullDescriptionTeste", 350, 
                new Category("cat4", "categoryTeste4"));
        Service ser3 = new FixedService("Serv3", "TestingServices 3", 
                "FullDescriptionTeste", 350, 
                new Category("cat6", "categoryTeste6"));
        ServiceRequestDescription servDesc0 = new ServiceRequestDescription(ser0, "ServiceRequesDescriptio - descri", 1);
        ServiceRequestDescription servDesc1 = new ServiceRequestDescription(ser1, "ServiceRequesDescriptio - descri", 2);
        ServiceRequestDescription servDesc2 = new ServiceRequestDescription(ser2, "ServiceRequesDescriptio - descri", 3);
        ServiceRequestDescription servDesc3 = new ServiceRequestDescription(ser3, "ServiceRequesDescriptio - descri", 4);
        
        List<ServiceRequestDescription> services = new ArrayList<>();
        services.add(servDesc0);
        services.add(servDesc1);
        services.add(servDesc2);
        services.add(servDesc3);
        SortingRandom instance = new SortingRandom();
        List<ServiceRequestDescription> sortedServices = new ArrayList<>();
        for (ServiceRequestDescription serv : services) {
            sortedServices.add(serv);
        }
        instance.sortServiceList(sortedServices);
        Assert.assertNotEquals(services, sortedServices);
    }
    
}
