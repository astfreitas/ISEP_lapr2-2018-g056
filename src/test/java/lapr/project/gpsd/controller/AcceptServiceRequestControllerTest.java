/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.*;
import lapr.project.gpsd.utils.Constants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AcceptServiceRequestControllerTest {
    
    private static ServiceRequestRegistry serviceRequestRegistry;
    
    private static ServiceAssignmentRegistry serviceAssignmentRegistry;
    
    public AcceptServiceRequestControllerTest() {  
    }
    
    @BeforeAll
    public static void setUp() {
        ApplicationGPSD.getInstance().bootstrap();
        Company company = ApplicationGPSD.getInstance().getCompany();
        ClientRegistry cr = company.getClientRegistry();
        serviceRequestRegistry = company.getServiceRequestRegistry();
        ServiceRegistry servR = company.getServiceRegistry();
        serviceAssignmentRegistry = company.getServiceAssignementRegistry();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        Client cli = cr.getClientByEmail("msantos@gmail.com");
        ServiceProvider sprov = spr.getServiceProviderByNif("500324896");
        //Service1
        ServiceRequest serviceRequest1 = serviceRequestRegistry.newServiceRequest(cli, cli.getAddresses().get(0));
        serviceRequest1.addSchedulePreference(LocalDate.of(2020, 6, 5), LocalTime.of(11, 0));
        serviceRequest1.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        serviceRequestRegistry.registerServiceRequest(serviceRequest1);
        serviceRequest1.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        ServiceAssignment servA = new ServiceAssignment(sprov, serviceRequest1.getServiceRequestDescriptions().get(0), serviceRequest1, serviceRequest1.getSchedulePreferences().get(0));
        
        //Service2
        ServiceRequest serviceRequest2 = serviceRequestRegistry.newServiceRequest(cli, cli.getAddresses().get(0));
        serviceRequest2.addSchedulePreference(LocalDate.of(2020, 6, 5), LocalTime.of(11, 0));
        serviceRequest2.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        serviceRequestRegistry.registerServiceRequest(serviceRequest2);
        serviceRequest2.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        ServiceAssignment servB = new ServiceAssignment(sprov, serviceRequest2.getServiceRequestDescriptions().get(0), serviceRequest2, serviceRequest2.getSchedulePreferences().get(0));
        
        //Expired Service
        ServiceRequest expiredServiceRequest = serviceRequestRegistry.newServiceRequest(cli, cli.getAddresses().get(0));
        expiredServiceRequest.addSchedulePreference(LocalDate.of(2020, 7, 13), LocalTime.of(11, 0));
        expiredServiceRequest.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        serviceRequestRegistry.registerServiceRequest(expiredServiceRequest);
        expiredServiceRequest.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        SchedulePreference schedPref3 = new SchedulePreference(1, LocalDate.of(2015, 6, 13), LocalTime.of(11, 0), "");
        ServiceAssignment servC = new ServiceAssignment(sprov, expiredServiceRequest.getServiceRequestDescriptions().get(0), expiredServiceRequest, schedPref3);

        
        serviceAssignmentRegistry.addServiceAssignment(servA);
        serviceAssignmentRegistry.addServiceAssignment(servB);
        serviceAssignmentRegistry.addServiceAssignment(servC);
    }
    
    /**
     * Test of checkAssignedServiceRequests method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckAssignedServiceRequests() {
        System.out.println("checkAssignedServiceRequests");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();  
        List<Integer> srids = instance.checkAssignedServiceRequests();
        int srID = srids.get(srids.size() - 1);
        ServiceRequest lastAssignedSr = serviceRequestRegistry.getServiceRequestByNumber(srID);
        String expResult = "msantos@gmail.com";
        String result = lastAssignedSr.getClient().getEmail();        
        assertEquals(expResult, result);
    }

    /**
     * Test of checkServiceAssignments method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckServiceAssignment() {
        System.out.println("checkServiceAssignments");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        int serviceNumber = instance.checkAssignedServiceRequests().get(0);
        String expResult = "500324896";
        String result = instance.checkServiceAssignments(serviceNumber).get(0).getServiceProvider().getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of rejectServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Test
    public void testRejectServiceAssignment() {
        System.out.println("rejectServiceAssignment");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        System.out.println("YOU MUST BE KIDDING2 " + instance.checkAssignedServiceRequests().size());
        int expResult = instance.checkAssignedServiceRequests().size() - 1;
        int serviceNumber = instance.checkAssignedServiceRequests().get(0);
        instance.checkServiceAssignments(serviceNumber);
        instance.rejectServiceAssignment();
        int result = instance.checkAssignedServiceRequests().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of acceptServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Test
    public void testAcceptServiceAssignment() {
        System.out.println("acceptServiceAssignment");
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        int expResult = instance.checkAssignedServiceRequests().size() - 1;
        int serviceNumber = instance.checkAssignedServiceRequests().get(0);
        instance.checkServiceAssignments(serviceNumber);
        instance.acceptServiceAssignment();
        int result = instance.checkAssignedServiceRequests().size();
        assertEquals(expResult, result);
    }
    
}
