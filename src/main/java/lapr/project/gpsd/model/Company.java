package lapr.project.gpsd.model;

import java.io.IOException;
import lapr.project.gpsd.utils.Constants;
import java.util.Properties;
import java.util.Timer;
import lapr.project.authentication.AuthenticationFacade;

public class Company {

    private String designation;
    private String NIF;
    private final AuthenticationFacade authentication;
    private ServiceAssignmentRegistry serviceAssignementRegistry;
    private ServiceOrderRegistry serviceOrderRegistry;
    private ServiceProviderRegistry serviceProviderRegistry;
    private ServiceRegistry serviceRegistry;
    private ServiceRequestRegistry serviceRequestRegistry;
    private ServiceTypeRegistry serviceTypeRegistry;
    private SPApplicationRegistry spApplicationRegistry;
    private CategoryRegistry categoryRegistry;
    private ClientRegistry clientRegistry;
    private GeographicAreaRegistry geographicAreaRegistry;
    private PostalCodeRegistry postalCodeRegistry;
    private IAssignmentAlgoritm assignmentAlgoritm;
    private ISortingBehavior serviceSortingBehavior;
    private FileTypeRegistry fileTypeRegistry;
    private IExternalService externalService;
    private AssignServiceTask task;
    private Timer timer;
    private Properties props;

    /**
     *
     * Creates an instance of Company
     *
     * @param props Company properties
     */
    public Company(Properties props) {
        this.props = props;
        this.designation = props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION);
        this.NIF = props.getProperty(Constants.PARAMS_COMPANY_NIF);
        if ((designation == null) || (NIF == null)
                || (designation.isEmpty()) || (NIF.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }

        this.authentication = new AuthenticationFacade();

        this.serviceAssignementRegistry = new ServiceAssignmentRegistry();
        this.serviceOrderRegistry = new ServiceOrderRegistry();
        this.serviceProviderRegistry = new ServiceProviderRegistry();
        this.serviceRegistry = new ServiceRegistry();
        this.serviceRequestRegistry = new ServiceRequestRegistry();
        this.serviceTypeRegistry = new ServiceTypeRegistry();
        this.spApplicationRegistry = new SPApplicationRegistry();
        this.categoryRegistry = new CategoryRegistry();
        this.clientRegistry = new ClientRegistry();
        this.geographicAreaRegistry = new GeographicAreaRegistry();
        this.postalCodeRegistry = new PostalCodeRegistry();
        this.fileTypeRegistry = new FileTypeRegistry();
        // creates instances from configuration file
        createFileTypes();
        createServiceTypes();
        createExternalService();
        createPostalCodes();
        createAssignmentAlgoritm();
        createSortingBehavior();
        assignServiceTask();
    }

    /**
     *
     * Gets the instance of Service Assignement Registry
     *
     * @return Service Assignement Registry
     */
    public ServiceAssignmentRegistry getServiceAssignementRegistry() {
        return this.serviceAssignementRegistry;
    }

    /**
     *
     * Gets the instance of Service Order Registry
     *
     * @return Service Order Registry
     */
    public ServiceOrderRegistry getServiceOrderRegistry() {
        return this.serviceOrderRegistry;
    }

    /**
     *
     * Gets the instance of Service Provider Registry
     *
     * @return Service Provider Registry
     */
    public ServiceProviderRegistry getServiceProviderRegistry() {
        return this.serviceProviderRegistry;
    }

    /**
     *
     * Gets the instance of Service Registry
     *
     * @return Service Registry
     */
    public ServiceRegistry getServiceRegistry() {
        return this.serviceRegistry;
    }

    /**
     *
     * Gets the instance of Service Request Registry
     *
     * @return Service Request Registry
     */
    public ServiceRequestRegistry getServiceRequestRegistry() {
        return this.serviceRequestRegistry;
    }

    /**
     *
     * Gets the instance of Geographic Area Registry
     *
     * @return Geographic Area Registry
     */
    public GeographicAreaRegistry getGeographicAreaRegistry() {
        return this.geographicAreaRegistry;
    }

    /**
     *
     * Gets the instance of Client Registry
     *
     * @return Client Registry
     */
    public ClientRegistry getClientRegistry() {
        return this.clientRegistry;
    }

    /**
     *
     * Gets the instance of File Type Registry
     *
     * @return File Type Registry
     */
    public FileTypeRegistry getFileTypeRegistry() {
        return fileTypeRegistry;
    }

    /**
     *
     * Gets the instance of Category Registry
     *
     * @return Category Registry
     */
    public CategoryRegistry getCategoryRegistry() {
        return this.categoryRegistry;
    }

    /**
     * Gets the instance of SPApplicationRegistry
     *
     * @return applicationRegistry
     */
    public SPApplicationRegistry getSPApplicationRegistry() {
        return spApplicationRegistry;
    }

