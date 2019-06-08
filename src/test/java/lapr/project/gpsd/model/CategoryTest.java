package lapr.project.gpsd.model;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    /**
     * Test of hasId method, of class Category.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String id = "123";
        Category instance = new Category("123", "testDesc");
        boolean expResult = true;
        boolean result = instance.hasId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class Category.
     */
    @Disabled
    public void testGetCode() {
        System.out.println("getCode");
        Category instance = null;
        String expResult = "";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Category.
     */
    @Disabled
    public void testGetDescription() {
        System.out.println("getDescription");
        Category instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCode method, of class Category.
     */
    @Disabled
    public void testSetCode() {
        System.out.println("setCode");
        String code = "";
        Category instance = null;
        instance.setCode(code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Category.
     */
    @Disabled
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Category instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherCategory = new Category("123", "blablabla");
        Category instance = new Category("123", "blablabla");
        boolean expResult = true;
        boolean result = instance.equals(otherCategory);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Category.
     */
    @Disabled
    public void testToString() {
        System.out.println("toString");
        Category instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
