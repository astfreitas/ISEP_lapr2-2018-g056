package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SchedulePreference {

    /**
     * SchedulePreference atributes
     */
    private int order;
    private LocalDate date;
    private LocalTime time;

    /**
     * service constructor with 3 parameters
     *
     * @param order
     * @param date
     * @param time
     */
    public SchedulePreference(int order, LocalDate date, LocalTime time) {
        this.order = order;
        this.date = date;
        this.time = time;
    }

    /**
     * returns the preferences order
     *
     * @return order
     */
    public int getOrder() {
        return order;
    }

    /**
     * returns the date
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * returns the time
     *
     * @return time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * modifies order
     *
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * modifies date
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * modifies time
     *
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.time);
        return hash;
    }

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
        if (this.order != other.order) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return order + " : " + date + " às " + time;
    }
    
    

    /**
     * Returns the number of days since 1/1/1 until the current date.
     *
     * @return number of days since 1/1/1 until the current date.
     */
    /*
    public int countDays() {
        int totalDays = 0;

        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < year; i++) {
            totalDays += daysPerMonth[i];
        }
        totalDays += (isAnoBissexto(year) && month > 2) ? 1 : 0;
        totalDays += day;

        return totalDays;
    }
     */
    /**
     * convert date and time in minutes
     *
     * @return number of minutes
     */
    /*
    public int toMinutes() {
        return date.countDays() * 24 * 60 + time.getHours()* 60 + time.getMinutes();
    }
     */
    
    
}
