/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IAssignmentAlgoritmTest {
  
    /**
     * Test of assignServices method, of class IAssignmentAlgoritm.
     */
    @Disabled
    public void testAssignServices() {
        System.out.println("assignServices");
        List<ServiceRequestDescription> services = null;
        ISortingBehavior sortingBehavior = null;
        IAssignmentAlgoritm instance = new IAssignmentAlgoritmImpl();
        List<ServiceAssignment> expResult = null;
        List<ServiceAssignment> result = instance.assignServices(services, sortingBehavior);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IAssignmentAlgoritmImpl implements IAssignmentAlgoritm {

        public List<ServiceAssignment> assignServices(List<ServiceRequestDescription> services, ISortingBehavior sortingBehavior) {
            return null;
        }
    }
    
}
