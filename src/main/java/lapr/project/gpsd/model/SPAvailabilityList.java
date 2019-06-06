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

}
