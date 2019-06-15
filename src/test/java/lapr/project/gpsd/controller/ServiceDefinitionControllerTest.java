package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ExtendableService;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author astfr
 */
public class ServiceDefinitionControllerTest {

    private ApplicationGPSD app;

    /**
     * Initiating the GPSD aaplication and bootstrap to login with correct
     * permissions
     */
    public ServiceDefinitionControllerTest() {
        this.app = ApplicationGPSD.getInstance();
        app.bootstrap();
        System.out.println("Login state: " + ApplicationGPSD.getInstance().doLogin("adm1@isep.ipp.pt", "123"));
    }

    /**
     * Test of getServiceTypes method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetServiceTypes() {
        System.out.println("getServiceTypes");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<ServiceType> expResult = app.getCompany().getServiceTypeRegistry().getServiceTypes();
        List<ServiceType> result = instance.getServiceTypes();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceTypeByID method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetServiceTypeByID() {
        System.out.println("getServiceTypeByID");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        String idType =instance.getServiceTypes().get(1).getId();
        ServiceType expResult = instance.getServiceTypes().get(1);
        ServiceType result = instance.getServiceTypeByID(idType);
        assertEquals(expResult, result);
    }

    /**
     * Test of setServiceType method, of class ServiceDefinitionController.
     */
    @Test
    public void testSetServiceType() {
        System.out.println("setServiceType");
        String idType = "99";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.setServiceType(idType);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setServiceType method, of class ServiceDefinitionController.
     */
    @Test
    public void testSetServiceType2() {
        System.out.println("setServiceType - true expected");
        String idType = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = true;
        boolean result = instance.setServiceType(idType);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getCategories method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<Category> expResult = app.getCompany().getCategoryRegistry().getCategories();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of newService method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testNewService() {
        System.out.println("newService");
        String id = "";
        String bDesc = "";
        String fDesc = "";
        double hourlyCost = 0.0;
        String catId = "";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherAttributes method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testGetOtherAttributes() {
        System.out.println("getOtherAttributes");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        List<String> expResult = null;
        List<String> result = instance.getOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setAdditionalData(data);
    }

    /**
     * Test of validate method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testValidate() {
        System.out.println("validate");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerService method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testRegisterService() {
        System.out.println("registerService");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.registerService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getService method, of class ServiceDefinitionController.
     */
    @Disabled
    public void testGetService() {
        System.out.println("getService");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        Service expResult = null;
        Service result = instance.getService();
        assertEquals(expResult, result);
    }

}
