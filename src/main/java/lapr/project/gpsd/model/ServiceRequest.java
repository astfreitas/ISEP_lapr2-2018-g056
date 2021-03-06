package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.gpsd.controller.ApplicationGPSD;

public class ServiceRequest {

    private int number;
    private double total;
    private final Client client;
    private final Address address;
    private final List<ServiceRequestDescription> serviceRequestDescriptions;
    private final ArrayList<SchedulePreference> schedulePreferences;
    private final ArrayList<OtherCost> otherCosts;

    /**
     * Constructor creates a service request with client and address where the
     * service will be executed
     *
     * @param client instance of client that requested the service
     * @param address instance of address where the service will be executed
     */
    public ServiceRequest(Client client, Address address) {
        if(client == null) {
            throw new IllegalArgumentException("Client cannot be null.");
        }
        if(address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.client = client;
        this.address = address;
        this.serviceRequestDescriptions = new ArrayList();
        this.schedulePreferences = new ArrayList<>();
        this.otherCosts = new ArrayList<>();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Method adds a new service with clients preferences to the Service Request
     *
     * @param service the service requested by the client
     * @param desc notes from the client
     * @param dur the duration of the service
     * @return Success of the operation
     */
    public boolean addServiceRequestDescription(Service service, String desc, int dur) {
        ServiceRequestDescription srd = new ServiceRequestDescription(service, desc, dur);
        if (validateServiceRequestDescription(srd)) {
            return serviceRequestDescriptions.add(srd);
        }
        return false;
    }

    /**
     * Method validates if the service already exists in the Service Request
     *
     * @param servRequest instance of ServiceRequestDescription
     * @return true if the service does not exist in the service request
     */
    private boolean validateServiceRequestDescription(ServiceRequestDescription servRequest) {
        return !serviceRequestDescriptions.contains(servRequest);
    }

    /**
     * Method appends a schedule preference to the Service Order
     *
     * @param date represents the date preference
     * @param time represents the time preference
     */
    public void addSchedulePreference(LocalDate date, LocalTime time) {
        int prefOrder = schedulePreferences.size();
        SchedulePreference sh = new SchedulePreference(prefOrder, date, time);
        if (validateSchedulePreference(sh)) {
            addSchedulePreferenceObj(sh);
        } else {
            throw new IllegalArgumentException("Duplicated Schedule Preference.");
        }
    }

    /**
     * Method appends a schedule preference to the Service Order
     *
     * @param date represents the date preference
     * @param time represents the time preference
     * @param str str
     * @return Success of the operation
     */
    public boolean addSchedulePreferenceString(LocalDate date, LocalTime time, String str) {
        int prefOrder = schedulePreferences.size();
        SchedulePreference sh = new SchedulePreference(prefOrder, date, time, str);
        if (validateSchedulePreference(sh)) {
            return addSchedulePreferenceObj(sh);
        }
        return false;
    }

    /**
     * Method verifies if the schedule preferences already exists
     *
     * @param sh instance of SchedulePreference
     * @return returns true if it does not exist
     */
    private boolean validateSchedulePreference(SchedulePreference sh) {
        return !schedulePreferences.contains(sh);
    }

     /**
     * Method appends a schedule preference to the Service Order
     *
     * @param sh Schedule Preference
     * @return Success of the operation
     */
    private boolean addSchedulePreferenceObj(SchedulePreference sh) {
        return schedulePreferences.add(sh);
    }

    /**
     *
     * Returns the Client who created the Request
     *
     * @return Client who created the Request
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * 
     * Calculates the sum of the Other Costs and returns it
     * 
     * @return Sum of Other Costs
     */
    public double getOtherCost() {
        double costs = 0;
        for (OtherCost otherCost : otherCosts) {
            costs += otherCost.getValue();
        }
        return costs;
    }

    /**
     * Method calculates the total cost of the Requested Service and other
     * costs(ie travel expenses)
     *
     * @return the cost of total services plus the value of the service
     */
    public double calculateCost() {
        double c = 0;
        otherCosts.clear();
        GeographicAreaRegistry rag = ApplicationGPSD.getInstance().getCompany().getGeographicAreaRegistry();
        PostalCode pc = address.getPostalCode();
        GeographicArea ag = rag.getNearestGeographicArea(pc);
        //não existe area geográfica coberta a cobrir a zona do pedido
        if (ag != null) {
            for (ServiceRequestDescription srd : serviceRequestDescriptions) {
                c += srd.getCost() + ag.getTravelCost();
                OtherCost travelCost = new OtherCost("TravelCost", ag.getTravelCost());
                getOtherCosts().add(travelCost);
            }
            total = c;
        } else {
            total = -1;
        }
        return total;
    }

    /**
     * Method that verifies the client order
     *
     * @return true if it is a valid order
     */
    public boolean validate() {
        //no client
        if (client == null) {
            return false;
        }
        //no address
        if (address == null) {
            return false;
        }
        //no service descriptions atleast 1
        if (serviceRequestDescriptions.isEmpty()) {
            return false;
        }
        //no schedulePreferences atleast 1
        if (schedulePreferences.isEmpty()) {
            return false;
        }
        //se o total for inferior a 0 o pedido não é valido
        if (total < 0) {
            return false;
        }
        return true;
    }

    
    /**
     * Gets the service request number
     * 
     * @return service request number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the service total cost
     * @return service total cost
     */
    public double getTotal() {
        return total;
    }

    /**
     * 
     * Gets the service request address
     * @return service request address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Gets all the service descriptions
     * @return all the service descriptions
     */
    public List<ServiceRequestDescription> getServiceRequestDescriptions() {
        return serviceRequestDescriptions;
    }

    /**
     * Gets all the schedule preferences
     * @return all the schedule preferences
     */
    public ArrayList<SchedulePreference> getSchedulePreferences() {
        return schedulePreferences;
    }

    /**
     * Gets all the other costs
     * @return other costs
     */
    public ArrayList<OtherCost> getOtherCosts() {
        return otherCosts;
    }

    /**
     * Checks if a service is fully assigned
     * @return true if the service is fully assigned
     */
    public boolean fullyAssigned() {
        for (ServiceRequestDescription srd : serviceRequestDescriptions) {
            if (!srd.isAssigned()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the travel expenses
     * @return travel expenses
     */
    public double getTravelExpenses() {
        GeographicAreaRegistry rag = ApplicationGPSD.getInstance().getCompany().getGeographicAreaRegistry();
        PostalCode pc = address.getPostalCode();
        GeographicArea ag = rag.getNearestGeographicArea(pc);
        return ag.getTravelCost() * serviceRequestDescriptions.size();
    }

    /**
     * Returns a String description for the Service Request - mostly used for
     * Consult Service Orders
     *
     * @return String description for the Service Request
     */
    @Override
    public String toString() {
        return "\nService Request " + number + " in the Client: "
                + client.getName() + " at address " + address;
    }

    /**
     * Removes a instance from the ServiceRequestDescription list matching the
     * given by the method parameters
     *
     * @param servRequestDescr reference to the ServRequestDescr to remove
     * @return true if there is a match for the given instance and if, only if
     * it removes from the list. Otherwise returns false.
     */
    public boolean removeServiceRequestDescription(ServiceRequestDescription servRequestDescr) {
        if (servRequestDescr != null) {
            return serviceRequestDescriptions.remove(servRequestDescr);
        }
        return false;
    }

    /**
     * Removes a instance from the SchedulePreference list matching the given in
     * the method parameters.
     *
     * @param schPrefe reference to the SchedulePreference instance to remove
     * @return true if there is a match for the given instance and if, only if
     * it removes from the list. Otherwise returns false.
     */
    public boolean removeSchedulePreferenceFromList(SchedulePreference schPrefe) {
        if (schPrefe != null) {
            return schedulePreferences.remove(schPrefe);
        }
        return false;
    }

    /**
     *
     * Compares two instances of ServiceRequest and returns true/false if they
     * are equals or possess the same atributes
     *
     * @param otherServReq ServiceRequest to compare
     * @return True/false if they are equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherServReq) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherServReq) {
            return true;
        }
        // null check
        if (otherServReq == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherServReq.getClass()) {
            return false;
        }
        // field comparison
        ServiceRequest obj = (ServiceRequest) otherServReq;
        return (Objects.equals(client, obj.client) && Objects.equals(address, obj.address)
                && Objects.equals(serviceRequestDescriptions, obj.serviceRequestDescriptions)
                && Objects.equals(schedulePreferences, obj.schedulePreferences));
    }

    /**
     * Verifies if request has already expired (all schedule preferences have
     * already passed)
     *
     * @return false if any schedule preference has not yet passed
     */
    public boolean isExpired() {
        for (SchedulePreference schedule : schedulePreferences) {
            if (LocalDateTime.now().isBefore(schedule.getDateTime())) {
                return false;
            }
        }
        return true;
    }
}
