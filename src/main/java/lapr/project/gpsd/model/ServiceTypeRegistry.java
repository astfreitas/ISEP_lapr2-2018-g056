package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr.project.gpsd.utils.Constants;

public class ServiceTypeRegistry {

    /**
     * list of the existing service types
     */
    private List<ServiceType> serviceTypes;

    /**
     * constructor of service type registry
     */
    public ServiceTypeRegistry() {
        serviceTypes = new ArrayList<>();
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
     * Add service type  to list
     *
     * @param idType
     * @param caminhoClass
     * @return true or false as the operation succeeds to add service to the
     * ArrayList serviceTypes
     */
    public boolean addServiceType(ServiceType serviceType) {
        return serviceTypes.add(serviceType);

    }

    /**
     * build supported service types
     *
     * @param props
     */
    public void createSupportedServiceTypes(Properties props) {
        try {
            // know how many ServiceTypes are supported
            String qttServiceTypes = props.getProperty(Constants.PARAMS_NUMBER_SERVICE_TYPES);
            int qtt = Integer.parseInt(qttServiceTypes);

            // for each type of service supported creates the respective instance  
            for (int i = 1; i <= qtt; i++) {
                String serviceName = props.getProperty(Constants.PARAMS_SERVICE_TYPE_SIGNATURE + i);
                String servicePath = Constants.PARAMS_MODEL_PATH + "." + serviceName;
                ServiceType serviceType = new ServiceType(String.valueOf(i), serviceName, servicePath);
                serviceTypes.add(serviceType);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
