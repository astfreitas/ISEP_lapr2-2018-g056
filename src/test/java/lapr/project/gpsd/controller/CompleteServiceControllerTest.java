package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;
import static lapr.project.gpsd.utils.Constants.CONCLUDED_ORDER;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CompleteServiceControllerTest {
    
    public CompleteServiceControllerTest() {
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("10001@companylda.com", "password");
        Company company = ApplicationGPSD.getInstance().getCompany();
        
        //Pending service Orders
        ServiceProvider apadrao = company.getServiceProviderRegistry().getServiceProviderByNumber(10001);
        ServiceRequest servReq1 = company.getServiceRequestRegistry().getServiceRequestByNumber(1);
        ServiceRequestDescription servRD1 = servReq1.getServiceRequestDescriptions().get(0);
        SchedulePreference schedPref1 = servReq1.getSchedulePreferences().get(1);
        ServiceAssignment sa1 = new ServiceAssignment(apadrao, servRD1, servReq1, schedPref1);
        company.getServiceAssignementRegistry().addServiceAssignment(sa1);
        ServiceAssignment sa2 = new ServiceAssignment(apadrao, servRD1, servReq1, schedPref1);
        company.getServiceAssignementRegistry().addServiceAssignment(sa2);
        ServiceOrder so = company.getServiceOrderRegistry().registerServiceOrder(sa1);
        so.getStatus().setServOrderStatus(Constants.PENDING_ORDER);
        ServiceOrder so2 = company.getServiceOrderRegistry().registerServiceOrder(sa2);
        so2.getStatus().setServOrderStatus(Constants.PENDING_ORDER);
        
        
    }
    
    /**
     * Test of getPendingServiceOrders method, of class CompleteServiceController.
     */
    @Test
    public void testGetPendingServiceOrders() {
        System.out.println("getPendingServiceOrders");
        CompleteServiceController instance = new CompleteServiceController();
        ServiceOrder pendingOrders = instance.getPendingServiceOrders().get(0);
        String expResult = "10001@companylda.com";
        String result = pendingOrders.getServiceProvider().getEmail();
        assertEquals(expResult, result);        
    }

    /**
     * Test of concludeServiceOrder method, of class CompleteServiceController.
     */
    @Test
    public void testConcludeServiceOrder() {
        System.out.println("concludeServiceOrder");
        CompleteServiceController instance = new CompleteServiceController();
        ServiceOrder so = instance.getPendingServiceOrders().get(0);
        instance.setServOrder(so);
        int nrServiceOrder = instance.getPendingServiceOrders().size();
        instance.concludeServiceOrder();
        int expResult = nrServiceOrder - 1;
        int result = instance.getPendingServiceOrders().size();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setServOrder method, of class CompleteServiceController.
     */
    @Test
    public void testSetServOrder() {
        System.out.println("setServOrder");
        CompleteServiceController instance = new CompleteServiceController();
        ServiceOrder servOrder = instance.getPendingServiceOrders().get(0);
        instance.setServOrder(servOrder);
        instance.getServOrder().getServiceProvider().getEmail();
        String expResult = "10001@companylda.com";
        String result = instance.getServOrder().getServiceProvider().getEmail();        
    }

    /**
     * Test of getServOrder method, of class CompleteServiceController.
     */
    @Test
    public void testGetServOrder() {
        System.out.println("getServOrder");
        CompleteServiceController instance = new CompleteServiceController();
        List<ServiceOrder> servOrders = instance.getPendingServiceOrders();
        ServiceOrder so = servOrders.get(0);
        instance.setServOrder(so);
        ServiceOrder expResult = so;
        ServiceOrder result = instance.getServOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of concludeServiceOrderWithIssue method, of class CompleteServiceController.
     */
    @Test
    public void testConcludeServiceOrderWithIssue() {
        System.out.println("concludeServiceOrderWithIssue");
        String issue = "service test had a big issue";
        CompleteServiceController instance = new CompleteServiceController();
        List<ServiceOrder> servOrders = instance.getPendingServiceOrders();
        ServiceOrder so = servOrders.get(0);
        instance.setServOrder(so);
        instance.concludeServiceOrderWithIssue(issue);
        String expResult = Constants.CONCLUDED_ORDER;
        String result = so.getStatus().getServOrderStatus();
        assertEquals(expResult, result);
    }
    
}
