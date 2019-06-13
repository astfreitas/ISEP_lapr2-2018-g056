package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryRegistryTest {
    
    /**
     * Test of newCategory method, of class CategoryRegistry.
     */
    @Test
    public void testNewCategory() {
        System.out.println("newCategory");
        String catID = "testID";
        String description = "testDescription";
        CategoryRegistry instance = new CategoryRegistry();
        Category expResult = new Category("testeID", "testDescription");
        Category result = instance.newCategory(catID, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCatById method, of class CategoryRegistry.
     */
    @Test
    public void testGetCatById() {
        System.out.println("getCatById");
        String catID = "testID";
        Category cat = new Category("testeID", "testDescription");
        CategoryRegistry instance = new CategoryRegistry();
        instance.getCategories().add(cat);
        Category expResult = cat;
        Category result = instance.getCatById(catID);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCategory method, of class CategoryRegistry.
     */
    @Test
    public void testValidateCategory() {
        System.out.println("validateCategory");
        Category cat = new Category("testeID", "testDescription");
        CategoryRegistry instance = new CategoryRegistry();
        boolean expResult = true;
        boolean result = instance.validateCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of addCategory method, of class CategoryRegistry.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category cat = new Category("testeID", "testDescription");
        CategoryRegistry instance = new CategoryRegistry();
        boolean expResult = true;
        boolean result = instance.addCategory(cat);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategories method, of class CategoryRegistry.
     */
    @Disabled
    public void testGetCategories() {
        System.out.println("getCategories");
        CategoryRegistry instance = new CategoryRegistry();
        List<Category> expResult = null;
        List<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerCategory method, of class CategoryRegistry.
     */
    @Test
    public void testRegisterCategory() {
        System.out.println("registerCategory");
        Category category = new Category("testeID", "testDescription");
        CategoryRegistry instance = new CategoryRegistry();
        boolean expResult = true;
        boolean result = instance.registerCategory(category);
        assertEquals(expResult, result);
    }
    
}
