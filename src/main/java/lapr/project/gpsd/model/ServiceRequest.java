package lapr.project.gpsd.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceRequest {
    
    private int number;
    private Date date;
    private double total;
    private Client client;
    private Address address;
    private List<ServiceRequestDescription> serviceRequestDescriptions;
    private List<SchedulePreference> schedulePreferences;
    
    
    /**
     * Constructor creates a service request with client and address where the service will be executed
     * @param client instance of client that requested the service
     * @param address instance of address where the service will be executed
     */
    ServiceRequest(Client client, Address address) {
        this.client = client;
        this.address = address;
        this.serviceRequestDescriptions = new ArrayList();
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * Method adds a new service with clients preferences to the Service Request
     * @param service the service requested by the client
     * @param desc notes from the client
     * @param dur the duration of the service
     */
    public boolean addServiceRequestDescription(Service service, String desc, int dur) {
        ServiceRequestDescription srd = new ServiceRequestDescription(service, desc, dur);
        if(validateServiceRequestDescription(srd)) {
            serviceRequestDescriptions.add(srd);
        }
        return false;
    }
    /**
     * Method validates if the service already exists in the Service Request
     * @param servRequest instance of ServiceRequestDescription
     * @return true if the service does not exist in the service request
     */
    private boolean validateServiceRequestDescription(ServiceRequestDescription servRequest) {
        return !serviceRequestDescriptions.contains(servRequest);
    }
    
    
    /**
     * Method appends a schedule preference to the Service Order
     * @param date represents the date preference
     * @param time represents the time preference
     */
    public boolean addSchedulePreference(LocalDate date, LocalTime time) {
        int prefOrder = schedulePreferences.size();
        SchedulePreference sh = new SchedulePreference(prefOrder, date, time);
        if(validateSchedulePreference(sh)) {
            return AddSchedulePreference(sh);
        }
    }
    /**
     * 00 - 06
     * Method verifies if the schedule preferences exists and if 
     * @param sh instance of SchedulePreference
     * @return returns true if it does not exist
     */
    private boolean validateSchedulePreference(SchedulePreference sh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean AddSchedulePreference(SchedulePreference sh) {
        return schedulePreferences.add(sh);
    }
    
    
    
    
}
