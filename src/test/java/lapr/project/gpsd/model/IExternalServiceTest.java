package lapr.project.gpsd.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IExternalServiceTest {

    /**
     * Test of getActsOnLocationList method, of class IExternalService.
     */
    @Disabled
    public void testGetActsOnLocationList() {
        System.out.println("getActsOnLocationList");
        PostalCode pCode = null;
        double radius = 0.0;
        PostalCodeRegistry pcRegistry = null;
        IExternalService instance = new IExternalServiceImpl();
        List<Location> expResult = null;
        List<Location> result = instance.getActsOnLocationList(pCode, radius, pcRegistry);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class IExternalService.
     */
    @Disabled
    public void testLoadPostalCodeList() throws Exception {
        System.out.println("loadPostalCodeList");
        IExternalService instance = new IExternalServiceImpl();
        ArrayList<PostalCode> expResult = null;
        ArrayList<PostalCode> result = instance.loadPostalCodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistanceBetCP method, of class IExternalService.
     */
    @Disabled
    public void testGetDistanceBetCP() {
        System.out.println("getDistanceBetCP");
        PostalCode pc1 = null;
        PostalCode pc2 = null;
        IExternalService instance = new IExternalServiceImpl();
        double expResult = 0.0;
        double result = instance.getDistanceBetCP(pc1, pc2);
        assertEquals(expResult, result, 0.0);
    }

    public class IExternalServiceImpl implements IExternalService {

        public List<Location> getActsOnLocationList(PostalCode pCode, double radius, PostalCodeRegistry pcRegistry) {
            return null;
        }

        public ArrayList<PostalCode> loadPostalCodeList() throws IOException {
            return null;
        }

        public double getDistanceBetCP(PostalCode pc1, PostalCode pc2) {
            return 0.0;
        }
    }
    
}
