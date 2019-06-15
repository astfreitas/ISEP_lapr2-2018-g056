package lapr.project.gpsd.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.SPApplication;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmitApplicationControllerTest {

    /**
     * Test of addAcademicCompetence method, of class
     * SubmitApplicationController.
     */
    @Test
    public void testAddAcademicCompetence() {
        System.out.println("addAcademicCompetence");
        String course = "testCourse";
        String level = "Master";
        double grade = 20.0;
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addAcademicCompetence(course, level, grade);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProfessionalCompetence method, of class
     * SubmitApplicationController.
     */
    @Test
    public void testAddProfessionalCompetence() {
        System.out.println("addProfessionalCompetence");
        String description = "testProComp";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addProfessionalCompetence(description);
        assertEquals(expResult, result);
    }

    /**
     * Test of newSPApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testNewSPApplication() {
        System.out.println("newSPApplication");
        String name = "testName";
        String NIF = "testNIF";
        String phone = "testPhone";
        String email = "testEMail";
        SubmitApplicationController instance = new SubmitApplicationController();
        boolean expResult = true;
        boolean result = instance.newSPApplication(name, NIF, phone, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of newAddress method, of class SubmitApplicationController.
     */
    @Test
    public void testNewAddress() {
        System.out.println("newAddress");
        String local = "testLocal";
        String postalCode = "4000-007";
        String address = "testAddress";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.newAddress(local, postalCode, address);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String catId = "1";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.addCategory(catId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class SubmitApplicationController.
     */
    @Disabled
    public void testGetCategories() {
        System.out.println("getCategories");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        List<Category> result = instance.getCategories();
        List<Category> expResult = new ArrayList<>();
        expResult.add(new Category("1", "Plumber"));
        expResult.add(new Category("2", "Locksmith"));
        expResult.add(new Category("3", "Automotive Mechanic"));
        expResult.add(new Category("4", "Cook"));
        expResult.add(new Category("5", "Painter"));
        assertEquals(expResult, result);
    }

    /**
     * Test of registerApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testRegisterApplication() {
        System.out.println("registerApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.registerApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateApplication method, of class SubmitApplicationController.
     */
    @Test
    public void testValidateApplication() {
        System.out.println("validateApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        instance.addProfessionalCompetence("testDesc");
        instance.addAcademicCompetence("testCourse", "testLevel", 20);
        instance.addCategory("1");
        instance.validateApplication();
    }

    /**
     * Test of getApplication method, of class SubmitApplicationController.
     */
    @Disabled
    public void testGetApplication() {
        System.out.println("getApplication");
        SubmitApplicationController instance = new SubmitApplicationController();
        SPApplication expResult = null;
        SPApplication result = instance.getApplication();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCategory method, of class SubmitApplicationController.
     */
    @Test
    public void testValidateCategory() {
        System.out.println("validateCategory");
        String catId = "1";
        SubmitApplicationController instance = new SubmitApplicationController();
        instance.newSPApplication("testName", "testNIF", "testPhone", "testEmail");
        boolean expResult = true;
        boolean result = instance.validateCategory(catId);
        assertEquals(expResult, result);
    }

}
