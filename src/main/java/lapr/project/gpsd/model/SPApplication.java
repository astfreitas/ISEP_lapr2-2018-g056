package lapr.project.gpsd.model;

import java.util.List;

/**
 * Service Provider Application created during Use Case 2 - Submit application
 * for Service Provider.
 */
public class SPApplication {

    private String name;
    private String NIF;
    private String phone;
    private String email;
    private Address address;
    private List<Category> categories;
    private List<AcademicCompetence> academicCompetences;
    private List<ProfessionalCompetence> professionalCompetences;

    /**
     * Constructor: creates new instance of SPApplication if String arguments
     * given are not null or empty
     *
     * @param name
     * @param NIF
     * @param phone
     * @param email
     */
    public SPApplication(String name, String NIF, String phone, String email) {
        if ((name == null) || (name.isEmpty())
                || (NIF == null) || (NIF.isEmpty())
                || (phone == null) || (phone.isEmpty())
                || (email == null) || (email.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.name = name;
        this.NIF = NIF;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Returns the name of the applicant
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Fiscal Number of the applicant
     *
     * @return
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Returns the phone number of the applicant
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the email for the applicant
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the address for the applicant
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address for the applicant
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns the list of academic competences of the applicant
     *
     * @return
     */
    public List<AcademicCompetence> getAcademicCompetences() {
        return academicCompetences;
    }

    /**
     * Returns the list of professional competences for the applicant
     *
     * @return
     */
    public List<ProfessionalCompetence> getProfessionalCompetences() {
        return professionalCompetences;
    }

    /**
     * Return the applicant's name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the applicant's fiscal number
     *
     * @param NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Sets the applicant's phone number
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the applicant's email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds a ProfessionalCompetence for the applicantion
     *
     * @param pc
     * @return
     */
    public boolean addProfessionalCompetence(ProfessionalCompetence pc) {
        return this.professionalCompetences.add(pc);
    }

    /**
     * Gets the application's list of categories
     *
     * @return
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Adds a Category to the applicantion
     *
     * @param cat
     * @return
     */
    public boolean addCategory(Category cat) {
        return this.categories.add(cat);
    }

    /**
     * Adds an AcademicCompetence to the application
     *
     * @param ac
     * @return
     */
    public boolean addAcademicCompetence(AcademicCompetence ac) {
        return this.academicCompetences.add(ac);
    }

    /**
     * Creates new Address instance
     *
     * @param local
     * @param postalCode
     * @param address
     * @return Address
     */
    public Address newAddress(String local, String postalCode, String address) {
        return new Address(local, postalCode, address);
    }

    /**
     * Creates a new instance of AcademicCompetence
     *
     * @param course
     * @param level
     * @param grade
     * @return AcademicCompetence instance
     */
    public static AcademicCompetence newAcademicCompetence(String course, String level, double grade) {
        return new AcademicCompetence(course, level, grade);
    }

    /**
     * Creates a new instance of ProfessionalCompetence
     *
     * @param description
     * @return ProfessionalCompetence
     */
    public static ProfessionalCompetence newProfessionalCompetence(String description) {
        return new ProfessionalCompetence(description);
    }

}
