package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

// confirmar a utilização de reflection (path para as classes)

public class ServiceTypeRegistry {

    /**
     * list of the existing service types
     */
    private List<ServiceType> serviceTypes;

    /**
     * constructor of service type registry
     */
    public ServiceTypeRegistry() {
        serviceTypes = new ArrayList();
    }

    /**
     * returns service types
     *
     * @return service types
     */
    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    /**
     * returns service types by id
     *
     * @param idType
     * @return service types by id
     */
    public ServiceType getServiceTypeByID(String idType) {
        for (ServiceType st : serviceTypes) {
            if (st.hasId(idType)) {
                return st;
            }
        }
        return null;
    }
       
    /**
     * validates if a service type already exists in the existing list
     * @param idType
     * @param caminhoClass
     * @return true or false
     */
    public boolean validateServiceType(String idType, String caminhoClass) {
        if(getServiceTypeByID(idType)!=null) {
            return false;
        }
        try {
            Class<?> servClass = Class.forName(caminhoClass);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Add service type with attributes
     * @param idType
     * @param caminhoClass
     * @return true or false as the operation succeeds to add service to the ArrayList serviceTypes
     */
    public boolean addServiceType(String idType, String caminhoClass) {
        if(validateServiceType(idType, caminhoClass)) {
            return serviceTypes.add(new ServiceType(idType, caminhoClass));
        }
        return false;
    }


}
