package lapr.project.gpsd.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

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
     * @param order
     * @param date
     * @param time
     */
    public SchedulePreference(int order, LocalDate date, LocalTime hour) {
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
    public LocalDate getDate() {
        return date;
    }

    /**
     * returns the hour
     *
     * @return hour
     */
    public LocalTime getHour() {
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
    
}
