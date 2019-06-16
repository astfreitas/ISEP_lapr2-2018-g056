package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CreateServiceRequestControllerTest {
    
    public CreateServiceRequestControllerTest() {
        ApplicationGPSD.getInstance().bootstrap();
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of newRequest method, of class CreateServiceRequestController.
     */
    @Test
    public void testNewRequest() {
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        System.out.println("newRequest");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        String expResult = "4420-001";
        String result = instance.newRequest().get(0).getPostalCode().getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class CreateServiceRequestController.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        ClientRegistry cr = ApplicationGPSD.getInstance().getCompany().getClientRegistry();
        String email = ApplicationGPSD.getInstance().getCurrentSession().getUserEmail();
        Client cli = cr.getClientByEmail(email);
        instance.setAddress(lAddresses.get(0));        
        ServiceRequest expResult = new ServiceRequest(cli, lAddresses.get(0));
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        
        String expResult = "1";
        String result = categories.get(0).getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServicesFromCategory method, of class CreateServiceRequestController.
     */
    @Test
    public void testGetServicesFromCategory() {
        System.out.println("getServicesFromCategory");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        String idCat = categories.get(0).getCode();
        String expResult = categories.get(0).getCode();
        String result = instance.getServicesFromCategory(idCat).get(0).getCategory().getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of addServiceRequestDescription method, of class CreateServiceRequestController.
     */
    @Test
    public void testAddServiceRequestDescription() {
        System.out.println("addServiceRequestDescription");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        List<Service> services = instance.getServicesFromCategory(categories.get(0).getCode());
        String idServ = services.get(0).getId();
        String desc = "zz";
        int dur = 30;
        boolean expResult = true;
        boolean result = instance.addServiceRequestDescription(idServ, desc, dur);
        assertEquals(expResult, result);
        String idServ2 = "bad service id";
        String desc2 = "zz";
        int dur2 = 0;
        boolean expResult2 = false;
        boolean result2 = instance.addServiceRequestDescription(idServ2, desc2, dur2);
        assertEquals(expResult, result);        
        //bad service duration
        String idServ3 = services.get(0).getId();
        String desc3 = "zz";
        int dur3 = -1;
        boolean expResult3 = false;
        boolean result3 = instance.addServiceRequestDescription(idServ3, desc3, dur3);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSchedulePreference method, of class CreateServiceRequestController.
     */
    @Test
    public void testAddSchedulePreference() {
        System.out.println("addSchedulePreference");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        List<Service> services = instance.getServicesFromCategory(categories.get(0).getCode());
        String idServ = services.get(0).getId();
        LocalDate date = LocalDate.of(2019, 6, 18);
        LocalTime time = LocalTime.of(10, 0);
        instance.addSchedulePreference(date, time);
        LocalDateTime expResult = LocalDateTime.of(date, time);
        LocalDateTime result = instance.getServiceRequest().getSchedulePreferences().get(0).getDateTime();
        assertEquals(expResult, result);        
    }

    /**
     * Test of validate method, of class CreateServiceRequestController.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        List<Service> services = instance.getServicesFromCategory(categories.get(0).getCode());
        String idServ = services.get(0).getId();
        LocalDate date = LocalDate.of(2019, 6, 18);
        LocalTime time = LocalTime.of(10, 0);
        instance.addServiceRequestDescription(idServ, "..", 30);        
        instance.addSchedulePreference(date, time);
        boolean expResult = true;
        boolean result = instance.validate();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getTravelExpenses method, of class CreateServiceRequestController.
     */
    @Disabled
    public void testGetTravelExpenses() {
        System.out.println("getTravelExpenses");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        double expResult = 0.0;
        double result = instance.getTravelExpenses();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getTotalCost method, of class CreateServiceRequestController.
     */
    @Disabled
    public void testGetTotalCost() {
        System.out.println("getTotalCost");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        double expResult = 0.0;
        double result = instance.getTotalCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of registerRequest method, of class CreateServiceRequestController.
     */
    @Disabled
    public void testRegisterRequest() {
        System.out.println("registerRequest");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        CreateServiceRequestController instance = new CreateServiceRequestController();
        List<Address> lAddresses = instance.newRequest();
        instance.setAddress(lAddresses.get(0));
        List<Category> categories = instance.getCategories();
        List<Service> services = instance.getServicesFromCategory(categories.get(0).getCode());
        String idServ = services.get(0).getId();
        LocalDate date = LocalDate.of(2019, 6, 18);
        LocalTime time = LocalTime.of(10, 0);
        instance.addServiceRequestDescription(idServ, "..", 30);        
        instance.addSchedulePreference(date, time);
        int expResult = ApplicationGPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequests().size() + 1;
        instance.registerRequest();
        int result = ApplicationGPSD.getInstance().getCompany().getServiceRequestRegistry().getServiceRequests().size();
        assertEquals(expResult, result);
    }
    
}
