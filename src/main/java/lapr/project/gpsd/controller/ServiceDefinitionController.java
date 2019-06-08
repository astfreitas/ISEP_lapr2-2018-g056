package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.CategoryRegistry;
import lapr.project.gpsd.utils.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ServiceTypeRegistry;


public class ServiceDefinitionController {

    private Company company;
    private List<Service> services;

    public ServiceDefinitionController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.services = this.company.getServiceRegistry().getServices();
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
  
   /*
    newService(id,bDesc,fDesc,hourlyCost,catId)
    getOtherAtributes()
    setAditionalData(data)
    validate()
    registerService()
    */
}
