package lapr.project.gpsd.model;

import java.util.List;

public interface IAssignmentAlgoritm {

    /**
     * Takes a List of ServiceDescriptions not yet assigned (assigned attribute
     * false) and assign each one to an available Service Provider 
     *
     * The AssignmentAlgoritm implementation differs in the scheduling of
     * ServiceDescriptions (FIFO, random, etc)
     *
     * @param services
     * @return List of new Service Assignments to be added to Registry
     */
    public List<ServiceAssignment> assignServices(List<ServiceRequestDescription> services);
}
