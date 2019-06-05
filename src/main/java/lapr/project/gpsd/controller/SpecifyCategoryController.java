package lapr.project.gpsd.controller;

import lapr.project.gpsd.model.*;

public class SpecifyCategoryController {

    private Company company;
    private Category category;
    private CategoryRegistry categoryRegistry;

    /**
     * 
     * Creates an instance of SpecifyCategoryController
     * 
     */
    public SpecifyCategoryController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }

    /**
     * 
     * Sets the sequence of methods necessary to create a valid Category
     * 
     * @param code Category's unique code
     * @param description Category's description
     * @return 
     */
    public boolean newCategory(String code, String description) {
        this.categoryRegistry = company.getCategoryRegistry();
        this.category = this.categoryRegistry.newCategory(code, description);
        return this.categoryRegistry.validateCategory(this.category);
    }

    /**
     * 
     * Sets the sequence of methods necessary to register a valid Client
     * 
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean registerCategory() {
        return this.categoryRegistry.registerCategory(this.category);
    }
    
     /**
     * 
     * Gets the created Category
     * 
     * @return Category
     */
    public Category getCategory(){
        return this.category;
    }
}
