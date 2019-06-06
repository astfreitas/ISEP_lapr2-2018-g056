/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author astfr
 */
public class SPAvailabilityList {
    /**
     * List of availability associated to the Service Provider.
     */
    private List<Availability> availabilityList;
    
    /**
     * Returns a new instance of availability.
     * @param bDate begin date
     * @param bTime begin time
     * @param eDate end date
     * @param eTime end time
     * @return new availability instance
     */
    public Availability newAvailability(Date bDate,Time bTime, Date eDate,Time eTime){
        return new Availability(bDate, bTime, eDate, eTime);
    }
    /**
     * Adds a instance of availability to the SPAvailablity List
     * @param newAvailability new availabilitu instance to add
     * @return the sucess of the operation
     */
    public boolean addAvailability(List<Availability> newAvailabilityList){
        for (Availability newAv : newAvailabilityList) {
            if (validatesAvaiDoesNotExit(newAv)) {
                availabilityList.add(newAv);
            } else{
                return false;
            }
        }
        return true;
    }
    
    /**
     * Validates that a instance of availability does not exist in the 
     * SPAvailabilityList.
     * @param otherAvailability Availability objet to compare
     * @return true if the given object does not exit an equal is the 
     * SPAvailabilityList
     */
    private boolean validatesAvaiDoesNotExit(Availability otherAvailability){
        for (Availability availability : availabilityList) {
            if (availability.equals(otherAvailability)) {
                return false;
            }
        }
        return true;
    }
    
}
