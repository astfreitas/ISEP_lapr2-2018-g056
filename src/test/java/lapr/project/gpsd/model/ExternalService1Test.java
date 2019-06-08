package lapr.project.gpsd.model;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalService1Test {

    public ExternalService1Test() {
    }

    /**
     * Test of getActsOnLocationList method, of class ExternalService1.
     */
    @Disabled
    public void testGetActsOnLocationList() {
//        System.out.println("getActsOnLocationList");
//        PostalCode pCode = new PostalCode("4000-0013");
//        double radius = 0.0;
//        PostalCodeRegistry cpReg = new PostalCodeRegistry();
//        ExternalService1 instance = new ExternalService1();
//        List<Location> expResult = null;
//        List<Location> result = instance.getActsOnLocationList(pCode, radius, cpReg);
//        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Disabled
    public void testLoadPostalCodeRegistry() throws Exception {
        System.out.println("loadPostalCodeRegistry");
        ExternalService1 instance = new ExternalService1("./ExternalService/codigos_postais.csv");
        List<PostalCode> expResult = null;
        List<PostalCode> result = instance.loadPostalCodeList();
        assertEquals(expResult, result);

    }

}
