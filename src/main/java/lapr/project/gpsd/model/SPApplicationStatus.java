
package lapr.project.gpsd.model;

import java.time.LocalDate;

/**
 *
 * @author mdias
 */
public class SPApplicationStatus {

    /**
     * attribute of SPApplicationStatus
     */
    private String spApplicationStatus;
    private LocalDate date;

    /**
     * empty constructor of SPApplicationStatus
     */
    public SPApplicationStatus() {
        this.spApplicationStatus = "N/A";
    }

    /**
     * constructor of SPApplicationStatus with 2 parameter
     *
     * @param spApplicationStatus
     * @param date
     */
    public SPApplicationStatus(String spApplicationStatus, LocalDate date) {
        this.spApplicationStatus = spApplicationStatus;
        this.date = date;
    }

    /**
     * returns the SP application status
     *
     * @return SP application status
     */
    public String getSPApplicationStatus() {
        return spApplicationStatus;
    }

    /**
     * modifies the SP application status
     *
     * @param spApplicationStatus
     */
    public void setSPApplicationStatus(String spApplicationStatus) {
        this.spApplicationStatus = spApplicationStatus;
    }
    
    

}
