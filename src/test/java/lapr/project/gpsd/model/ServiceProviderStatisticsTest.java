package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceProviderStatisticsTest {

    /**
     * Test of getLabels method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetLabels() {
        System.out.println("getLabels");
        List<String> expResult = null;
        List<String> result = ServiceProviderStatistics.getLabels();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSPSAverageRatings method, of class ServiceProviderStatistics.
     */
    @Test
    public void testGetSPSAverageRatings() {
        System.out.println("getSPSAverageRatings");
        ServiceProviderStatistics instance = null;
        List<Double> expResult = null;
        List<Double> result = instance.getSPSAverageRatings();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpAverageRating method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetSpAverageRating() {
        System.out.println("getSpAverageRating");
        ServiceProviderStatistics instance = null;
        double expResult = 0.0;
        double result = instance.getSpAverageRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPopulationMeanAverageRating method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetPopulationMeanAverageRating() {
        System.out.println("getPopulationMeanAverageRating");
        ServiceProviderStatistics instance = null;
        double expResult = 0.0;
        double result = instance.getPopulationMeanAverageRating();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPopulationStdDeviation method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetPopulationStdDeviation() {
        System.out.println("getPopulationStdDeviation");
        ServiceProviderStatistics instance = null;
        double expResult = 0.0;
        double result = instance.getPopulationStdDeviation();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSpAbsoluteDifference method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetSpAbsoluteDifference() {
        System.out.println("getSpAbsoluteDifference");
        ServiceProviderStatistics instance = null;
        double expResult = 0.0;
        double result = instance.getSpAbsoluteDifference();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getClassification method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetClassification() {
        System.out.println("getClassification");
        ServiceProviderStatistics instance = null;
        String expResult = "";
        String result = instance.getClassification();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClassification method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testSetClassification() {
        System.out.println("setClassification");
        String classification = "";
        ServiceProviderStatistics instance = null;
        instance.setClassification(classification);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpRatings method, of class ServiceProviderStatistics.
     */
    @Disabled
    public void testGetSpRatings() {
        System.out.println("getSpRatings");
        ServiceProviderStatistics instance = null;
        List<Integer> expResult = null;
        List<Integer> result = instance.getSpRatings();
        assertEquals(expResult, result);
    }
    
}
