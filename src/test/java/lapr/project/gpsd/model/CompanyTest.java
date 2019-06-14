package lapr.project.gpsd.model;

import java.util.Properties;
import java.util.Timer;
import lapr.project.authentication.AuthenticationFacade;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {
    
    /**
     * Test of getServiceAssignementRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceAssignementRegistry() {
        System.out.println("getServiceAssignementRegistry");
        Company instance = null;
        ServiceAssignmentRegistry expResult = null;
        ServiceAssignmentRegistry result = instance.getServiceAssignementRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceOrderRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceOrderRegistry() {
        System.out.println("getServiceOrderRegistry");
        Company instance = null;
        ServiceOrderRegistry expResult = null;
        ServiceOrderRegistry result = instance.getServiceOrderRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceProviderRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceProviderRegistry() {
        System.out.println("getServiceProviderRegistry");
        Company instance = null;
        ServiceProviderRegistry expResult = null;
        ServiceProviderRegistry result = instance.getServiceProviderRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceRegistry() {
        System.out.println("getServiceRegistry");
        Company instance = null;
        ServiceRegistry expResult = null;
        ServiceRegistry result = instance.getServiceRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceRequestRegistry() {
        System.out.println("getServiceRequestRegistry");
        Company instance = null;
        ServiceRequestRegistry expResult = null;
        ServiceRequestRegistry result = instance.getServiceRequestRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicAreaRegistry method, of class Company.
     */
    @Disabled
    public void testGetGeographicAreaRegistry() {
        System.out.println("getGeographicAreaRegistry");
        Company instance = null;
        GeographicAreaRegistry expResult = null;
        GeographicAreaRegistry result = instance.getGeographicAreaRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientRegistry method, of class Company.
     */
    @Disabled
    public void testGetClientRegistry() {
        System.out.println("getClientRegistry");
        Company instance = null;
        ClientRegistry expResult = null;
        ClientRegistry result = instance.getClientRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileTypeRegistry method, of class Company.
     */
    @Disabled
    public void testGetFileTypeRegistry() {
        System.out.println("getFileTypeRegistry");
        Company instance = null;
        FileTypeRegistry expResult = null;
        FileTypeRegistry result = instance.getFileTypeRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryRegistry method, of class Company.
     */
    @Disabled
    public void testGetCategoryRegistry() {
        System.out.println("getCategoryRegistry");
        Company instance = null;
        CategoryRegistry expResult = null;
        CategoryRegistry result = instance.getCategoryRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSPApplicationRegistry method, of class Company.
     */
    @Disabled
    public void testGetSPApplicationRegistry() {
        System.out.println("getSPApplicationRegistry");
        Company instance = null;
        SPApplicationRegistry expResult = null;
        SPApplicationRegistry result = instance.getSPApplicationRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthenticationFacade method, of class Company.
     */
    @Disabled
    public void testGetAuthenticationFacade() {
        System.out.println("getAuthenticationFacade");
        Company instance = null;
        AuthenticationFacade expResult = null;
        AuthenticationFacade result = instance.getAuthenticationFacade();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignServiceTask method, of class Company.
     */
    @Disabled
    public void testAssignServiceTask() {
        System.out.println("assignServiceTask");
        Company instance = null;
        instance.assignServiceTask();
    }

    /**
     * Test of getServiceTypeRegistry method, of class Company.
     */
    @Disabled
    public void testGetServiceTypeRegistry() {
        System.out.println("getServiceTypeRegistry");
        Company instance = null;
        ServiceTypeRegistry expResult = null;
        ServiceTypeRegistry result = instance.getServiceTypeRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAssignmentAlgoritm method, of class Company.
     */
    @Disabled
    public void testGetAssignmentAlgoritm() {
        System.out.println("getAssignmentAlgoritm");
        Company instance = null;
        IAssignmentAlgoritm expResult = null;
        IAssignmentAlgoritm result = instance.getAssignmentAlgoritm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimer method, of class Company.
     */
    @Disabled
    public void testGetTimer() {
        System.out.println("getTimer");
        Company instance = null;
        Timer expResult = null;
        Timer result = instance.getTimer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProps method, of class Company.
     */
    @Disabled
    public void testGetProps() {
        System.out.println("getProps");
        Company instance = null;
        Properties expResult = null;
        Properties result = instance.getProps();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCodeRegistry method, of class Company.
     */
    @Disabled
    public void testGetPostalCodeRegistry() {
        System.out.println("getPostalCodeRegistry");
        Company instance = null;
        PostalCodeRegistry expResult = null;
        PostalCodeRegistry result = instance.getPostalCodeRegistry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExternalService method, of class Company.
     */
    @Disabled
    public void testGetExternalService() {
        System.out.println("getExternalService");
        Company instance = null;
        IExternalService expResult = null;
        IExternalService result = instance.getExternalService();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceSortingBehavior method, of class Company.
     */
    @Disabled
    public void testGetServiceSortingBehavior() {
        System.out.println("getServiceSortingBehavior");
        Company instance = null;
        ISortingBehavior expResult = null;
        ISortingBehavior result = instance.getServiceSortingBehavior();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignation method, of class Company.
     */
    @Disabled
    public void testGetDesignation() {
        System.out.println("getDesignation");
        Company instance = null;
        String expResult = "";
        String result = instance.getDesignation();
        assertEquals(expResult, result);
    }
    
}
