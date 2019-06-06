package lapr.project.gpsd.model;

import java.util.List;

public class SPApplication {

    private String name;
    private String NIF;
    private String phone;
    private String email;
    private Address address;
    private List<Category> categories;
    private List<AcademicCompetence> academicCompetences;
    private List<ProfessionalCompetence> professionalCompetences;

    public SPApplication(String name, String NIF, String phone, String email, Address address) {
        this.name = name;
        this.NIF = NIF;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getNIF() {
        return NIF;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<AcademicCompetence> getAcademicCompetences() {
        return academicCompetences;
    }

    public List<ProfessionalCompetence> getProfessionalCompetences() {
        return professionalCompetences;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean addProfessionalCompetence(ProfessionalCompetence pc) {
        return this.professionalCompetences.add(pc);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean addCategory(Category cat) {
        return this.categories.add(cat);
    }

    public boolean addAcademicCompetence(AcademicCompetence ac) {
        return this.academicCompetences.add(ac);
    }
    
    public boolean setAddress(String local, String postalCode, String address) {
        Address a = new Address(local, postalCode, address);
        this.address = a;
        return this.address != null;
    }

    public AcademicCompetence newAcademicCompetence(String course, String level, double grade) {
        return new AcademicCompetence(course, name, grade);
    }
    
    public ProfessionalCompetence newProfessionalCompetence(String description) {
        return new ProfessionalCompetence(description);
    }

}
