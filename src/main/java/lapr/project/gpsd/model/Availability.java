package lapr.project.gpsd.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate date;
    /**
     * Begin Time for the availability
     */
    private LocalTime sTime;
    /**
     * End time for the availability
     */
    private LocalTime eTime;

    /**
     * Constructor for Availability receiving all the atributos by method
     * parameters
     *
     * @param date Date
     * @param bTime Begin Time
     * @param eTime End Time
     */
    public Availability(LocalDate date, LocalTime bTime, LocalTime eTime) {
        LocalDate todayDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                || bTime.getHour() == 0 || eTime.getHour() < 6
                || eTime.isAfter(bTime) || eTime.equals(bTime)
                || date.isBefore(todayDate) || bTime.isBefore(nowTime)) {
            throw new IllegalArgumentException("Invalid availability.");
        }
        this.date = date;
        this.sTime = bTime;
        this.eTime = eTime;
    }

    /**
     * Returns the begining date for the availability. Java util is used for
     * date.
     *
     * @return begin date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date for the availability. Java util is used for date.
     *
     * @param date begining date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the begining time for the availability. java sql is used for
     * time.
     *
     * @return begining time
     */
    public LocalTime getSTime() {
        return sTime;
    }

    /**
     * Sets the begining time for the availability. java sql is used for time.
     *
     * @param bTime begin time
     */
    public void setSTime(LocalTime bTime) {
        this.sTime = bTime;
    }

    /**
     * Returns the ending time for the availability. java sql is used for time.
     *
     * @return ending time
     */
    public LocalTime getETime() {
        return eTime;
    }

    /**
     * Sets the ending time for the availability. java sql is used for time.
     *
     * @param eTime end time
     */
    public void setETime(LocalTime eTime) {
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
        return this.date == otherAvailability.date
                && this.sTime == otherAvailability.sTime
                && this.eTime == otherAvailability.eTime;
    }

    /**
     * Checks whether a schedule preference is contained within availability,
     * returning true or false.
     *
     * @param schedulePref instance of SchedulePreference to check
     * @param duration Service duration
     * @return returns true if, and only if, the schedule preference is
     * contained within the instanced availability
     */
    public boolean contaisSchedulePref(SchedulePreference schedulePref, int duration) {
        LocalDate scheDate = schedulePref.getDate();
        LocalTime scheStartTime = schedulePref.getTime();
        LocalTime scheEndTime = schedulePref.getTime().plusMinutes(duration);
        if (scheDate.equals(date)) {
            if ((scheStartTime.isAfter(sTime) || scheStartTime.equals(sTime))
                    && (scheEndTime.isBefore(eTime) || scheEndTime.equals(eTime))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n" + "Start time: " + sTime + "\n" + "End time: " + eTime + "\n";
    }


}
