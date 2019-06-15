package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.GeographicArea;
import lapr.project.gpsd.model.SPApplication;
import lapr.project.gpsd.model.ServiceProvider;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class RegisterServiceProviderControllerTest {

    Company company;

    public RegisterServiceProviderControllerTest() {
        this.company = ApplicationGPSD.getInstance().getCompany();
        System.out.println(company.getServiceProviderRegistry().getServiceProviders());
        ApplicationGPSD.getInstance().bootstrap();
    }

    /**
     * Test of getApplicationData method, of class
     * RegisterServiceProviderController.
     */
    @Test
    public void testGetApplicationData_False() {
        System.out.println("getApplicationData_False");
        String nif = "ZZZ";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("1A", "1A", "1A", "1A");
        company.getSPApplicationRegistry().registerApplication(app);
        boolean expResult = false;
        boolean result = instance.getApplicationData(nif);
        assertEquals(expResult, result);
    }

    /**
     * Test of getApplicationData method, of class
     * RegisterServiceProviderController.
     */
    @Test
    public void testGetApplicationData_True() {
        System.out.println("getApplicationData_True");
        String nif = "1B";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("1B", "1B", "1B", "1B");
        company.getSPApplicationRegistry().registerApplication(app);
        boolean expResult = true;
        boolean result = instance.getApplicationData(nif);
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class
     * RegisterServiceProviderController.
     */
    @Test
    public void testNewServiceProvider_False() {
        System.out.println("newServiceProvider_False");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("2A", "2A", "2A", "2A");
        company.getSPApplicationRegistry().registerApplication(app);
        instance.getApplicationData("2A");
        boolean expResult = false;
        ServiceProvider sp = new ServiceProvider("2A", "2A", "4000-007", "2A");
        company.getServiceProviderRegistry().addServiceProvider(sp);
        boolean result = instance.newServiceProvider("2A", "2A", "4000-007", "2A");
        assertEquals(expResult, result);
    }

    /**
     * Test of newServiceProvider method, of class
     * RegisterServiceProviderController.
     */
    @Test
    public void testNewServiceProvider_True() {
        System.out.println("newServiceProvider_True");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("2B", "2B", "2B", "2B");
        company.getSPApplicationRegistry().registerApplication(app);
        instance.getApplicationData("2B");
        boolean expResult = true;
        boolean result = instance.newServiceProvider("2B", "2B", "4000-007", "2B");
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class RegisterServiceProviderController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<Category> expResult = company.getCategoryRegistry().getCategories();
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSPCategories method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPCategories() {
        System.out.println("getSPCategories");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("3A", "3A", "3A", "3A");
        company.getSPApplicationRegistry().registerApplication(app);
        instance.getApplicationData("3A");
        instance.newServiceProvider("3A", "3A", "4000-007", "3A");
        instance.registerServiceProvider();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviderByEmail("3A");
        Category cat1 = new Category("3A", "3A");
        Category cat2 = new Category("3AA", "3AA");
        sp.addCategory(cat1);
        sp.addCategory(cat2);
        List<Category> expResult = new ArrayList<Category>() {
            {
                add(cat1);
                add(cat2);
            }
        };
        List<Category> result = instance.getSPCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testAddCategory_False() {
        System.out.println("addCategory_False");
        String catId = "4A";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("4A", "4A", "4A", "4A");
        company.getSPApplicationRegistry().registerApplication(app);
        instance.getApplicationData("4A");
        instance.newServiceProvider("4A", "4A", "4000-007", "4A");
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviderByEmail("4A");
        Category cat1 = new Category("4A", "4A");
        sp.addCategory(cat1);
        boolean expResult = false;
        boolean result = instance.addCategory(catId);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class RegisterServiceProviderController.
     */
    @Test
    public void testAddCategory_True() {
        System.out.println("addCategory_True");
        String catId = "4B";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        SPApplication app = new SPApplication("4B", "4B", "4B", "4B");
        company.getSPApplicationRegistry().registerApplication(app);
        instance.getApplicationData("4B");
        instance.newServiceProvider("4B", "4B", "4000-007", "4B");
        Category cat1 = new Category("4B", "4B");
        company.getCategoryRegistry().addCategory(cat1);
        boolean expResult = true;
        boolean result = instance.addCategory(catId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeographicAreas method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetGeographicAreas() {
        System.out.println("getGeographicAreas");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<GeographicArea> expResult = null;
        List<GeographicArea> result = instance.getGeographicAreas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPGeographicAreas method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPGeographicAreas() {
        System.out.println("getSPGeographicAreas");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<GeographicArea> expResult = null;
        List<GeographicArea> result = instance.getSPGeographicAreas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGeographicArea method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testAddGeographicArea() {
        System.out.println("addGeographicArea");
        String geoId = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = false;
        boolean result = instance.addGeographicArea(geoId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerServiceProvider method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testRegisterServiceProvider() {
        System.out.println("registerServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        boolean expResult = false;
        boolean result = instance.registerServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceProvider method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        ServiceProvider expResult = null;
        ServiceProvider result = instance.getServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringServiceProvider method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testToStringServiceProvider() {
        System.out.println("toStringServiceProvider");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.toStringServiceProvider();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testGetName() {
        System.out.println("getName");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testGetAddress() {
        System.out.println("getAddress");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApplications method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetApplications() {
        System.out.println("getApplications");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        List<String> expResult = null;
        List<String> result = instance.getApplications();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPName method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPName() {
        System.out.println("getSPName");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getSPName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPAddress method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPAddress() {
        System.out.println("getSPAddress");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getSPAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPPostalCode method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPPostalCode() {
        System.out.println("getSPPostalCode");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getSPPostalCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSPLocal method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSPLocal() {
        System.out.println("getSPLocal");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getSPLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSPCategory method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testRemoveSPCategory() {
        System.out.println("removeSPCategory");
        String catId = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.removeSPCategory(catId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSPArea method, of class RegisterServiceProviderController.
     */
    @Disabled
    public void testRemoveSPArea() {
        System.out.println("removeSPArea");
        String areaId = "";
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        instance.removeSPArea(areaId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuccessMessage method, of class
     * RegisterServiceProviderController.
     */
    @Disabled
    public void testGetSuccessMessage() {
        System.out.println("getSuccessMessage");
        RegisterServiceProviderController instance = new RegisterServiceProviderController();
        String expResult = "";
        String result = instance.getSuccessMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
