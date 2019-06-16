package lapr.project.gpsd.model;

import java.lang.reflect.*;

public class ServiceType {

    /**
     * service type attributes
     */
    String id;
    private String name;
    private String classPath;

    /**
     * constructor with 2 parameters
     *
     * @param id id 
     * @param name name
     * @param path path
     */
    public ServiceType(String id, String name, String path) {
        try {
            Class.forName(path);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Service type cannot be initialized. \"" + name + "\" class not found.");
        }
        this.id = id;
        this.name = name;
        this.classPath = path;
    }

    /**
     * returns type name
     *
     * @return typeName
     */
    public String getName() {
        return name;
    }

    /**
     * checks if the type name has idType, returning a boolean
     *
     * @param typeName type name
     * @return true or false
     */
    public boolean hasId(String typeName) {
        return id.equalsIgnoreCase(typeName);
    }

    /**
     * method to create new service with 5 parameters
     *
     * @param id id 
     * @param briefDescription brief Description
     * @param fullDescription full Description
     * @param hourlyCost hourly Cost
     * @param category category
     * @return service instance
     */
    public Service newService(String id, String briefDescription, String fullDescription, double hourlyCost, Category category) {
        if ((id == null) || (id.isEmpty())
                || (briefDescription == null) || (briefDescription.isEmpty())
                || (fullDescription == null) || (fullDescription.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        if (hourlyCost <= 0) {
            throw new IllegalArgumentException("The cost has to be a number greater than zero.");
        }
        try {
            Class<?> oClass = Class.forName(classPath);
            Constructor constructor = oClass.getConstructor(String.class, String.class, String.class, double.class, Category.class);
            Service serviceInstance = (Service) constructor.newInstance(id, briefDescription, fullDescription, hourlyCost, category);
            return serviceInstance;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            throw new RuntimeException("Unable to create service. " + e.getMessage());
        }
    }

    /**
     * returns the type of service with all its attributes
     *
     * @return idType and type name
     */
    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

}
