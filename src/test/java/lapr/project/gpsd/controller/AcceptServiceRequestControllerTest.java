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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AcceptServiceRequestControllerTest {
    
    public AcceptServiceRequestControllerTest() {
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        Company company = ApplicationGPSD.getInstance().getCompany();
        ClientRegistry cr = company.getClientRegistry();
        ServiceRequestRegistry srr = company.getServiceRequestRegistry();
        ServiceRegistry servR = company.getServiceRegistry();
        ServiceAssignmentRegistry sar = company.getServiceAssignementRegistry();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        Client cli = cr.getClientByEmail("msantos@gmail.com");
        ServiceRequest sr1 = srr.newServiceRequest(cli, cli.getAddresses().get(0));
        sr1.addSchedulePreference(LocalDate.of(2020, 6, 5), LocalTime.of(11, 0));
        sr1.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        srr.registerServiceRequest(sr1);
        sr1.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        ServiceProvider sprov = spr.getServiceProviderByNif("500324896");
        ServiceAssignment servA = new ServiceAssignment(sprov, sr1.getServiceRequestDescriptions().get(0), sr1, sr1.getSchedulePreferences().get(0));
        ServiceRequest sr2 = srr.newServiceRequest(cli, cli.getAddresses().get(0));
        sr2.addSchedulePreference(LocalDate.of(2020, 6, 5), LocalTime.of(11, 0));
        sr2.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        srr.registerServiceRequest(sr2);
        sr2.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        ServiceAssignment servB = new ServiceAssignment(sprov, sr2.getServiceRequestDescriptions().get(0), sr2, sr2.getSchedulePreferences().get(0));
        sar.addServiceAssignment(servA);
        sar.addServiceAssignment(servB);
    }
    /**
     * Test of checkAssignedServiceRequests method, of class AcceptServiceRequestController.
     */
    @Disabled
    public void testCheckAssignedServiceRequests() {
        System.out.println("checkAssignedServiceRequests");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();  
        List<Integer> srids = instance.checkAssignedServiceRequests();
        int expResult = 2;
        int result = srids.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkServiceAssignments method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckServiceAssignments() {
        System.out.println("checkServiceAssignments");
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
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
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
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        int expResult = instance.checkAssignedServiceRequests().size() - 1;
        int serviceNumber = instance.checkAssignedServiceRequests().get(0);
        instance.checkServiceAssignments(serviceNumber);
        instance.acceptServiceAssignment();
        int result = instance.checkAssignedServiceRequests().size();
        assertEquals(expResult, result);
    }
    
}
