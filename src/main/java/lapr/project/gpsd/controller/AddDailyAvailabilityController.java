package lapr.project.gpsd.controller;

import java.time.DayOfWeek;
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
        avalList = new ArrayList<>();
        setAvailabilities();
    }

    public void setAvailabilities() {
        ApplicationGPSD app = ApplicationGPSD.getInstance();
        company = app.getCompany();
        UserSession session = app.getCurrentSession();
        String email = session.getUserEmail();
        ServiceProviderRegistry spr = company.getServiceProviderRegistry();
        sp = spr.getServiceProviverByEmail(email);
    }

    public ArrayList<Availability> newAvailability(LocalDate date, LocalTime sTime, LocalDate eDate, LocalTime eTime) {
        spal = sp.getSpAvailabilityList();
        Availability aval = spal.newAvailability(date, sTime, eTime);
        avalList.add(aval);
        return avalList;
    }

    public ArrayList<Availability> newAvailability(LocalDate date, LocalTime sTime, LocalDate eDate, LocalTime eTime, String repPattern) {
        spal = sp.getSpAvailabilityList();
        Availability aval;
        DayOfWeek weekday = date.getDayOfWeek();
        LocalDate dateAval = date;
        for (int i = 0; i < Period.between(date, eDate).getDays(); i++) {
            if (dateAval.getDayOfWeek().equals(weekday)
                    && (dateAval.isBefore(eDate) || dateAval.equals(eDate))) {
                aval = new Availability(dateAval, sTime, eTime);
                avalList.add(aval);
            }
            switch (repPattern) {
                case "Daily":
                    dateAval = dateAval.plusDays(1);
                    break;
                case "Weekly":
                    dateAval = dateAval.plusWeeks(1);
                    break;
                case "Fortnightly":
                    dateAval = dateAval.plusWeeks(2);
                    break;
                case "Monthly":
                    dateAval = dateAval.plusMonths(1);
                    break;
                default:
                    break;
            }
        }
        return avalList;
    }
    
    public boolean registerAvailability(){
        return spal.addAvailability(avalList);
    }
}
