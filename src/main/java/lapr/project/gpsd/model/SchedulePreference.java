package lapr.project.gpsd.model;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class SchedulePreference {

    /**
     * SchedulePreference atributes
     */
    private int order;
    private Date date;
    private Time hour;

    /**
     * service constructor with 3 parameters
     *
     * @param order
     * @param date
     * @param time
     */
    public SchedulePreference(int order, Date date, Time hour) {
        this.order = order;
        this.date = date;
        this.hour = hour;
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
    public Date getDate() {
        return date;
    }

    /**
     * returns the hour
     *
     * @return hour
     */
    public Time getHour() {
        return hour;
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
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * modifies hour
     *
     * @param hour
     */
    public void setHour(Time hour) {
        this.hour = hour;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.hour);
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
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return order + " : " + date + " às " + hour;
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
        return date.countDays() * 24 * 60 + hour.getHours()* 60 + hour.getMinutes();
    }
     */
    
    
}
