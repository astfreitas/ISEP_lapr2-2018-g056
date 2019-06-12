package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademicCompetenceTest {

    /**
     * Test of getCourse method, of class AcademicCompetence.
     */
    @Disabled
    public void testGetCourse() {
        System.out.println("getCourse");
        AcademicCompetence instance = null;
        String expResult = "";
        String result = instance.getCourse();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCourse method, of class AcademicCompetence.
     */
    @Disabled
    public void testSetCourse() {
        System.out.println("setCourse");
        String course = "";
        AcademicCompetence instance = null;
        instance.setCourse(course);
    }

    /**
     * Test of getLevel method, of class AcademicCompetence.
     */
    @Disabled
    public void testGetLevel() {
        System.out.println("getLevel");
        AcademicCompetence instance = null;
        String expResult = "";
        String result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLevel method, of class AcademicCompetence.
     */
    @Disabled
    public void testSetLevel() {
        System.out.println("setLevel");
        String level = "";
        AcademicCompetence instance = null;
        instance.setLevel(level);
    }

    /**
     * Test of getScore method, of class AcademicCompetence.
     */
    @Disabled
    public void testGetScore() {
        System.out.println("getScore");
        AcademicCompetence instance = null;
        double expResult = 0.0;
        double result = instance.getScore();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setScore method, of class AcademicCompetence.
     */
    @Disabled
    public void testSetScore() {
        System.out.println("setScore");
        double score = 0.0;
        AcademicCompetence instance = null;
        instance.setScore(score);
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
