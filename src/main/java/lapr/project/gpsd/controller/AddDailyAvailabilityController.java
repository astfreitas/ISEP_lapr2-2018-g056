package lapr.project.gpsd.controller;

import lapr.project.gpsd.utils.Constants;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import lapr.project.authentication.model.UserSession;
import lapr.project.gpsd.model.*;

public class AddDailyAvailabilityController {

    private Company company;
    private ServiceProvider sp;
    private ArrayList<Availability> avalList;
    private SPAvailabilityList spal;

    /**
     *
     * Creates an instance of AddDailyAvailabilityController
     *
     */
    public AddDailyAvailabilityController() {
        if (!ApplicationGPSD.getInstance().getCurrentSession().isLoggedInWithRole(Constants.ROLE_SERVICE_PROVIDER)) {
            throw new IllegalStateException("Non authorized user.");
        }
        this.company = ApplicationGPSD.getInstance().getCompany();
        avalList = new ArrayList<>();
        UserSession session = ApplicationGPSD.getInstance().getCurrentSession();
        String email = session.getUserEmail();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        sp = spr.getServiceProviderByEmail(email);
    }

    /**
     *
     * Creates one instance of Availability
     *
     * @param date Date of Availability
     * @param sTime Start time of Availability
     * @param eTime End of Availability
     * @return returns a List of availabilities
     */
    public ArrayList<Availability> newAvailability(LocalDate date, LocalTime sTime, LocalTime eTime) {
        spal = sp.getSpAvailabilityList();
        Availability aval = spal.newAvailability(date, sTime, eTime);
        avalList.add(aval);
        return avalList;
    }

    /**
     *
     * Creates various instances of Availability with a repetition pattern
     *
     * @param date Date of Availability
     * @param sTime Start time of Availability
     * @param eDate End date of repetition
     * @param eTime End of Availability
     * @param repPattern Repetition pattern
     * @return returns a List of availabilities
     */
    public ArrayList<Availability> newAvailability(LocalDate date, LocalTime sTime, LocalTime eTime, LocalDate eDate, String repPattern) {
        spal = sp.getSpAvailabilityList();
        Availability aval;
        LocalDate dateAval = date;
        if(date.isAfter(eDate) || repPattern.equals("")){
            throw new IllegalArgumentException("Invalid frequency.");
        }
        for (int i = 0; i < Period.between(date, eDate).getDays()+1; i++) {
            if (dateAval.isBefore(eDate) || dateAval.equals(eDate)) {
                aval = new Availability(dateAval, sTime, eTime);
                avalList.add(aval);
            }
            switch (repPattern) {
                case Constants.REPETITION_PATTERN_DAILY:
                    dateAval = dateAval.plusDays(1);
                    break;
                case Constants.REPETITION_PATTERN_WEEKLY:
                    dateAval = dateAval.plusWeeks(1);
                    break;
                case Constants.REPETITION_PATTERN_FORTNIGHTLY:
                    dateAval = dateAval.plusWeeks(2);
                    break;
                case Constants.REPETITION_PATTERN_MONTHLY:
                    dateAval = dateAval.plusMonths(1);
                    break;
                default:
                    break;
            }
        }
        return avalList;
    }
    
    /**
     * 
     * Clear the availabilityList
     * 
     */
    public void clearAvalList(){
        this.avalList.clear();
    }

    /**
     *
     * Registers the availability on the Service Provider's list
     *
     * @return The success of the operation
     */
    public boolean registerAvailability() {
        return spal.addAvailability(avalList);
    }
    
    /**
     * 
     * Returns the list os availabilities
     * 
     * @return List os availabilities
     */
    public ArrayList<Availability> getAvalList(){
        return this.avalList;
    }
}