    /**
     *
     * Gets the instance of Authentication Facade
     *
     * @return Authentication Facade
     */
    public AuthenticationFacade getAuthenticationFacade() {
        return this.authentication;
    }

    /**
     *
     * Gets the instance of Service Type Registry
     *
     * @return Service Registry
     */
    public ServiceTypeRegistry getServiceTypeRegistry() {
        return serviceTypeRegistry;
    }

    /**
     *
     * Gets the instance of Assignment Algoritm
     *
     * @return Assignment algoritm
     */
    public IAssignmentAlgoritm getAssignmentAlgoritm() {
        return assignmentAlgoritm;
    }

    /**
     *
     * Gets the instance of Timer
     *
     * @return Timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     *
     * Gets the instance of Properties
     *
     * @return Service Registry
     */
    public Properties getProps() {
        return props;
    }

    /**
     * Returns the instance of PostalCodeRegistry
     *
     * @return Postal Code Registry
     */
    public PostalCodeRegistry getPostalCodeRegistry() {
        return this.postalCodeRegistry;
    }

    /**
     * Returns the instance of External Service in used by the system.
     *
     * @return instance of External Service
     */
    public IExternalService getExternalService() {
        return externalService;
    }

    public ISortingBehavior getServiceSortingBehavior() {
        return serviceSortingBehavior;
    }

    public String getDesignation() {
        return designation;
    }

    private void createFileTypes() {
        fileTypeRegistry.createSupportedFileTypes(props);
    }

    private void createServiceTypes() {
        serviceTypeRegistry.createSupportedServiceTypes(props);

    }

    /**
     * Loads every available Postal Code from an externalFile to the Postal Code
     * Registry.
     *
     * @throws IOException if PostalCode File is not found
     */
    private void createPostalCodes() {
        try {
            this.postalCodeRegistry.setPostalCodeList(this.externalService.loadPostalCodeList());
        } catch (Exception ex) {
            System.out.println("Error creating postal codes. Verify ExternalService.");
            System.out.println("Fatal error. Exiting program.");
            System.exit(1);
        }

    }

    /**
     * Creates ExternalService according to configuration file (ExternalService)
     */
    private void createExternalService() {
        try {
            String filepathPostalCodes = props.getProperty(Constants.PARAMS_FILE_POSTAL_CODES);
            externalService = (IExternalService) Class.forName("lapr.project.gpsd.model." + props.getProperty(Constants.PARAMS_EXTERNAL_SERVICE)).getConstructor(String.class).newInstance(filepathPostalCodes);
        } catch (Exception ex) {
            System.out.println("Error creating External Service. See configuration file.");
            System.out.println("Fatal error. Exiting program.");
            System.exit(1);
        }
    }

    /**
     * Creates AssignmentAlgoritm according to configuration file
     * (AssignmentAlgoritm)
     */
    private void createAssignmentAlgoritm() {
        try {
            assignmentAlgoritm = (IAssignmentAlgoritm) Class.forName("lapr.project.gpsd.model." + props.getProperty(Constants.PARAMS_ASSIGNMENT_ALGORITM)).getConstructor().newInstance();
        } catch (Exception ex) {
            System.out.println("Error creating AssignmentAlgoritm. See configuration file.");
        }
    }

    /**
     * Creates SortingBehavior for AssignmentAlgoritm according to configuration
     * file (SortingBehavior)
     */
    private void createSortingBehavior() {
        try {
            serviceSortingBehavior = (ISortingBehavior) Class.forName("lapr.project.gpsd.model." + props.getProperty(Constants.PARAMS_SERVICE_SORTING_BEHAVIOR)).getConstructor().newInstance();
        } catch (Exception ex) {
            System.out.println("Error creating SortingBehavior for AssignmentAlgoritm. See configuration file.");
        }
    }

    /**
     * Creates and sets the Company's AssignServiceTask instance according to
     * the configuration file (initial DELAY and regular INTERVAL).
     */
    public void assignServiceTask() {
        int interval = 0;
        int delay = -1;
        try {
            delay = Integer.parseInt(props.getProperty(Constants.COMPANY_ASSIGNMENT_DELAY));
            interval = Integer.parseInt(props.getProperty(Constants.COMPANY_ASSIGNMENT_INTERVAL));
        } catch (Exception e) {
            System.out.println("Assignments will not run: DELAY or INTERVAL not properly set.");
        }
        if (interval > 0 && delay >= 0) {
            this.task = new AssignServiceTask();
            this.timer = new Timer();
            // time and interval are given in seconds but method takes arguments as milliseconds
            this.timer.scheduleAtFixedRate(task, delay * 1000, interval * 1000);
        } else {
            System.out.println("Assignments will not run: DELAY must be greater or equal to zero and and INTERVAL must be greater than zero");
        }
    }
}
