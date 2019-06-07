package lapr.project.gpsd.model;

import java.util.List;

public interface IAssignmentAlgoritm {

    /**
     * Takes a List of ServiceDescriptions not yet assigned (assigned attribute
     * false) and assign each one to an available Service Provider using rules
     * defined by the algoritm.The AssignmentAlgoritm implementation differs in
     * the order in which services from a service request are assigned (sorting
     * behavior).
     *
     * Examples are FIFO and random sorting
     *
     * @param services
     * @param sortingBehavior
     * @return List of new Service Assignments to be added to Registry
     */
    public List<ServiceAssignment> assignServices(List<ServiceRequestDescription> services, ISortingBehavior sortingBehavior);

}
