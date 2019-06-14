/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author joaoferreira
 */
public class ServiceTest {
 
    /**
     * Test of getId method, of class Service.
     */
    @Disabled
    public void testGetId() {
        System.out.println("getId");
        Service instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasId method, of class Service.
     */
    @Disabled
    public void testHasId() {
        System.out.println("hasId");
        String id = "";
        Service instance = null;
        boolean expResult = false;
        boolean result = instance.hasId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefDescription method, of class Service.
     */
    @Disabled
    public void testGetBriefDescription() {
        System.out.println("getBriefDescription");
        Service instance = null;
        String expResult = "";
        String result = instance.getBriefDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullDescription method, of class Service.
     */
    @Disabled
    public void testGetFullDescription() {
        System.out.println("getFullDescription");
        Service instance = null;
        String expResult = "";
        String result = instance.getFullDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setfullDescription method, of class Service.
     */
    @Disabled
    public void testSetfullDescription() {
        System.out.println("setfullDescription");
        String fullDescription = "";
        Service instance = null;
        instance.setfullDescription(fullDescription);
    }

    /**
     * Test of getHourlyCost method, of class Service.
     */
    @Disabled
    public void testGetHourlyCost() {
        System.out.println("getHourlyCost");
        Service instance = null;
        double expResult = 0.0;
        double result = instance.getHourlyCost();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCategory method, of class Service.
     */
    @Disabled
    public void testGetCategory() {
        System.out.println("getCategory");
        Service instance = null;
        Category expResult = null;
        Category result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCategory method, of class Service.
     */
    @Disabled
    public void testSetCategory() {
        System.out.println("setCategory");
        Category category = null;
        Service instance = null;
        instance.setCategory(category);
    }

    /**
     * Test of getServiceType method, of class Service.
     */
    @Disabled
    public void testGetServiceType() {
        System.out.println("getServiceType");
        Service instance = null;
        ServiceType expResult = null;
        ServiceType result = instance.getServiceType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServiceType method, of class Service.
     */
    @Disabled
    public void testSetServiceType() {
        System.out.println("setServiceType");
        ServiceType serviceType = null;
        Service instance = null;
        instance.setServiceType(serviceType);
    }

    /**
     * Test of equals method, of class Service.
     */
    @Disabled
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Service instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Service.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        Service instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    public class ServiceImpl extends Service {

        public ServiceImpl() {
            super("", "", "", 0.0, null);
        }

        @Override
        public double getDurationCost(double duration) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<String> getOtherAtributes() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean hasOtherAttributes() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean setAdditionalData(String data) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
