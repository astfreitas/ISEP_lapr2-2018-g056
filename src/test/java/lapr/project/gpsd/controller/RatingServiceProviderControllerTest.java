/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import lapr.project.gpsd.model.Address;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.FixedService;
import lapr.project.gpsd.model.SchedulePreference;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceAssignment;
import lapr.project.gpsd.model.ServiceOrder;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceRequest;
import lapr.project.gpsd.model.ServiceRequestDescription;
import lapr.project.gpsd.utils.Constants;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingServiceProviderControllerTest {

    public RatingServiceProviderControllerTest() {
    }

    /**
     * Test of setServOrder method, of class RatingServiceProviderController.
     */
    @Test
    public void testSetServOrder() {
        System.out.println("setServOrder");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceOrder servOrder = new ServiceOrder(sa);
        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setServOrder(servOrder);
    }

    /**
     * Test of setServiceProvider method, of class
     * RatingServiceProviderController.
     */
    @Test
    public void testSetServiceProvider() {
        System.out.println("setServiceProvider");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = new Client("testCliName", "testCliNif", "testCliTel", "testCliEmail");
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ServiceOrder servOrder = new ServiceOrder(sa);

        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setServOrder(servOrder);
        instance.setServiceProvider();
    }

    /**
     * Test of getClientServices method, of class
     * RatingServiceProviderController.
     */
    @Test
    public void testGetClientServices() {
        System.out.println("getClientServices");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ArrayList<ServiceOrder> expResult = new ArrayList<>();
        ArrayList<ServiceOrder> result = instance.getClientServices();
        expResult.add(result.get(0));
        assertEquals(expResult.get(0), result.get(0));
    }

    /**
     * Test of getServiceProvider method, of class
     * RatingServiceProviderController.
     */
    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);

        ServiceOrder servOrder = servs.get(0);
        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider expResult = sp;
        ServiceProvider result = instance.getServiceProvider(servOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRating method, of class RatingServiceProviderController.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);

        int rating = 3;
        RatingServiceProviderController instance = new RatingServiceProviderController();
        instance.setServOrder(servs.get(0));
        instance.setServiceProvider();
        instance.setRating(rating);
    }

    /**
     * Test of getServiceDescription method, of class
     * RatingServiceProviderController.
     */
    @Test
    public void testGetServiceDescription() {
        System.out.println("getServiceDescription");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        ServiceRequestDescription expResult = srd;
        ServiceRequestDescription result = instance.getServiceDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClient method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        Client expResult = cli;
        Client result = instance.getClient();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceRequest method, of class
     * RatingServiceProviderController.
     */
    @Test
    public void testGetServiceRequest() {
        System.out.println("getServiceRequest");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        ServiceRequest expResult = sr;
        ServiceRequest result = instance.getServiceRequest();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServOrder method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServOrder() {
        System.out.println("getServOrder");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = new Category("testCode", "testDescCat");
        Service serv = new FixedService("testServID", "testServDesc", "testServFullDesc", 100, cat);
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        ServiceOrder expResult = servs.get(0);
        ServiceOrder result = instance.getServOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getServiceCost method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetServiceCost() {
        System.out.println("getServiceCost");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = ApplicationGPSD.getInstance().getCompany().getCategoryRegistry().getCatById("1");
        Service serv = ApplicationGPSD.getInstance().getCompany().getServiceRegistry().getServiceById("1");
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4000-007", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        double expResult = 100;
        double result = instance.getServiceCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTravelCost method, of class RatingServiceProviderController.
     */
    @Test
    public void testGetTravelCost() {
        System.out.println("getTravelCost");
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");

        RatingServiceProviderController instance = new RatingServiceProviderController();
        ServiceProvider sp = new ServiceProvider("testName", "testNIF", "testEmail", "testAbrevName");
        Category cat = ApplicationGPSD.getInstance().getCompany().getCategoryRegistry().getCatById("1");
        Service serv = ApplicationGPSD.getInstance().getCompany().getServiceRegistry().getServiceById("1");
        ServiceRequestDescription srd = new ServiceRequestDescription(serv, "testDesc", 60);
        Client cli = ApplicationGPSD.getInstance().getCompany().getClientRegistry().getClientByEmail(ApplicationGPSD.getInstance().getCurrentSession().getUserEmail());
        Address add = new Address("testLocal", "4420-001", "testAddress");
        ServiceRequest sr = new ServiceRequest(cli, add);
        sr.addServiceRequestDescription(serv, "testDesc", 60);
        sr.calculateCost();
        SchedulePreference schedPref = new SchedulePreference(0, LocalDate.of(2019, 6, 22), LocalTime.of(12, 0));
        ServiceAssignment sa = new ServiceAssignment(sp, srd, sr, schedPref);
        ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().registerServiceOrder(sa);
        ArrayList<ServiceOrder> servs = ApplicationGPSD.getInstance().getCompany().getServiceOrderRegistry().getPendingServiceOrdersByServiceProvider(Constants.PENDING_ORDER, sp);
        servs.get(0).getStatus().setServOrderStatus(Constants.CONCLUDED_ORDER);
        instance.setServOrder(servs.get(0));

        double expResult = 50;
        double result = instance.getTravelCost();
        assertEquals(expResult, result);
    }

}
