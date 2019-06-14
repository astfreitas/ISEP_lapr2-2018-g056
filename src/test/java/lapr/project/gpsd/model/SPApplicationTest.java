package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPApplicationTest {

    /**
     * Test of getName method, of class SPApplication.
     */
    @Disabled
    public void testGetName() {
        System.out.println("getName");
        SPApplication instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNIF method, of class SPApplication.
     */
    @Disabled
    public void testGetNIF() {
        System.out.println("getNIF");
        SPApplication instance = null;
        String expResult = "";
        String result = instance.getNIF();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasNIF method, of class SPApplication.
     */
    @Test
    public void testHasNIF() {
        System.out.println("hasNIF");
        String nif = "testNIF";
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.hasNIF(nif);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhone method, of class SPApplication.
     */
    @Disabled
    public void testGetPhone() {
        System.out.println("getPhone");
        SPApplication instance = null;
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class SPApplication.
     */
    @Disabled
    public void testGetEmail() {
        System.out.println("getEmail");
        SPApplication instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class SPApplication.
     */
    @Disabled
    public void testGetAddress() {
        System.out.println("getAddress");
        SPApplication instance = null;
        Address expResult = null;
        Address result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class SPApplication.
     */
    @Disabled
    public void testSetAddress() {
        System.out.println("setAddress");
        Address address = null;
        SPApplication instance = null;
        instance.setAddress(address);
    }

    /**
     * Test of getAcademicCompetences method, of class SPApplication.
     */
    @Disabled
    public void testGetAcademicCompetences() {
        System.out.println("getAcademicCompetences");
        SPApplication instance = null;
        List<AcademicCompetence> expResult = null;
        List<AcademicCompetence> result = instance.getAcademicCompetences();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProfessionalCompetences method, of class SPApplication.
     */
    @Disabled
    public void testGetProfessionalCompetences() {
        System.out.println("getProfessionalCompetences");
        SPApplication instance = null;
        List<ProfessionalCompetence> expResult = null;
        List<ProfessionalCompetence> result = instance.getProfessionalCompetences();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class SPApplication.
     */
    @Disabled
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        SPApplication instance = null;
        instance.setName(name);
    }

    /**
     * Test of setNIF method, of class SPApplication.
     */
    @Disabled
    public void testSetNIF() {
        System.out.println("setNIF");
        String NIF = "";
        SPApplication instance = null;
        instance.setNIF(NIF);
    }

    /**
     * Test of setPhone method, of class SPApplication.
     */
    @Disabled
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        SPApplication instance = null;
        instance.setPhone(phone);
    }

    /**
     * Test of setEmail method, of class SPApplication.
     */
    @Disabled
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        SPApplication instance = null;
        instance.setEmail(email);
    }

    /**
     * Test of addProfessionalCompetence method, of class SPApplication.
     */
    @Test
    public void testAddProfessionalCompetence() {
        System.out.println("addProfessionalCompetence");
        ProfessionalCompetence pc = new ProfessionalCompetence("testDesc");
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addProfessionalCompetence(pc);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class SPApplication.
     */
    @Disabled
    public void testGetCategories() {
        System.out.println("getCategories");
        SPApplication instance = null;
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class SPApplication.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat = new Category("testCode", "testDesc");
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAcademicCompetence method, of class SPApplication.
     */
    @Test
    public void testAddAcademicCompetence() {
        System.out.println("addAcademicCompetence");
        AcademicCompetence ac = new AcademicCompetence("testCourse", "testLevel", 20);
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addAcademicCompetence(ac);
        assertEquals(expResult, result);
    }

    /**
     * Test of newAddress method, of class SPApplication.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        Address expResult = new Address("testLocal", "4000-007", "testAddress");
        Address result = instance.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of newAcademicCompetence method, of class SPApplication.
     */
    @Test
    public void testNewAcademicCompetence() {
        System.out.println("newAcademicCompetence");
        String course = "testCourse";
        String level = "testLevel";
        double grade = 19;
        AcademicCompetence expResult = new AcademicCompetence(course, level, grade);
        AcademicCompetence result = SPApplication.newAcademicCompetence(course, level, grade);
        assertEquals(expResult, result);
    }

    /**
     * Test of newProfessionalCompetence method, of class SPApplication.
     */
    @Test
    public void testNewProfessionalCompetence() {
        System.out.println("newProfessionalCompetence");
        String description = "testDesc";
        ProfessionalCompetence expResult = new ProfessionalCompetence(description);
        ProfessionalCompetence result = SPApplication.newProfessionalCompetence(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of getApplicationStatus method, of class SPApplication.
     */
    @Disabled
    public void testGetApplicationStatus() {
        System.out.println("getApplicationStatus");
        SPApplication instance = null;
        SPApplicationStatus expResult = null;
        SPApplicationStatus result = instance.getApplicationStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAccepted method, of class SPApplication.
     */
    @Test
    public void testIsAccepted() {
        System.out.println("isAccepted");
        String applicationStatus = "Accepted";
        SPApplication instance = new SPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = false;
        boolean result = instance.isAccepted(applicationStatus);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SPApplication.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        SPApplication instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
