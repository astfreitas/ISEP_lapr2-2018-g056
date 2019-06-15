package lapr.project.gpsd.model;

import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademicCompetenceTest {

    /**
     * Test of getCourse method, of class AcademicCompetence.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        AcademicCompetence instance = new AcademicCompetence("Degree", "N/A", 20);
        String expResult = "Degree";
        String result = instance.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourse method, of class AcademicCompetence.
     */
    @Test
    public void testGetCourse_failedExp() {
        System.out.println("getCourse");
        AcademicCompetence instance = new AcademicCompetence("Degree", "N/A", 20);
        String expResult = "";
        String result = instance.getCourse();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of setCourse method, of class AcademicCompetence.
     */
    @Test
    public void testSetCourse() {
        System.out.println("setCourse");
        String course = "Master";
        AcademicCompetence instance = new AcademicCompetence("Degree", "N/A", 20);
        instance.setCourse(course);
        String result = instance.getCourse();
        assertEquals(course, result);
    }

    /**
     * Test of getLevel method, of class AcademicCompetence.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        AcademicCompetence instance = new AcademicCompetence("Degree", "TesteLevel", 20);;
        String expResult = "TesteLevel";
        String result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevel method, of class AcademicCompetence.
     */
    @Test
    public void testGetLevel_FailExp() {
        System.out.println("getLevel");
        AcademicCompetence instance = new AcademicCompetence("Degree", "TesteLevel", 20);
        String expResult = "N/A";
        String result = instance.getLevel();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of setLevel method, of class AcademicCompetence.
     */
    @Test
    public void testSetLevel() {
        System.out.println("setLevel");
        String level = "NewLevel";
        AcademicCompetence instance = new AcademicCompetence("Master", "TesteLevelSet", 10);
        instance.setLevel(level);
        String result = instance.getLevel();
        assertEquals(level, result);
    }

    /**
     * Test of getScore method, of class AcademicCompetence.
     */
    @Test
    public void testGetScoreFailExp() {
        System.out.println("getScore");
        AcademicCompetence instance = new AcademicCompetence("Master", "TesteLevelSet", 10);
        double expResult = 10;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setScore method, of class AcademicCompetence.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        double expResult = 10;
        AcademicCompetence instance = new AcademicCompetence("Master", "TesteLevelSet", 10);
        instance.setScore(expResult);
        double result = instance.getScore();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setScore method, of class AcademicCompetence.
     */
    @Test
    public void testSetScore_ExceptionExp() {
        assertThrows(NullPointerException.class, () -> {
            System.out.println("setScore");
            double expResult = 10;
            AcademicCompetence instance = null;
            instance.setScore(expResult);
            double result = instance.getScore();
            assertEquals(expResult, result, 0.1);
        });
    }

    /**
     * Test of toString method, of class AcademicCompetence.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        AcademicCompetence instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
