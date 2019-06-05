package lapr.project.gpsd.model;

import java.util.List;
import lapr.project.gpsd.controller.*;
import java.util.TimerTask;

public class AssignServiceTask extends TimerTask {

    @Override
    public void run() {
        Company company = AplicacaoGPSD.getInstance().getEmpresa();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        ServiceRequestRegistry sqr = company.getServiceRequestRegistry();
        ServiceAssignmentRegistry sar = company.getServiceAssignementRegistry();
        IAssignmentAlgoritm alg = company.getAssignmentAlgoritm();
        List<ServiceAssignment> sal = alg.assignServices(sqr, spr);
        for(ServiceAssignment sa : sal) {
            sar.addServiceAssignment(sa);
        }
    }

}
