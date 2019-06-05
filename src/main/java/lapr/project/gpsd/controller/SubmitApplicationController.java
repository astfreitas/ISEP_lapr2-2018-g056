package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.*;

/**
 * Controller for UC2 : Service Provider Application Submission *review CD
 */
public class SubmitApplicationController {

    private Company company;
    private SPApplicationRegistry spar;
    private SPApplication spa;
    private CategoryRegistry cr;
    private Category cat;
    private Address a;

    public SubmitApplicationController() {
        this.company = AplicacaoGPSD.getInstance().getEmpresa();
    }

    public boolean addAcademicQualification() {
        return true;
    }

    public boolean addProfessionalQualification() {
        return true;
    }

    public boolean newSPApplication(String name, String NIF, String phone, String email) {
        this.spar = company.getSPApplicationRegistry();
        this.spa = spar.newSPApplication(name, NIF, phone, email);
        return true;
    }
    
    public boolean newAddress(String local, String postalCode, String address) {
        return spa.setAddress(local, postalCode, address);
    }

    public boolean addCategory(String catId) {
        this.cat = cr.getCatById(catId);
        this.spa.addCategory(cat);
        return true;
    }

    public List<Category> getCategories() {
        return cr.getCategories();
    }

    public boolean registerApplication() {
        return spar.registerApplication(spa);
    }
    
    public boolean validateApplication() {
        return spar.validateApplication(spa);
    }

}
