package lapr.project.gpsd.model;

import java.util.List;

public class SPApplicationRegistry {
    private List<SPApplication> applications;

    public List<SPApplication> getApplications() {
        return applications;
    }
    
    public SPApplication newSPApplication(String name, String NIF, String phone, String email) {
        return null;
    }
    
    public boolean validateApplication(SPApplication spa) {
        return true;
    }
    
            
    public boolean registerApplication(SPApplication spa) {
        return this.applications.add(spa);
    }
    
    
}
