package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.*;

/**
 * Controller for UC2 : Service Provider Application Submission
 */
public class SubmitApplicationController {

    private Company company;
    private SPApplicationRegistry spar;
    private SPApplication spa;
    private CategoryRegistry cr;

    /**
     * Constructor: retrieves the Company instance
     */
    public SubmitApplicationController() {
        this.company = ApplicationGPSD.getInstance().getCompany();
    }

    /**
     * Adds AcademicQualification instance to new SPApplication
     *
     * @param course Course
     * @param level Level
     * @param grade Grade
     * @return true if AcademicQualification is successfully instantiated and
     * added to the SPApplication
     */
    public boolean addAcademicCompetence(String course, String level, double grade) {
        AcademicCompetence ac = spa.newAcademicCompetence(course, level, grade);
        return spa.addAcademicCompetence(ac);
    }

    /**
     * Adds ProfessionalQualification instance to new SPApplication
     *
     * @param description Professional Qualification description
     * @return true if ProfessionalQualification is successfully instantiated
     * and added to the SPApplication
     */
    public boolean addProfessionalCompetence(String description) {
        ProfessionalCompetence pc = spa.newProfessionalCompetence(description);
        return spa.addProfessionalCompetence(pc);
    }

    /**
     * Creates instance of SPApplication
     *
     * @param name Name
     * @param NIF NIF
     * @param phone Phone
     * @param email Email
     * @return true if the SPApplication is successfully instantiated
     */
    public boolean newSPApplication(String name, String NIF, String phone, String email) {
        this.spar = company.getSPApplicationRegistry();
        this.spa = spar.newSPApplication(name, NIF, phone, email);
        this.cr = company.getCategoryRegistry();
        return this.spar != null;
    }

    /**
     * Creates new instance of Address and adds to the SPApplication
     *
     * @param local Local
     * @param postalCode Postal Code
     * @param address Address
     * @return true if Address is successfully instantiated
     */
    public boolean newAddress(String local, String postalCode, String address) {
        Address a = spa.newAddress(local, postalCode, address);
        spa.setAddress(a);
        return a != null;
    }

    /**
     * Adds the selected Category (given the Category id) to the SPApplication
     *
     * @param catId Category's id
     * @return The success of the operation
     */
    public boolean addCategory(String catId) {
        Category cat = cr.getCatById(catId);
        return spa.addCategory(cat);
    }

    /**
     * Get List of Categories registered in the Company's CategoryRegistry
     *
     * @return List of Categories
     */
    public List<Category> getCategories() {
        List<Category> categories = cr.getCategories();
        return categories;
    }

    /**
     * Registers the SPApplication created during the Use Case into the
     * Company's SPApplicationRegistry
     *
     * @return true if SPApplication's addition into Registry is successful
     */
    public boolean registerApplication() {
        return spar.registerApplication(spa);
    }

    /**
     * Validates if all fields required for the SPApplication are filled
     * (i.e.all SPApplication attributes)
     *
     */
    public void validateApplication() {
        spar.validateApplication(spa);
    }

    public SPApplication getApplication() {
        return spa;
    }

    /**
     * Validates if category is not repeated in SPApplication
     *
     * @param catId
     * @return true if category has not yet been added do spapplication
     */
    public boolean validateCategory(String catId) {
        Category cat = cr.getCatById(catId);
        if (cat == null) {
            return false;
        }
        return !spa.getCategories().contains(cat);
    }

}
