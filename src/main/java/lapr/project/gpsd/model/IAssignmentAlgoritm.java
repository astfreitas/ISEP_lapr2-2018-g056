package lapr.project.gpsd.model;

import java.util.List;

public interface IAssignmentAlgoritm {

    /**
     * Takes the List of ServiceDescriptions not yet assigned (assigned
     * attribute false) and assign each one to an available Service Provider
     * according to the following criteria:
     *
     * 1.2. 3.

 The AssignmentAlgoritm implementation differs in the scheduling of
 ServiceDescriptions (FIFO, random, etc)
     *
     * @param sqr
     * @param spr
     * @return List of new Service Assignments to be added to Registry
     */
    public List<ServiceAssignment> assignServices(ServiceRequestRegistry sqr, ServiceProviderRegistry spr);
}
