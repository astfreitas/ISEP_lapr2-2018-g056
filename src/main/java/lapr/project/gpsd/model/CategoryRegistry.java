package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.controller.ApplicationGPSD;

public class CategoryRegistry {

    private List<Category> categories;

    /**
     *
     * Creates an instance of Category Registry
     *
     */
    public CategoryRegistry() {
        this.categories = new ArrayList<>();
    }

    /**
     *
     * Creates and returns an instance of Category
     *
     * @param catID Category unique ID
     * @param description Category description
     * @return Category instantiated
     */
    public Category newCategory(String catID, String description) {
        return new Category(catID, description);
    }

    /**
     *
     * Looks in the registry for a category with a specific ID
     *
     * @param catID ID to look for
     * @return Category with the ID. Null if none is found.
     */
    public Category getCatById(String catID) {
        for (Category cat : categories) {
            if (cat.hasId(catID)) {
                return cat;
            }
        }
        return null;
    }

    /**
     *
     * Checks the registry if the Category is already present in the registry
     *
     * @param cat Category being validated
     * @return True/false if the category is/isn't validated
     */
    public boolean validateCategory(Category cat) {
        for (Category catListed : categories) {
            if (catListed.equals(cat)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Adds a Category to the regitry
     *
     * @param cat Category being added
     * @return True/false if the Category is/isn't added
     */
    public boolean addCategory(Category cat) {
        return categories.add(cat);
    }

    /**
     *
     * Registers the Category as a User and adds it to the Registry
     *
     * @param category Category being registered
     * @return True/false if the operation succeeds/fails
     */
    public boolean registerCategory(Category category) {
        return this.addCategory(category);
    }

    public List<Category> getCategories() {
        return categories;
    }
    
    
}
