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
     * @param course
     * @param level
     * @param grade
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
     * @param description
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
     * @param name
     * @param NIF
     * @param phone
     * @param email
     * @return true if the SPApplication is successfully instantiated
     */
    public boolean newSPApplication(String name, String NIF, String phone, String email) {
        this.spar = company.getSPApplicationRegistry();
        this.spa = spar.newSPApplication(name, NIF, phone, email);
        return this.spar != null;
    }

    /**
     * Creates new instance of Address and adds to the SPApplication
     *
     * @param local
     * @param postalCode
     * @param address
     * @return true if Address is successfully instantiated and added to
     * SPApplication
     */
    public boolean newAddress(String local, String postalCode, String address) {
        return spa.setAddress(local, postalCode, address);
    }

    /**
     * Adds the selected Category (given the Category id) to the SPApplication
     *
     * @param catId
     * @return
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
        return cr.getCategories();
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
     * Validates if all fields required for the SPApplication are filled (i.e.
     * all SPApplication attributes)
     *
     * @return returns true if none of SPApplication's attributes is null or
     * empty
     */
    public boolean validateApplication() {
        return spar.validateApplication(spa);
    }

}
