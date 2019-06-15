
package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssignmentAlgoritm1Test {

    private ServiceRequestDescription serviceDescription;
    private Company company;
    
    public AssignmentAlgoritm1Test() {
        this.company = ApplicationGPSD.getInstance().getCompany();
        company.getServiceRegistry().addService(null);
        company.getServiceProviderRegistry().getServiceProviders().clear(); // clear list of SPs
        ServiceProvider A = new ServiceProvider("A", "nif", "A", "abrev");
        ServiceProvider B = new ServiceProvider("B", "nif", "B", "abrev");
        ServiceProvider C = new ServiceProvider("C", "nif", "C", "abrev");
        ServiceProvider D = new ServiceProvider("D", "nif", "D", "abrev");
        company.getServiceProviderRegistry().addServiceProvider(D);
        company.getServiceProviderRegistry().addServiceProvider(C);
        company.getServiceProviderRegistry().addServiceProvider(B);
        company.getServiceProviderRegistry().addServiceProvider(A);
        A.addEvaluation(new Evaluation(0));
        B.addEvaluation(new Evaluation(1));
        C.addEvaluation(new Evaluation(1));
        D.addEvaluation(new Evaluation(1));
        PostalCode P1 = company.getPostalCodeRegistry().getMatchingPostalCode("4000-015"); // request
        PostalCode P2 = company.getPostalCodeRegistry().getMatchingPostalCode("4300-420"); // near
        PostalCode P3 = company.getPostalCodeRegistry().getMatchingPostalCode("5040-011"); // far
        A.setSpAddress(new Address("1", P2.getPostalCode(), "1"));
        B.setSpAddress(new Address("1", P3.getPostalCode(), "1"));
        C.setSpAddress(new Address("1", P2.getPostalCode(), "1"));
        D.setSpAddress(new Address("1", P2.getPostalCode(), "1"));
        Client cli = new Client("cli", "1", "1", "1");
        Address address = new Address("1", "4000-015", "1");
        ServiceRequest request = new ServiceRequest(cli, address);
        Service service = company.getServiceRegistry().getServices().get(0);
        request.addServiceRequestDescription(service, "a", 10);
        company.getServiceRequestRegistry().addServiceRequest(request);
        this.serviceDescription = request.getServiceRequestDescriptions().get(0);
    }

    /**
     * Test of assignServices method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testAssignServices() {
        System.out.println("assignServices");
        List<ServiceRequestDescription> services = null;
        ISortingBehavior sortingBehavior = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.assignServices(services, sortingBehavior);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuitableSPList method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testGetSuitableSPList() {
    }

    /**
     * Test of selectMostSuitableSP method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testSelectMostSuitableSP() {
        System.out.println("selectMostSuitableSP");
        ServiceRequestDescription srd = this.serviceDescription;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        instance.assignServices(new ArrayList<>(), new SortingFIFO());
        ServiceProvider expResult = company.getServiceProviderRegistry().getServiceProviderByEmail("C");
        List<ServiceProvider> suitableSPs = company.getServiceProviderRegistry().getServiceProviders();
        ServiceProvider result = instance.selectMostSuitableSP(suitableSPs, srd);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByCategory method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testFilterByCategory() {
        System.out.println("filterByCategory");
        Category cat1 = new Category("code1", "desc1");
        Category cat2 = new Category("code2", "desc2");
        ServiceProvider sp1 = new ServiceProvider("name1", "nif1", "email1", "abNAme1");
        sp1.addCategory(cat1);
        ServiceProvider sp2 = new ServiceProvider("name2", "nif2", "email2", "abName2");
        sp2.addCategory(cat2);
        List<ServiceProvider> spList = new ArrayList<>();
        spList.add(sp1);
        spList.add(sp2);
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = new ArrayList<>();
        expResult.add(sp1);
        List<ServiceProvider> result = instance.filterByCategory(spList, cat1);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAvailability method, of class AssignmentAlgoritm1.
     */
    @Test
    public void testFilterByAvailability() {
        System.out.println("filterByAvailability");

        ServiceProvider sp1 = new ServiceProvider("name1", "nif1", "email1", "abName1");
        LocalDate date1 = LocalDate.of(2019, 6, 22);
        LocalTime time1 = LocalTime.of(9, 0);
        LocalTime time2 = LocalTime.of(18, 0);
        Availability aval1 = new Availability(date1, time1, time2);
        sp1.getSpAvailabilityList().addAvailability(aval1);

        ServiceProvider sp2 = new ServiceProvider("name2", "nif2", "email2", "abName2");
        LocalDate date2 = LocalDate.of(2019, 6, 25);
        LocalTime time3 = LocalTime.of(9, 0);
        LocalTime time4 = LocalTime.of(18, 0);
        Availability aval2 = new Availability(date2, time3, time4);
        sp2.getSpAvailabilityList().addAvailability(aval2);

        List<ServiceProvider> spList = new ArrayList<>();
        spList.add(sp1);
        spList.add(sp2);

        List<SchedulePreference> scheduleList = new ArrayList<>();
        SchedulePreference schedPref = new SchedulePreference(1, date1, time1);
        int duration = 60;
        scheduleList.add(schedPref);
                
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();

        List<ServiceProvider> expResult = new ArrayList<>();
        expResult.add(sp1);
        List<ServiceProvider> result = instance.filterByAvailability(spList, scheduleList, duration);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterByAddress method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testFilterByAddress() {
        System.out.println("filterByAddress");
        List<ServiceProvider> spList = null;
        Address address = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        List<ServiceProvider> expResult = null;
        List<ServiceProvider> result = instance.filterByAddress(spList, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of createAssignment method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testCreateAssignment() {
        System.out.println("createAssignment");
        ServiceRequestDescription service = null;
        AssignmentAlgoritm1 instance = new AssignmentAlgoritm1();
        ServiceAssignment expResult = null;
        ServiceAssignment result = instance.createAssignment(service);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeExpiredServices method, of class AssignmentAlgoritm1.
     */
    @Disabled
    public void testRemoveExpiredServices() {
    }

}
