package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.Category;
import lapr.project.gpsd.model.CategoryRegistry;
import lapr.project.gpsd.utils.Constants;
import lapr.project.gpsd.model.Company;
import lapr.project.gpsd.model.Service;
import lapr.project.gpsd.model.ServiceRegistry;
import lapr.project.gpsd.model.ServiceType;
import lapr.project.gpsd.model.ServiceTypeRegistry;

public class ServiceDefinitionController {

    /**
     * atributes of class ServiceDefinitionController
     */
    private Company company;
    private Category category;
    private Service service;
    private List<Service> services;
    private ServiceRegistry serviceRegistry;

    /**
     * Creates an instance of ServiceDefinitionController
     */
    public ServiceDefinitionController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_ADMINISTRATIVE)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.services = this.company.getServiceRegistry().getServices();
    }

    /**
     * 1.1 from design: returns a list of service types
     *
     * @return stl -> service types list
     */
    public List<ServiceType> getServiceTypes() {
        ServiceTypeRegistry str = this.company.getServiceTypeRegistry();
        return str.getServiceTypes();
    }

    /**
     * 2.1 from design: returns the service type according to the idType selected
     *
     * @param idType
     * @return st -> service type
     */
    public ServiceType getServiceTypeByID(String idType) {
        ServiceTypeRegistry st = this.company.getServiceTypeRegistry();
        return st.getServiceTypeByID(idType);
    }

    /**
     * 3.1 from design: returns a list of cetegories
     *
     * @return cl -> categories list
     */
    public List<Category> getCategories() {
        CategoryRegistry cr = this.company.getCategoryRegistry();
        return cr.getCategories();
    }

    /**
     * 4.1 from design: Sets the sequence of methods necessary to create a valid Service
     *
     * @param id service id
     * @param bDesc brief description
     * @param fDesc full description
     * @param hourlyCost hourly cost
     * @param catId category id
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean newService(String id, String bDesc, String fDesc, double hourlyCost, String catId) {
        this.category = this.company.getCategoryRegistry().getCatById(catId);
        this.service = this.company.getServiceTypeRegistry().getServiceTypeByID(id).newService(id, fDesc, fDesc, hourlyCost, category);

        return false;

    }

    /**
     * Sets the sequence of methods necessary to validate a service
     *
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean validate() {
        return this.company.getServiceRegistry().validateService(service);
    }

    /**
     * Sets the sequence of methods necessary to register a valid service
     *
     * @return True/false if the operation succeeds or doesn't
     */
    public boolean registerService() {
        return this.company.getServiceRegistry().registerService(service);
    }

    /**
     * Gets the created Service
     *
     * @return service
     */
    public Service getService() {
        return this.service;
    }

    /*
     --> newService(id,bDesc,fDesc,hourlyCost,catId)
    getOtherAtributes()
    setAditionalData(data)
     ok -> validate()
     ok -> registerService()
     */
}
