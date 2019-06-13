package lapr.project.gpsd.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SchedulePreference {

    /**
     * SchedulePreference atributes
     */
    private int order;
    private LocalDate date;
    private LocalTime hour;

    /**
     * service constructor with 3 parameters
     *
     * @param order Order of the SchedPref
     * @param date Date of the SchedPref
     * @param hour Hour of the SchedPref
     */
    public SchedulePreference(int order, LocalDate date, LocalTime hour) {
        LocalDate today = LocalDate.now();
        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                || hour.getHour() == 0 || hour.getHour() < 6
                || date.isBefore(today)) {
            throw new IllegalArgumentException("Invalid availability.");
        }
        this.order = order;
        this.date = date;
        this.hour = hour;
    }

    /**
     * service constructor with 3 parameters
     *
     * @param order Order of the SchedPref
     * @param date Date of the SchedPref
     * @param hour Hour of the SchedPref
     * @param str str
     */
    public SchedulePreference(int order, LocalDate date, LocalTime hour, String str) {
        if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                || hour.getHour() == 0 || hour.getHour() < 6) {
            throw new IllegalArgumentException("Invalid availability.");
        }
        this.order = order;
        this.date = date;
        this.hour = hour;
    }

    /**
     * returns the preferences order
     *
     * @return order Returns the order
     */
    public int getOrder() {
        return order;
    }

    /**
     * returns the date
     *
     * @return date Returns the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * returns the time
     *
     * @return time Returns the time
     */
    public LocalTime getTime() {
        return hour;
    }

    /**
     * returns the date time
     *
     * @return date time
     */
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(date, hour);
    }

    /**
     * modifies order
     *
     * @param order New order#
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     *
     * Analyses if 2 SchedulePreferences are diferent
     *
     * @param obj SchedulePreference to compare
     * @return Returns the result of the compare
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SchedulePreference other = (SchedulePreference) obj;
        return this.date == other.date && this.hour == other.hour;
    }

    /**
     *
     * Gives the description for the Schedule Preference object
     *
     * @return String with the SchedulePreference
     */
    @Override
    public String toString() {
        return order + " : " + date + " to " + hour;
    }

}
