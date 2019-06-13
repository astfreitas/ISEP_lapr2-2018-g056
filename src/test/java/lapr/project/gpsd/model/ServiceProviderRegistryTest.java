package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceProviderRegistryTest {

    /**
     * Test of newAddress method, of class ServiceProviderRegistry.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "";
        String postalCode = "";
        String address = "";
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        Address expResult = null;
        Address result = instance.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testNewServiceProvider() {
        System.out.println("newServiceProvider");
        String name = "";
        Address address = null;
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.newServiceProvider(name, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testValidateServiceProvider() {
        System.out.println("validateServiceProvider");
        ServiceProvider sp = null;
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = false;
        boolean result = instance.validateServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testAddServiceProvider() {
        System.out.println("addServiceProvider");
        ServiceProvider sp = null;
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = false;
        boolean result = instance.addServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testRegisterServiceProvider() {
        System.out.println("registerServiceProvider");
        ServiceProvider sp = null;
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = false;
        boolean result = instance.registerServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviderByEmail method, of class ServiceProviderRegistry.
     */
    @Test
    public void testGetServiceProviderByEmail() {
        System.out.println("getServiceProviderByEmail");
        String email = "";
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProviderByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviders method, of class ServiceProviderRegistry.
     */
    @Disabled
    public void testGetServiceProviders() {
        System.out.println("getServiceProviders");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.getServiceProviders();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAverageRatings method, of class ServiceProviderRegistry.
     */
    @Test
    public void testGetAverageRatings() {
        System.out.println("getAverageRatings");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        List<Double> expResult = null;
        List<Double> result = instance.getAverageRatings();
        assertEquals(expResult, result);
    }
    
}
