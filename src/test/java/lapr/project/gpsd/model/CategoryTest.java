package lapr.project.gpsd.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CategoryTest {
    
    public CategoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hasId method, of class Category.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String id = "123";
        Category instance = new Category("123", null);
        boolean expResult = true;
        boolean result = instance.hasId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class Category.
     */
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
