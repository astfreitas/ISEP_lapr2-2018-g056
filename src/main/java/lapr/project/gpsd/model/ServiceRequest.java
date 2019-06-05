
package lapr.project.gpsd.model;

import java.util.Date;


public class ServiceRequest {
    
    private int number;
    private Date date;
    private double total;

    public ServiceRequest(int number, Date date, double total) {
        this.number = number;
        this.date = date;
        this.total = total;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
}
