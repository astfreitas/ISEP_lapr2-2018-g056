package lapr.project.gpsd.model;

import lapr.project.gpsd.controller.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AssignmentAlgoritm1 implements IAssignmentAlgoritm {

    private final double THREASHOLD = 0.001;

    Company company;
    ServiceProviderRegistry spRegistry;
    ServiceRequestRegistry requestRegistry;
    IExternalService externalService;

    public AssignmentAlgoritm1() {

    }

    @Override
    public List<ServiceAssignment> assignServices(List<ServiceRequestDescription> services, ISortingBehavior sortingBehavior) {
        this.company = ApplicationGPSD.getInstance().getCompany();
        this.spRegistry = company.getServiceProviderRegistry();
        this.requestRegistry = company.getServiceRequestRegistry();
        this.externalService = company.getExternalService();

        // instantiates the assignment list
        List<ServiceAssignment> assignments = new ArrayList<>();

        // sorts the service list according to the input sorting behavior
        sortingBehavior.sortServiceList(services);

        // assign each service from the list of services, create and add assignment
        for (ServiceRequestDescription service : services) {
            System.out.println("Trying to assign: " + service + "\nFrom request: " + requestRegistry.getRequestFromDescription(service));
//            System.out.println("Request's address is in AGs:\n " + company.getGeographicAreaRegistry().getAreasWithLocale(requestRegistry.getRequestFromDescription(service).getAddress().getPostalCode()));
            ServiceAssignment newAssignment = createAssignment(service);
            if (newAssignment != null) {
                assignments.add(newAssignment);
            }
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
        // gathers the request that originated the service description
        ServiceRequest request = requestRegistry.getRequestFromDescription(srd);
        // gathers the category of the service to be performed
        Category category = srd.getService().getCategory();

        // gathers the schedule preference's list for the service
        List<SchedulePreference> scheduleList = request.getSchedulePreferences();

        // gathers address of service request
        Address address = request.getAddress();

        // gets list of SP's in the system
        List<ServiceProvider> registeredProviders = spRegistry.getServiceProviders();
        System.out.println("Registered SPs:  " + registeredProviders);

        // instantiates list of suitable SP's as copy of available SP's
        List<ServiceProvider> suitableProviders = new ArrayList<>(registeredProviders);

        // filters list of providers by category of service 
        suitableProviders = filterByCategory(suitableProviders, category);
        System.out.println("SP's list after category filter: " + suitableProviders);
        // filters list of providers by address of service
        suitableProviders = filterByAddress(suitableProviders, address);
        System.out.println("SP's list after address filter: " + suitableProviders);

        // filters list of providers by availability
        suitableProviders = filterByAvailability(suitableProviders, scheduleList, srd.getDuration());
        System.out.println("SP's list after schedule filter: " + suitableProviders);

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
        if (suitableSPs == null) {
            return null;
        }
        ServiceRequest request = requestRegistry.getRequestFromDescription(srd);
        Address address = request.getAddress();

        Comparator<ServiceProvider> orderRatings = new Comparator<ServiceProvider>() {
            @Override
            public int compare(ServiceProvider sp1, ServiceProvider sp2) {
                double rating1 = sp1.getAverageRating();
                double rating2 = sp2.getAverageRating();
                if (Math.abs(rating1 - rating2) / rating1 < THREASHOLD) {
                    return 0;
                } else if (rating1 < rating2) {
                    return -1;
                }
                return 1;
            }
        };

        Comparator<ServiceProvider> orderDistance = new Comparator<ServiceProvider>() {
            @Override
            public int compare(ServiceProvider sp1, ServiceProvider sp2) {
                double dist1 = externalService.getDistanceBetCP(address.getPostalCode(), sp1.getSpAddress().getPostalCode());
                double dist2 = externalService.getDistanceBetCP(address.getPostalCode(), sp2.getSpAddress().getPostalCode());
                if (Math.abs(dist1 - dist2) / dist1 < THREASHOLD) {
                    return 0;
                } else if (dist1 < dist2) {
                    return -1;
                }
                return 1;
            }
        };

        Comparator<ServiceProvider> orderName = new Comparator<ServiceProvider>() {
            @Override
            public int compare(ServiceProvider sp1, ServiceProvider sp2) {
                String name1 = sp1.getName();
                String name2 = sp2.getName();
                return name1.compareTo(name2);
            }
        };

        Comparator<ServiceProvider> order = orderRatings.thenComparing(orderDistance).thenComparing(orderName);
        suitableSPs.sort(order);
        if (suitableSPs.isEmpty()) {
            return null;
        }
        return suitableSPs.get(0);
    }

    /**
     * Manipulates the provided list of SP's to remove those that do not perform
     * services of the category given as argumentS
     *
     * @param spList
     * @param cat
     * @return
     */
    public List<ServiceProvider> filterByCategory(List<ServiceProvider> spList, Category cat) {
        System.out.println("Filtering SP's by category");
        System.out.println("Request's category: " + cat);
        List<ServiceProvider> spFilteredList = new ArrayList<>();
        for (ServiceProvider sp : spList) {
            System.out.println("SP under inspection: " + sp);
            System.out.println("SP's categories:\n " + sp.getSpCatList().toString());
            if (sp.hasCategory(cat)) {
                System.out.println("SP " + sp + " matched service!");
                spFilteredList.add(sp);
            }

        }
        return spFilteredList;
    }

    /**
     * Manipulates the provided list of SP's to remove those that is not
     * availabe at given schedule
     *
     * @param spList
     * @param scheduleList
     * @return
     */
    public List<ServiceProvider> filterByAvailability(List<ServiceProvider> spList, List<SchedulePreference> scheduleList, int duration) {
        System.out.println("Filtering SP's by availability");
        System.out.println("Request's schedules: " + scheduleList.toString());
        List<ServiceProvider> spFilteredList = new ArrayList<>();
        for (ServiceProvider sp : spList) {
            System.out.println("SP under inspection: " + sp);
            System.out.println("SP's availabilities: \n" + sp.getSpAvailabilityList().getAvailabilityList().toString());
            for (SchedulePreference schedule : scheduleList) {
                System.out.println("Testing for schedule: " + schedule);
                if (sp.isAvailable(schedule, duration)) {
                    System.out.println("Schedule match for sp: " + sp);
                    spFilteredList.add(sp);
                    break;
                }
            }
        }
        return spFilteredList;
    }

    /**
     * Manipulates the provided list of SP's to remove those that are not able
     * to work in the address given as argument.The SP's are tested for all
     * geographic areas containing said address
     *
     * @param spList
     * @param address
     * @return
     */
    public List<ServiceProvider> filterByAddress(List<ServiceProvider> spList, Address address) {
        System.out.println("Filtering SP's geographic area");
        List<GeographicArea> areas = company.getGeographicAreaRegistry().getAreasWithLocale(address.getPostalCode());
        System.out.println("Request's GAs: " + areas.toString());
        List<ServiceProvider> spFilteredList = new ArrayList<>();
        for (ServiceProvider sp : spList) {
            System.out.println("SP under inspection: " + sp);
            System.out.println("SP's GAs: \n" + sp.getSpGeoAreaList().toString());
            for (GeographicArea area : areas) {
                if (sp.hasGeographicArea(area)) {
                    spFilteredList.add(sp);
                    System.out.println("SP " + sp + " matched service!");
                    break;
                }
            }
        }
        return spFilteredList;
    }

    public ServiceAssignment createAssignment(ServiceRequestDescription service) {
        // for every service gets a list of suitable service providers
        List<ServiceProvider> suitableSPs = getSuitableSPList(service);
        if (suitableSPs.isEmpty()) {
            System.out.println("Unable to find suitable service providers");
            return null;
        } else {
            System.out.println("Suitable sps found: " + suitableSPs);
        }

        // selects the most suitable
        ServiceProvider selectedSP = selectMostSuitableSP(suitableSPs, service);
        System.out.println("Most suitable sp: " + selectedSP);
        // gets the request that originated the service description
        ServiceRequest request = requestRegistry.getRequestFromDescription(service);

        // returns the schedule preference list
        List<SchedulePreference> scheduleList = request.getSchedulePreferences();

        // returns the schedule suitable for the assignment
        SchedulePreference selectedSchedule = selectedSP.getSpAvailabilityList().matchSchedule(scheduleList, service.getDuration());

        // creates the assignment instance
        ServiceAssignment assignment = new ServiceAssignment(selectedSP, service, request, selectedSchedule);

        // removes the service duration interval from the SP's availability
//        selectedSP.getSpAvailabilityList().splitAvailability(selectedSchedule, service.getDuration());
        // returns the newly created assignment
        System.out.println("Assignment successfuly created :" + assignment);
        return assignment;
    }
}
