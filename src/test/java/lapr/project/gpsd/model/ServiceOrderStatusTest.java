package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceOrderStatusTest {
   
    /**
     * Test of getServOrderStatus method, of class ServiceOrderStatus.
     */
    @Disabled
    public void testGetServOrderStatus() {
        System.out.println("getServOrderStatus");
        ServiceOrderStatus instance = null;
        String expResult = "";
        String result = instance.getServOrderStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setServOrderDetail method, of class ServiceOrderStatus.
     */
    @Disabled
    public void testSetServOrderDetail() {
        System.out.println("setServOrderDetail");
        String servOrderDetail = "";
        ServiceOrderStatus instance = null;
        instance.setServOrderDetail(servOrderDetail);
    }

    /**
     * Test of setServOrderStatus method, of class ServiceOrderStatus.
     */
    @Disabled
    public void testSetServOrderStatus() {
        System.out.println("setServOrderStatus");
        String servOrderStatus = "";
        ServiceOrderStatus instance = null;
        instance.setServOrderStatus(servOrderStatus);
    }
    
}
