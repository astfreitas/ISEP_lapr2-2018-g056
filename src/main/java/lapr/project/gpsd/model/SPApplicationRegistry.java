package lapr.project.gpsd.model;

import java.util.List;

public class SPApplicationRegistry {

    private List<SPApplication> applications;

    public List<SPApplication> getApplications() {
        return applications;
    }

    public SPApplication newSPApplication(String name, String NIF, String phone, String email) {
        return new SPApplication(name, NIF, phone, email);
    }

    /**
     * Validates if SPApplication is a valid instance and if it has non-empty
     * attributes (category, academic and professional competences lists)
     * @param spa
     * @return 
     */
    public boolean validateApplication(SPApplication spa) {
        if (spa != null
                && !spa.getCategories().isEmpty()
                && !spa.getAcademicCompetences().isEmpty()
                && !spa.getProfessionalCompetences().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean registerApplication(SPApplication spa) {
        return this.applications.add(spa);
    }

}
