package lapr.project.gpsd.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.CategoryRegistry;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ServiceTypeRegistry;
//import lapr.project.gpsd.ui.console.utils.Utils;

public class ServiceDefinitionController {

    private Company company;
    private Service service;

    public ServiceDefinitionController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
    }

    /**
     * 1.1 from design returns a list of service types
     *
     * @return stl -> service types list
     */
    public List<ServiceType> getServiceTypes() {
        ServiceTypeRegistry str = this.company.getServiceTypeRegistry();
        return str.getServiceTypes();
    }

    /**
     * 2.1 from design returns the service type according to the idType selected
     *
     * @param idType
     * @return st -> service type
     */
    public ServiceType getServiceTypeByID(String idType) {
        ServiceTypeRegistry st = this.company.getServiceTypeRegistry();
        return st.getServiceTypeByID(idType);
    }

    /**
     * 3.1 from design returns a list of cetegories
     *
     * @return cl -> categories list
     */
    public List<Category> getCategories() {
        CategoryRegistry cr = this.company.getCategoryRegistry();
        return cr.getCategories();
    }

    // FALTA O REFLECTION
    /**
     * method to instance service withverification by a boolean return type
     *
     * @param id
     * @param bDesc
     * @param fDesc
     * @param hCost
     * @param catId
     * @return
     */
    /*
    public boolean newService(String id, String bDesc, String fDesc, double hCost, String catId) {
        try {
            CategoryRegistry cats = this.company.getCategoryRegistry();
            Category cat = cats.getCatById(catId);

            this.service = this.company.getServiceRegistry().Service(id, bDesc, fDesc, hCost, cat);

            return this.company.getServiceTypeRegistry().getServiceTypes().validateServiceType(this.service);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.service = null;
            return false;
        }
    }
    */

    /*
    public boolean registaServico() {
        return this.company.registerService(this.service);
    }
     */
    
    public String getServicoString() {
        return this.service.toString();
    }
}
