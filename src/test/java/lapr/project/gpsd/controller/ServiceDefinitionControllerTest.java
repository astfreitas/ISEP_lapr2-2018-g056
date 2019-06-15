package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.ExtendableService;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

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
    @Test //ToDo check
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
    @Test //ToDo check
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
    @Test //ToDo check
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
    @Test //ToDo check
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
    @Test //ToDo check
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
    @Test
    public void testNewService() {
        System.out.println("newService");
        String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        instance.setServiceType("1");
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
     * Test of validate method, of class ServiceDefinitionController with a return false result.
     */
    @Test
    public void testValidateFailed() {
        System.out.println("validate");
        ServiceDefinitionController instance = new ServiceDefinitionController();
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validate method, of class ServiceDefinitionController with a 
     * return true result.
     */
    @Disabled
    public void testValidateSuccess() {
        System.out.println("validate");
        String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setServiceType("1");
        boolean booleanNewService = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        System.out.println("NewServiceBeforeValidate: "+booleanNewService);
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of registerService method, of class ServiceDefinitionController.
     */
    @Test
    public void testRegisterServiceSucess() {
        System.out.println("registerService Success");
        String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setServiceType("1");
        boolean booleanNewService = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        System.out.println("NewService Before Register Test: "+ booleanNewService);
        boolean expResult = true;
        boolean result = instance.registerService();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of registerService method, of class ServiceDefinitionController.
     */
    @Test
    public void testRegisterServiceFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
        System.out.println("registerService Failed test w Exception");
        String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setServiceType("1");
        boolean booleanNewService = instance.newService(id, "", "", hourlyCost, catId);
        System.out.println("NewService Before Register Test: "+ booleanNewService);
        boolean expResult = false;
        boolean result = instance.registerService();
//        assertEquals(expResult, result);
        });
    }

    /**
     * Test of getService method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setServiceType("1");
        boolean booleanNewService = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        System.out.println("NewService Before Get Service Test: "+ booleanNewService);
        
        Object expResult = ExtendableService.class;
        Object result = instance.getService().getClass();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getService method, of class ServiceDefinitionController.
     */
    @Test
    public void testGetServiceNotSameClass() {
        System.out.println("getService test diferent calss");
        String id = "1";
        String bDesc = "Light pluming";
        String fDesc = "Install water tap";
        double hourlyCost = 100;
        String catId = "1";
        ServiceDefinitionController instance = new ServiceDefinitionController();
        instance.setServiceType("1");
        boolean booleanNewService = instance.newService(id, bDesc, fDesc, hourlyCost, catId);
        System.out.println("NewService Before Get Service Test: "+ booleanNewService);
        Object expResult = FixedService.class;
        Object result = instance.getService().getClass();
        assertNotEquals(expResult, result);
    }

}
