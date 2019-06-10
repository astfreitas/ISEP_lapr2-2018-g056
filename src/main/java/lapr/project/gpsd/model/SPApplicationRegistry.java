package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

public class SPApplicationRegistry {

    /**
     * a list of applictaions as attribute of SPApplicationRegistry
     */
    private List<SPApplication> applications;

    /**
     * constructor of SPApplicationRegistry initialized with an empty arraylist.
     */
    public SPApplicationRegistry() {
        this.applications = new ArrayList<>();
    }

    /**
     * returns a list of applications
     *
     * @return
     */
    public List<SPApplication> getApplications() {
        return applications;
    }

    /**
     * searchs for an application by a specific NIF
     *
     * @param NIF
     * @return founded application
     */
    public SPApplication getApplicationByNIF(String NIF) {
        for (SPApplication application : applications) {
            if (application.hasNIF(NIF)) {
                return application;
            }
        }
        return null;
    }

    /**
     * returns a list of only accepted applications
     *
     * @param applicationStatus of the service provider
     * @return list of only accepted applications
     */
    public ArrayList<SPApplication> getAcceptedApplications(String applicationStatus) {
        ArrayList<SPApplication> acceptedApplications = new ArrayList<>();
        for (SPApplication acceptedApplication : acceptedApplications) {
            if (acceptedApplication.isAccepted(applicationStatus)) {
                acceptedApplications.add(acceptedApplication);
            }
        }
        return acceptedApplications;
    }

    /**
     *
     * @param name
     * @param NIF
     * @param phone
     * @param email
     * @return
     */
    public SPApplication newSPApplication(String name, String NIF, String phone, String email) {
        return new SPApplication(name, NIF, phone, email);
    }

    /**
     * Validates if SPApplication is a valid instance and if it has non-empty
     * attributes (category, academic and professional competences lists)
     *
     * @param spa
     * @return
     */
//    public boolean validateApplication(SPApplication spa) {
//        if (spa != null
//                && !spa.getCategories().isEmpty()
//                && !spa.getAcademicCompetences().isEmpty()
//                && !spa.getProfessionalCompetences().isEmpty()) {
//            return true;
//        }
//        return false;
//    }
    public void validateApplication(SPApplication spa) {
        if (spa.getCategories().isEmpty()) {
            throw new RuntimeException("Application is missing categories");
        }
        if (spa.getAcademicCompetences().isEmpty()) {
            throw new RuntimeException("Application is missing academic competences");
        }
        if (spa.getProfessionalCompetences().isEmpty()) {
            throw new RuntimeException("Application is missing professional competences");
        }
    }

    /**
     * Registers the Service Provider application and adds it to the Registry
     *
     * @param spa Service Provider application
     * @return True/false if the operation succeeds/fails
     */
    public boolean registerApplication(SPApplication spa) {
        return this.applications.add(spa);
    }

}
