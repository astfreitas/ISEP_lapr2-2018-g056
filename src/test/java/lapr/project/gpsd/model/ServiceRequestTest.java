package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceRequestTest {

    /**
     * Test of setNumber method, of class ServiceRequest.
     */
    @Disabled
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        ServiceRequest instance = null;
        instance.setNumber(number);

    }

    /**
     * Test of addServiceRequestDescription method, of class ServiceRequest.
     */
    @Test
    public void testAddServiceRequestDescription() {
        System.out.println("addServiceRequestDescription");
        Service service = new FixedService("Serv1", "DescriptionTeste", "FullDescriptionTeste", 150, new Category("cat1", "categoryTeste"));
        String desc = "ServDescTest";
        int dur = 2;
        ApplicationGPSD testApp = new ApplicationGPSD();
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        boolean expResult = false;
        boolean result = instance.addServiceRequestDescription(service, desc, dur);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSchedulePreferenceString method, of class ServiceRequest.
     * //ToDo
     */
    @Test
    public void testAddSchedulePreference() {
        System.out.println("addSchedulePreference");
        LocalDate date = LocalDate.parse("2019-06-20");
        LocalTime time = LocalTime.parse("23:30");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        int iSize = instance.getSchedulePreferences().size();
        try {
            instance.addSchedulePreference(date, time);
        } catch (Exception e) {
            System.out.println("Error trying to add Schedule Pref");
        }
        int eSize = instance.getSchedulePreferences().size();
        boolean result = false;
        if (iSize < eSize) {
            result = true;
        }
        Assertions.assertTrue(result);
//        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class ServiceRequest.
     */
    @Disabled
    public void testGetClient() {
        System.out.println("getClient");
        ServiceRequest instance = null;
        Client expResult = null;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherCost method, of class ServiceRequest.
     */
    @Disabled
    public void testGetOtherCost() {
        System.out.println("getOtherCost");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        double expResult = 0.0;
        double result = instance.getOtherCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateCost method, of class ServiceRequest. //ToDo - recheck
     * test
     */
    @Disabled
    public void testCalculateCost() {
        System.out.println("calculateCost");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        double expResult = 0; //Its the same as the given postal Code
        double result = instance.calculateCost();
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of validate method, of class ServiceRequest.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        boolean expResult = false;
        boolean result = instance.validate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class ServiceRequest.
     */
    @Disabled
    public void testGetNumber() {
        System.out.println("getNumber");
        ServiceRequest instance = null;
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class ServiceRequest.
     */
    @Disabled
    public void testGetTotal() {
        System.out.println("getTotal");
        ServiceRequest instance = null;
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getAddress method, of class ServiceRequest.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        Address expResult = new Address("localTest", "4000-007", "Test Street n2");
        Address result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequestDescriptions method, of class ServiceRequest.
     */
    @Disabled
    public void testGetServiceRequestDescriptions() {
        System.out.println("getServiceRequestDescriptions");
        ServiceRequest instance = null;
        List<ServiceRequestDescription> expResult = null;
        List<ServiceRequestDescription> result = instance.getServiceRequestDescriptions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSchedulePreferences method, of class ServiceRequest.
     */
    @Disabled
    public void testGetSchedulePreferences() {
        System.out.println("getSchedulePreferences");
        ServiceRequest instance = null;
        ArrayList<SchedulePreference> expResult = null;
        ArrayList<SchedulePreference> result = instance.getSchedulePreferences();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOtherCosts method, of class ServiceRequest.
     */
    @Disabled
    public void testGetOtherCosts() {
        System.out.println("getOtherCosts");
        ServiceRequest instance = null;
        ArrayList<OtherCost> expResult = null;
        ArrayList<OtherCost> result = instance.getOtherCosts();
        assertEquals(expResult, result);
    }

    /**
     * Test of fullyAssigned method, of class ServiceRequest.
     */
    @Test
    public void testFullyAssigned() {
        System.out.println("fullyAssigned");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        Service ser1 = new FixedService("Serv1", "DescriptionTeste", "FullDescriptionTeste", 150, new Category("cat1", "categoryTeste"));
        ServiceRequestDescription servDesc = new ServiceRequestDescription(ser1, "ServiceTesteDes", 2);
        servDesc.setAssigned("Assigned");
        boolean expResult = true;
        boolean result = instance.fullyAssigned();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTravelExpenses method, of class ServiceRequest.
     */
    @Disabled
    public void testGetTravelExpenses() {
        ApplicationGPSD.getInstance().getCompany();
        ApplicationGPSD.getInstance().bootstrap();
        System.out.println("getTravelExpenses");
        Address address = new Address("localTest", "4420-001", "Test Street n2");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), address);
        Service ser1 = new FixedService("Serv1", "DescriptionTeste", "FullDescriptionTeste", 150, new Category("cat1", "categoryTeste"));
        ServiceRequestDescription servDesc = new ServiceRequestDescription(ser1, "ServiceTesteDes", 2);
        instance.getServiceRequestDescriptions().add(servDesc);
        double expResult = 25;
        double result = instance.getTravelExpenses();
        assertEquals(expResult, result);
    }

    /**
     * Test of isExpired method, of class ServiceRequest.
     */
    @Test
    public void testIsExpired_True() {
        System.out.println("fullyAssigned");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        Service ser1 = new FixedService("Serv1", "DescriptionTeste", "FullDescriptionTeste", 150, new Category("cat1", "categoryTeste"));
        ServiceRequestDescription servDesc = new ServiceRequestDescription(ser1, "ServiceTesteDes", 2);
        LocalDate date = LocalDate.of(2019,6,1);
        LocalTime time = LocalTime.of(23,30);
        instance.addSchedulePreferenceString(date, time,"");
        boolean expResult = true;
        boolean result = instance.isExpired();
        assertEquals(expResult, result);
    }

    /**
     * Test of isExpired method, of class ServiceRequest.
     */
    @Test
    public void testIsExpired_False() {
        System.out.println("fullyAssigned");
        ServiceRequest instance = new ServiceRequest(new Client("ClientTest", "123456", "123456789", "default@defaultlda.com"), new Address("localTest", "4000-007", "Test Street n2"));
        Service ser1 = new FixedService("Serv1", "DescriptionTeste", "FullDescriptionTeste", 150, new Category("cat1", "categoryTeste"));
        ServiceRequestDescription servDesc = new ServiceRequestDescription(ser1, "ServiceTesteDes", 2);
        LocalDate date = LocalDate.MAX;
        LocalTime time = LocalTime.of(23,30);
        instance.addSchedulePreferenceString(date, time,"");
        boolean expResult = false;
        boolean result = instance.isExpired();
        assertEquals(expResult, result);
    }
}
