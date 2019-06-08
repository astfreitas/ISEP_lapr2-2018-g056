
package lapr.project.gpsd.model;

import java.lang.reflect.*;


public class ServiceType {
    
    /**
     * service type atributes
     */
    String idType;
    private String typeName;

    /**
     * constructor with 2 parameters
     * @param idType
     * @param typeName 
     */
    public ServiceType(String id, String typeName) {
        this.idType = id;
        this.typeName = typeName;
    }

    /**
     * returns type name
     * @return typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * checks if the type name has idType, returning a boolean
     * @param typeName
     * @return true or false
     */
    public boolean hasId(String typeName) {
        return idType.equalsIgnoreCase(typeName);
    }
    
    /**
     * method to create new service with 5 parameters
     * @param id
     * @param briefDescription
     * @param fullDescription
     * @param hourlyCost
     * @param category
     * @return service instance
     */
    public Service newService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
        try {
            Class<?> oClass = Class.forName(typeName);
            Constructor constructor = oClass.getConstructor(new Class[]{String.class, String.class, String.class, Double.class, Category.class});
            Service serviceInstance = (Service) constructor.newInstance(new Object[]{id, briefDescription, fullDescription, hourlyCost, category});
            
            return serviceInstance;
            
        } catch ( ClassNotFoundException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | SecurityException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * returns the type of service with all its attributes
     * @return idType and type name
     */
    @Override
    public String toString() {
        return "ServiceType{" + "id=" + idType + ", typeName=" + typeName + '}';
    }
   
}
