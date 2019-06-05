package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;

class ServiceAssignmentRegistry {
    List<ServiceAssignment> serviceAssignments = new ArrayList<>();


    public List<ServiceAssignment> getServiceAssignments() {
        return serviceAssignments;
    }
    
    public boolean addServiceAssignment(ServiceAssignment sa) {
        return this.serviceAssignments.add(sa);
    }
    
}
