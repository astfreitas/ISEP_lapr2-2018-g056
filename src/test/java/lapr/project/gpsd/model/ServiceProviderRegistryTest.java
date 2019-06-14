package lapr.project.gpsd.model;

import java.util.ArrayList;
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
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        Address expResult = new Address("testLocal", "4000-007", "testAddress");
        Address result = instance.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testNewServiceProvider() {
        System.out.println("newServiceProvider");
        String name = "testName";
        Address address = new Address("testLocal", "4000-007", "testAddress");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        ServiceProvider expResult = new ServiceProvider("testName", new Address("testLocal", "4000-007", "testAddress"));
        ServiceProvider result = instance.newServiceProvider(name, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testValidateServiceProvider() {
        System.out.println("validateServiceProvider");
        ServiceProvider sp = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = true;
        boolean result = instance.validateServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testAddServiceProvider() {
        System.out.println("addServiceProvider");
        ServiceProvider sp  = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = true;
        boolean result = instance.addServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerServiceProvider method, of class ServiceProviderRegistry.
     */
    @Test
    public void testRegisterServiceProvider() {
        System.out.println("registerServiceProvider");
        ServiceProvider sp = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        boolean expResult = true;
        boolean result = instance.registerServiceProvider(sp);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviderByEmail method, of class ServiceProviderRegistry.
     */
    @Disabled
    public void testGetServiceProviderByEmail() {
        System.out.println("getServiceProviderByEmail");
        String email = "testEmail";
        ServiceProvider sp = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        instance.addServiceProvider(sp);
        ServiceProvider expResult = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
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
        ServiceProvider sp = new ServiceProvider("testName", "testNif", "testEmail", "testAbreName");
        Evaluation eval = new Evaluation(5, null);
        sp.addEvaluation(eval);
        sp.recalculateAverage();
        ServiceProviderRegistry instance = new ServiceProviderRegistry();
        instance.addServiceProvider(sp);
        List<Double> expResult = new ArrayList<>();
        expResult.add((double) 4);
        List<Double> result = instance.getAverageRatings();
        assertEquals(expResult, result);
    }
}
