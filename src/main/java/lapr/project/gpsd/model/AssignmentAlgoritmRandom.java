package lapr.project.gpsd.model;

import lapr.project.gpsd.controller.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentAlgoritm1 implements IAssignmentAlgoritm {

    Company company;
    ServiceProviderRegistry spRegistry;
    ServiceRequestRegistry requestRegistry;

    public AssignmentAlgoritm1() {
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.spRegistry = company.getServiceProviderRegistry();
        this.requestRegistry = company.getServiceRequestRegistry();
    }

    @Override
    public List<ServiceAssignment> assignServices(List<ServiceRequestDescription> services, ISortingBehavior sortingBehavior) {

        // instantiates the assignment list
        List<ServiceAssignment> assignments = new ArrayList<>();

        // sorts the service list according to the input sorting behavior
        sortingBehavior.sortServiceList(services);

        // assign each service from the list of services
        for (ServiceRequestDescription service : services) {
            // for every service gets a list of suitable service providers
            List<ServiceProvider> suitableSPs = getSuitableSPList(service);

            // selects the most suitable
            ServiceProvider selectedSP = selectMostSuitableSP(suitableSPs, service);

            // gets the request that originated the service description
            // *** is there an easier way?
            ServiceRequest request = requestRegistry.getRequestFromDescription(service);

            // returns the schedule preference list
            List<SchedulePreference> schedule = request.getSchedulePreferences();

            // returns the schedule suitable for the assignment
            // to-do
            
            // creates the assignment instance
            // ServiceAssignment assignment = new ServiceAssignment(selectedSP, service, request, schedule);
            
            // adds the assignment to the list
            // assignments.add(assignment);
            
            // removes the service duration interval from the SP's availability
            // whooo
        }

        // returns list of assignments
        return assignments;
    }

    /**
     * The following verifications are made in order to filter a set of service
     * providers suitable to be assigned to a service from a service request.
     *
     * 1. The SP should act in the same GA in which the service was requested.
     *
     * 2. The SP should provide services from the same category as the service
     *
     * 3. The SP should have an availability compatible with one of the
     * request's scheduling preference
     *
     * @param srd
     * @return list of SP's suitable to perform a Service from a request
     */
    public List<ServiceProvider> getSuitableSPList(ServiceRequestDescription srd) {
        // gets list of SP's in the system
        List<ServiceProvider> registeredProviders = spRegistry.getServiceProviders();
        // instantiates list of suitable SP's
        List<ServiceProvider> suitableProviders = new ArrayList<>();
        // gathers the request that originated the service description
        ServiceRequest request = requestRegistry.getRequestFromDescription(srd);
        // gathers the areas encompassing the service's request address
        List<GeographicArea> areas = company.getGeographicAreaRegistry().getAreasWithLocale(request.getAddress().getPostalCode());
        // gathers the category of the service to be performed
        Category category = srd.getService().getCategory();
        // gathers the schedule preference's list for the service
        List<SchedulePreference> scheduleList = request.getSchedulePreferences();

        // for each SP perform verifications
        for (ServiceProvider sp : registeredProviders) {
            // works in any GA containing the request's address
            for (GeographicArea area : areas) {
                if (sp.worksInGeographicArea(area)) {
                    // has the category of the service
                    if (sp.providesServicesOfCategory(category)) {
                        // has available in any of the scheduled preferences
                        for (SchedulePreference schedule : scheduleList) {
                            if (sp.isAvailable(schedule)) {
                                suitableProviders.add(sp);
                            }
                        }
                    }
                }
            }
        }
        return suitableProviders;
    }

    /**
     * The following criteria are used (in the presented order) to define the
     * chosen SP from the list of suitable service providers
     *
     * 1. The SP with highest average rating is chosen
     *
     * 2. The SP with whose address is the least distant from the service's
     * request address selected by the Client is chosen
     *
     * 3. The SP whose name comes first in alphabetic order is chosen
     *
     * @param suitableSPs
     * @param srd
     * @return the most suitable SP for assignment from list
     */
    public ServiceProvider selectMostSuitableSP(List<ServiceProvider> suitableSPs, ServiceRequestDescription srd) {

        return null;
    }

}
