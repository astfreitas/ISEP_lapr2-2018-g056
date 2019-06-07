package lapr.project.gpsd.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

}
