package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
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
    private IAssignmentAlgoritm assignmentAlgoritm;
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
        this.assignmentAlgoritm = null;
        this.externalService = null;
        this.timer = null;
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
     * Creates and sets the Company's AssignServiceTask instance according to
     * the configuration file (initial DELAY and regular INTERVAL). If the
     * variables are not properly set, display message.
     */
    public void assignServiceTask() {
        int interval = 0;
        int delay = -1;
        try {
            delay = Integer.parseInt(props.getProperty("DELAY"));
            interval = Integer.parseInt(props.getProperty("INTERVAL"));
        } catch (Exception e) {
            System.out.println("no dice. cannot get DELAY or/and INTERVAL");
            System.out.println(e.getMessage());
        }
        if (interval > 0 && delay >= 0) {
            this.task = new AssignServiceTask();
            this.timer = new Timer();
            this.timer.scheduleAtFixedRate(task, delay, interval);
        } else {
            System.out.println("no dice. INTERVAL or DELAY is wack.");
        }
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
}
