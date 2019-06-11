package lapr.project.gpsd.model;

import static java.lang.System.getProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalService1Test {

    

    public ExternalService1Test() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Properties props = getProperties();
        Company company = new Company(props);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Test
    public void testLoadPostalCodeList() throws Exception {
        System.out.println("loadPostalCodeList - same list");
        ExternalService1 instance = new ExternalService1("src/main/resources/ExternalService/codigos_postais.csv");
        ArrayList<PostalCode> expResult = instance.loadPostalCodeList();
        ArrayList<PostalCode> result = instance.loadPostalCodeList();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Test
    public void testLoadPostalCodeList2() throws Exception {
        System.out.println("loadPostalCodeList 2 - last postalcode in list");
        ExternalService1 instance = new ExternalService1("src/main/resources/ExternalService/codigos_postais.csv");

        List<PostalCode> listPC = instance.loadPostalCodeList();
        String result = listPC.get(10).getPostalCode();
        String expResult = "4000-017";
        assertEquals(expResult, result);
    }

    /**
     * Test of loadPostalCodeList method, of class ExternalService1.
     */
    @Test
    public void testLoadPostalCodeList3() throws Exception {
        System.out.println("loadPostalCodeList 3 - Size");
        ExternalService1 instance = new ExternalService1("src/main/resources/ExternalService/codigos_postais.csv");
        List<PostalCode> listPC = instance.loadPostalCodeList();
        int result = listPC.size();
        int expResult = 31587;
        assertEquals(expResult, result);
    }

    /**
     * Test of getActsOnLocationList method, of class ExternalService1.
     */
    @Test
    public void testGetActsOnLocationList() {
        System.out.println("getActsOnLocationList");
        String mainPC = "4000-123";
        PostalCode postalCode = new PostalCode(mainPC, 41.1536117, -8.6078896);
        double radius = 100.0;
        Properties props = getProperties();
        Company company = new Company(props);
        PostalCodeRegistry cpReg = company.getPostalCodeRegistry();
        ExternalService1 instance = new ExternalService1("src/main/resources/ExternalService/codigos_postais.csv");
        int expNumberPCList = 44;
        List<Location> resultList = instance.getActsOnLocationList(postalCode, radius, cpReg);
        int result = resultList.size();
        assertEquals(expNumberPCList, result);
    }

}
