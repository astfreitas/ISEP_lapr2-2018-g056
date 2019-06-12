package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.impl.AvalonLogger;

public class SPAvailabilityList {

    /**
     * List of availability associated to the Service Provider.
     */
    private List<Availability> availabilityList;

    /**
     *
     * Creates an instance of SPAvailabilityList
     *
     */
    public SPAvailabilityList() {
        availabilityList = new ArrayList<>();
    }

    /**
     * Returns a new instance of availability.
     *
     * @param date date
     * @param bTime begin time
     * @param eTime end time
     * @return new availability instance
     */
    public Availability newAvailability(LocalDate date, LocalTime bTime, LocalTime eTime) {
        return new Availability(date, bTime, eTime);
    }

    /**
     * Adds a instance of availability to the SPAvailablity List
     *
     * @param availability availability to be added to the list
     * @return the sucess of the operation
     */
    public boolean addAvailability(Availability availability) {
        if (validatesAvaiDoesNotExist(availability)) {
            availabilityList.add(availability);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Adds a list of instances of Availability to the SPAvailablity List
     *
     * @param availabilityList availabilities to be added to the list
     * @return the sucess of the operation
     */
    public boolean addAvailability(ArrayList<Availability> availabilityList) {
        for (Availability availability : availabilityList) {
            if (validatesAvaiDoesNotExist(availability)) {
                availabilityList.add(availability);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates that a instance of availability does not exist in the
     * SPAvailabilityList.
     *
     * @param otherAvailability Availability objet to compare
     * @return true if the given object does not exit an equal is the
     * SPAvailabilityList
     */
    private boolean validatesAvaiDoesNotExist(Availability otherAvailability) {
        for (Availability availability : availabilityList) {
            if (availability.equals(otherAvailability)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method adds an availability to the Service Provider Availability List
     * from a schedulePrefenrece
     *
     * @param schedulePreference date and time when the service should occur
     * @param duration duration in minutes of the service duration
     * @return true if the availability was added with success.
     */
    public boolean addAvailabilityBySchedulePreference(SchedulePreference schedulePreference, int duration) {
        LocalDate date = schedulePreference.getDate();
        LocalTime bHour = schedulePreference.getTime();
        LocalTime eHour = schedulePreference.getTime().plusMinutes(duration);
        Availability availability = newAvailability(date, bHour, eHour);
        return addAvailability(availability);
    }

    public List<Availability> getAvailabilityList() {
        return availabilityList;
    }

    /**
     *
     * Look for availabilities who are contiguous and merges them into one
     * single Availability
     *
     */
    public void mergeAvailabilities() {
        boolean flagMerge = true;
        while (flagMerge) {
            flagMerge = false;
            for (Availability aval : availabilityList) {
                for (Availability aval1 : availabilityList) {
                    if (aval.getDate().equals(aval1.getDate())) {
                        if (aval1.getSTime().equals(aval.getETime())) {
                            Availability aval2 = new Availability(aval1.getDate(), aval.getSTime(), aval1.getETime());
                            availabilityList.add(aval2);
                            availabilityList.remove(aval);
                            availabilityList.remove(aval1);
                            flagMerge = true;
                        }
                    }
                    if (flagMerge) {
                        break;
                    }
                }
                if (flagMerge) {
                    break;
                }
            }
        }
    }

    /**
     * Verifies that Service Provider is available in Schedule given as argument
     *
     * @param schedule
     * @param duration
     * @return
     */
    public boolean hasAvailability(SchedulePreference schedule, int duration) {
        for (Availability availability : availabilityList) {
            if (availability.containsSchedulePref(schedule, duration)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the first schedule (from list given as argument) matching one of
     * the SP's availabilities
     *
     * @param scheduleList
     * @return
     */
    public SchedulePreference matchSchedule(List<SchedulePreference> scheduleList, int duration) {
        for (SchedulePreference schedule : scheduleList) {
            if (this.hasAvailability(schedule, duration)) {
                return schedule;
            }
        }
        return null;
    }

    /**
     * Matches the first availability with schedule and duration and returns it
     *
     * @return the first availability matching a schedule and duration
     */
    private Availability matchAvailability(SchedulePreference schedule, int duration) {
        for (Availability availability : availabilityList) {
            if (availability.containsSchedulePref(schedule, duration)) {
                return availability;
            }
        }
        return null;
    }

    /**
     * Splits availability into two according to schedule and duration given as
     * argument (removes availability "window"). if schedule and duration does
     * not match availibility in the list returns false
     *
     * @param schedule
     * @param duration
     * @return
     */
    public boolean splitAvailability(SchedulePreference schedule, int duration) {
        LocalDate date = schedule.getDate();
        LocalTime bHour = schedule.getTime();
        LocalTime eHour = schedule.getTime().plusMinutes(duration);
        Availability availability = matchAvailability(schedule, duration);
        if (availability == null) {
            return false;
        }
        availabilityList.remove(availability);
        if (availability.getSTime().equals(bHour)) {
            // split pela esquerda
            Availability avail = new Availability(date, eHour, availability.getETime());
            availabilityList.add(avail);
        } else if (availability.getETime().equals(eHour)) {
            // split pela direita
            Availability avail = new Availability(date, availability.getSTime(), bHour);
            availabilityList.add(avail);
        } else {
            // split no meio
            Availability avail1 = new Availability(date, availability.getSTime(), bHour);
            Availability avail2 = new Availability(date, eHour, availability.getETime());
            availabilityList.add(avail1);
            availabilityList.add(avail2);
        }
        return true;
    }

}
