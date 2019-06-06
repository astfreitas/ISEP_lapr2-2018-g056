package lapr.project.gpsd.model;
import java.util.Date;

public class ServiceRequest {
    
    private int number;
    private Date date;
    private double total;
    private Client client;
    private Address address;
    /**
     * Constructor creates a service request with client and address where the service will be executed
     * @param client instance of client that requested the service
     * @param address instance of address where the service will be executed
     */
    ServiceRequest(Client client, Address address) {
        this.client = client;
        this.address = address;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
