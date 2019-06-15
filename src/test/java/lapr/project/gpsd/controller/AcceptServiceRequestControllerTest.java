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
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of checkAssignedServiceRequests method, of class AcceptServiceRequestController.
     */
    @Test
    public void testCheckAssignedServiceRequests() {
        System.out.println("checkAssignedServiceRequests");
        
        ApplicationGPSD.getInstance().bootstrap();
        ApplicationGPSD.getInstance().doLogin("msantos@gmail.com", "prosdbsts190");
        
        Company company = ApplicationGPSD.getInstance().getCompany();
        ClientRegistry cr = company.getClientRegistry();
        ServiceRequestRegistry srr = company.getServiceRequestRegistry();
        ServiceRegistry servR = company.getServiceRegistry();
        ServiceAssignmentRegistry sar = company.getServiceAssignementRegistry();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        
        Client cli = cr.getClientByEmail("msantos@gmail.com");
        ServiceRequest sr = srr.newServiceRequest(cli, cli.getAddresses().get(0));
        
        sr.addSchedulePreference(LocalDate.of(2020, 6, 5), LocalTime.of(11, 0));
        sr.addServiceRequestDescription(servR.getServices().get(0), "teste", 1);
        srr.registerServiceRequest(sr);
        sr.getServiceRequestDescriptions().get(0).setAssigned(Constants.SERVICE_ASSIGNED);
        
        
        
        ServiceAssignment servA = new ServiceAssignment(spr.getServiceProviderByEmail("aPadrao@gmail.com"), sr.getServiceRequestDescriptions().get(0), sr, sr.getSchedulePreferences().get(0));
        sar.addServiceAssignment(servA);
        
        AcceptServiceRequestController instance = new AcceptServiceRequestController();  
        
        List<Integer> srids = instance.checkAssignedServiceRequests();

        int expResult = 1;
        int result = srids.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkServiceAssignments method, of class AcceptServiceRequestController.
     */
    @Disabled
    public void testCheckServiceAssignments() {
        System.out.println("checkServiceAssignments");
        int serviceNumber = 0;
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.checkServiceAssignments(serviceNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of rejectServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Disabled
    public void testRejectServiceAssignment() {
        System.out.println("rejectServiceAssignment");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        instance.rejectServiceAssignment();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of acceptServiceAssignment method, of class AcceptServiceRequestController.
     */
    @Disabled
    public void testAcceptServiceAssignment() {
        System.out.println("acceptServiceAssignment");
        AcceptServiceRequestController instance = new AcceptServiceRequestController();
        List<Integer> expResult = null;
        List<Integer> result = instance.acceptServiceAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
