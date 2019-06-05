
package lapr.project.gpsd.model;

//falta o método newService + enums
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
     * returns the type of service with all its attributes
     * @return idType and type name
     */
    @Override
    public String toString() {
        return "ServiceType{" + "id=" + idType + ", typeName=" + typeName + '}';
    }
    
    
    
    
}
