package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceCostCalculationTest {
   
    /**
     * Test of getDurationCost method, of class ServiceCostCalculation.
     */
    @Disabled
    public void testGetDurationCost() {
        System.out.println("getDurationCost");
        double duration = 0.0;
        ServiceCostCalculation instance = new ServiceCostCalculationImpl();
        double expResult = 0.0;
        double result = instance.getDurationCost(duration);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getOtherAtributes method, of class ServiceCostCalculation.
     */
    @Disabled
    public void testGetOtherAtributes() {
        System.out.println("getOtherAtributes");
        ServiceCostCalculation instance = new ServiceCostCalculationImpl();
        List<String> expResult = null;
        List<String> result = instance.getOtherAtributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasOtherAttributes method, of class ServiceCostCalculation.
     */
    @Disabled
    public void testHasOtherAttributes() {
        System.out.println("hasOtherAttributes");
        ServiceCostCalculation instance = new ServiceCostCalculationImpl();
        boolean expResult = false;
        boolean result = instance.hasOtherAttributes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdditionalData method, of class ServiceCostCalculation.
     */
    @Disabled
    public void testSetAdditionalData() {
        System.out.println("setAdditionalData");
        String data = "";
        ServiceCostCalculation instance = new ServiceCostCalculationImpl();
        boolean expResult = false;
        boolean result = instance.setAdditionalData(data);
        assertEquals(expResult, result);
    }

    public class ServiceCostCalculationImpl implements ServiceCostCalculation {

        public double getDurationCost(double duration) {
            return 0.0;
        }

        public List<String> getOtherAtributes() {
            return null;
        }

        public boolean hasOtherAttributes() {
            return false;
        }

        public boolean setAdditionalData(String data) {
            return false;
        }

        @Override
        public boolean hasAttribute(String attribute) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
