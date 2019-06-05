package lapr.project.gpsd.model;

import java.sql.Time;
import java.util.Date;

/**
 * Availability Class is intended to represent the availability of the service
 * provider through a time frame represented by date and time attributes using
 * java library.
 *
 * @author astfr
 */
public class Availability {

    /**
     * Begin date for the availability
     */
    private Date bDate;
    /**
     * Begin Time for the availability
     */
    private Time bTime;
    /**
     * End date for the availability
     */
    private Date eDate;
    /**
     * End time for the availability
     */
    private Time eTime;

    /**
     * Constructor for Availability receiving all the atributos by method
     * parameters
     *
     * @param bDate Begin Date
     * @param bTime Begin Time
     * @param eDate End Date
     * @param eTime End Time
     */
    public Availability(Date bDate, Time bTime, Date eDate, Time eTime) {
        this.bDate = bDate;
        this.bTime = bTime;
        this.eDate = eDate;
        this.eTime = eTime;
    }

    /**
     * Returns the begining date for the availability. Java util is used for
     * date.
     *
     * @return begin date
     */
    public Date getbDate() {
        return bDate;
    }

    /**
     * Sets the begining date for the availability. Java util is used for date.
     *
     * @param bDate begining date
     */
    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    /**
     * Returns the begining time for the availability. java sql is used for
     * time.
     *
     * @return begining time
     */
    public Time getbTime() {
        return bTime;
    }

    /**
     * Sets the begining time for the availability. java sql is used for time.
     *
     * @param bTime begin time
     */
    public void setbTime(Time bTime) {
        this.bTime = bTime;
    }

    /**
     * Returns the ending date for the availability. Java util is used for date.
     *
     * @return ending date
     */
    public Date geteDate() {
        return eDate;
    }

    /**
     * Sets the ending date for the availability. Java util is used for date.
     *
     * @param eDate ending date
     */
    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    /**
     * Returns the ending time for the availability. java sql is used for time.
     *
     * @return ending time
     */
    public Time geteTime() {
        return eTime;
    }

    /**
     * Sets the ending time for the availability. java sql is used for time.
     *
     * @param eTime end time
     */
    public void seteTime(Time eTime) {
        this.eTime = eTime;
    }

    /**
     * Compares the Availability instance with an objet received by reference in
     * the method parameter.
     *
     * @param otherObject Objet to compare with the Availability instance
     * @return true if the received object represent and equal object of the
     * instanced Availability. Otherwise returns False.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Availability otherAvailability = (Availability) otherObject;
        return this.bDate == otherAvailability.bDate
                && this.eDate == otherAvailability.eDate
                && this.bTime == otherAvailability.bTime
                && this.eTime == otherAvailability.eTime;
    }

    /**
     * Checks whether a schedule preference is contained within availability,
     * returning true or false.
     *
     * @param schedulePref instance of SchedulePreference to check
     * @return returns true if, and only if, the schedule preference is
     * contained within the instanced availability
     */
    public boolean contaisSchedulePref(SchedulePreference schedulePref) {
        Date scheDate = schedulePref.getDate();
        Time scheTime = schedulePref.getHour();
        if (scheDate.before(this.eDate) && scheDate.after(this.bDate)) {
            return true;
        } else if (scheDate.equals(this.bDate)) {
            if (scheTime.after(this.bTime)) {
                return true;
            }
        } else if (scheDate.equals(this.bDate)) {
            if (scheTime.before(this.eTime)) {
                return true;
            }
        }
        return false;
    }
}
