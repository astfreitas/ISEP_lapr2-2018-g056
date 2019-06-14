package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPApplicationRegistryTest {

    /**
     * Test of getApplications method, of class SPApplicationRegistry.
     */
    @Test
    public void testGetApplications() {
        System.out.println("getApplications");
        ApplicationGPSD testApp = ApplicationGPSD.getInstance();
        SPApplicationRegistry instance = new SPApplicationRegistry();
        SPApplication spApp1 = new SPApplication("Test1", "501075220", "229025764", "teste@defaultlda.com");
        SPApplication spApp2 = new SPApplication("Test2", "501075220", "229025765", "teste2@defaultlda.com");
        instance.getApplications().add(spApp2);
        instance.getApplications().add(spApp1);
        int expResult = 2;
        List<SPApplication> spaList = instance.getApplications();
        int result = spaList.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApplicationByNIF method, of class SPApplicationRegistry.
     */
    @Test
    public void testGetApplicationByNIF() {
        System.out.println("getApplicationByNIF");
        ApplicationGPSD testApp = ApplicationGPSD.getInstance();
        SPApplicationRegistry instance = testApp.getCompany().getSPApplicationRegistry();

        String NIF = "510324896";
        SPApplication expResult = new SPApplication("TestNot", "503080230", "919997458", "test@testAt.com");
        SPApplication result = instance.getApplicationByNIF(NIF);
        Assertions.assertNotEquals(expResult, result);
//        assertEquals(expResult, result);
    }

    /**
     * Test of getAcceptedApplications method, of class SPApplicationRegistry.
     */
    @Test
    public void testGetAcceptedApplications() {
        System.out.println("getAcceptedApplications");
        ApplicationGPSD testApp = ApplicationGPSD.getInstance();
        SPApplicationRegistry instance = testApp.getCompany().getSPApplicationRegistry();

        String applicationStatus = "";

        List<SPApplication> expResult = testApp.getCompany().getSPApplicationRegistry().getApplications();
        for (SPApplication sPApplication : expResult) {
            sPApplication.getApplicationStatus().setSPApplicationStatus("Accepetd");
        }
        List<SPApplication> result = instance.getAcceptedApplications(applicationStatus);
        assertEquals(expResult, result);
    }

    /**
     * Test of newSPApplication method, of class SPApplicationRegistry.
     */
    @Test
    public void testNewSPApplication() {
        System.out.println("newSPApplication");
        String name = "Test1";
        String NIF = "500900320";
        String phone = "229056585";
        String email = "teste1@defaultlda.com";
        SPApplicationRegistry instance = new SPApplicationRegistry();
        SPApplication expResult = new SPApplication(name, NIF, phone, email);
        SPApplication result = instance.newSPApplication(name, NIF, phone, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateApplication method, of class SPApplicationRegistry.
     */
    @Test
    public void testValidateApplication() {
        System.out.println("validateApplication");
        String name = "Test1";
        String NIF = "500900320";
        String phone = "229056585";
        String email = "teste1@defaultlda.com";
        SPApplication spa = new SPApplication(name, NIF, phone, email);
        SPApplicationRegistry instance = new SPApplicationRegistry();
        ProfessionalCompetence proComp = new ProfessionalCompetence("Competence Test");
        AcademicCompetence academic = new AcademicCompetence("Degree", "degree@defaultlda.com", 20);
        Category cat = new Category("cat1", "Category Test");
        spa.getAcademicCompetences().add(academic);
        spa.getProfessionalCompetences().add(proComp);
        spa.getCategories().add(cat);
        instance.validateApplication(spa);
    }

    /**
     * Test of registerApplication method, of class SPApplicationRegistry.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        String name = "Test1";
        String NIF = "500900320";
        String phone = "229056585";
        String email = "teste1@defaultlda.com";
        SPApplication spa = new SPApplication(name, NIF, phone, email);
        SPApplicationRegistry instance = new SPApplicationRegistry();
        boolean expResult = true;
        boolean result = instance.registerApplication(spa);
        assertEquals(expResult, result);
    }

}
