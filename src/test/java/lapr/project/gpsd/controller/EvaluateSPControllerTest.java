package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.ServiceProvider;
import lapr.project.gpsd.model.ServiceProviderStatistics;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class EvaluateSPControllerTest {

    Company company;

    public EvaluateSPControllerTest() {
        this.company = ApplicationGPSD.getInstance().getCompany();
        ApplicationGPSD.getInstance().bootstrap();
        System.out.println("Login state: " + ApplicationGPSD.getInstance().doLogin("hro1@isep.ipp.pt", "123"));
    }

    /**
     * Test of getServiceProviders method, of class EvaluateSPController.
     */
    @Test
    public void testGetServiceProviders() {
        System.out.println("getServiceProviders");
        EvaluateSPController instance = new EvaluateSPController();
        List<ServiceProvider> expResult = company.getServiceProviderRegistry().getServiceProviders();
        List<ServiceProvider> result = instance.getServiceProviders();
        assertEquals(expResult, result);
    }

    /**
     * Test of newSPStatistics method, of class EvaluateSPController.
     */
    @Test
    public void testNewSPStatistics() {
        System.out.println("newSPStatistics");
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        String email = sp.getEmail();
        EvaluateSPController instance = new EvaluateSPController();
        instance.newSPStatistics(email);
        double expResult = instance.getSpAverageRating();
        double result = sp.getAverageRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabels method, of class EvaluateSPController.
     */
    @Test
    public void testGetLabels() {
        System.out.println("getLabels");
        EvaluateSPController instance = new EvaluateSPController();
        List<String> expResult = new ArrayList<String>() {
            {
                add(ServiceProviderStatistics.LABEL_WORST);
                add(ServiceProviderStatistics.LABEL_REGULAR);
                add(ServiceProviderStatistics.LABEL_OUTSTANDING);
            }
        };
        List<String> result = instance.getLabels();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLabel method, of class EvaluateSPController.
     */
    @Test
    public void testSetLabel() {
        System.out.println("setLabel");
        String label = "label";
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        instance.setLabel(label);
        String result = instance.getLabel();
        String expResult = label;
        assertEquals(expResult, result);
    }

    /**
     * Test of getLabel method, of class EvaluateSPController.
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        instance.setLabel("label");
        String expResult = "label";
        String result = instance.getLabel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSPClassification method, of class EvaluateSPController.
     */
    @Test
    public void testSetSPClassification() {
        System.out.println("setSPClassification");
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        EvaluateSPController instance = new EvaluateSPController();
        instance.newSPStatistics(sp.getEmail());
        instance.setLabel("label");
        instance.setSPClassification();
        String result = sp.getClassification();
        String expResult = "label";
        assertEquals(expResult, result);
    }

    /**
     * Test of getPopulationMeanAverageRating method, of class
     * EvaluateSPController.
     */
    @Test
    public void testGetPopulationMeanAverageRating() {
        System.out.println("getPopulationMeanAverageRating");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        List<Double> ratings = company.getServiceProviderRegistry().getAverageRatings();
        double expResult = ratings.stream().mapToDouble(a -> a).average().getAsDouble();
        double result = instance.getPopulationMeanAverageRating();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getPopulationStdDeviation method, of class EvaluateSPController.
     */
    @Test
    public void testGetPopulationStdDeviation() {
        System.out.println("getPopulationStdDeviation");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        List<Double> ratings = company.getServiceProviderRegistry().getAverageRatings();
        double avg = ratings.stream().mapToDouble(a -> a).average().getAsDouble();
        double expResult = 0;
        for (double rate : ratings) {
            expResult += Math.pow((avg - rate), 2) / ratings.size();
        }
        expResult = Math.sqrt(expResult);
        double result = instance.getPopulationStdDeviation();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getSpAverageRating method, of class EvaluateSPController.
     */
    @Test
    public void testGetSpAverageRating() {
        System.out.println("getSpAverageRating");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        double expResult = sp.getAverageRating();
        double result = instance.getSpAverageRating();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getSpAbsoluteDifference method, of class EvaluateSPController.
     */
    @Disabled
    public void testGetSpAbsoluteDifference() {
        System.out.println("getSpAbsoluteDifference");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        double expResult = sp.getAverageRating() - instance.getPopulationStdDeviation();
        double result = instance.getSpAbsoluteDifference();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getSpRatings method, of class EvaluateSPController.
     */
    @Test
    public void testGetSpRatings() {
        System.out.println("getSpRatings");
        EvaluateSPController instance = new EvaluateSPController();
        ServiceProvider sp = company.getServiceProviderRegistry().getServiceProviders().get(0);
        instance.newSPStatistics(sp.getEmail());
        List<Integer> expResult = sp.getRatings();
        List<Integer> result = instance.getSpRatings();
        assertEquals(expResult, result);
    }

}
