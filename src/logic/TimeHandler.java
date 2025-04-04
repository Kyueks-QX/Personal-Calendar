package logic;

import models.Calendar;
import models.Date;

//Handles all things time related
public class TimeHandler {
    //Finds a date by its day, start and end hours
    public static Date findDate(Calendar calendar, Date searchDate) {
        if (calendar.getDates().isEmpty()) { return null; }

        for (Date d : calendar.getDates()) {
            if (d.equivalent(searchDate)) { return d; }
        }
        return null;
    }

    //Makes sure the newly added date does not overlap with others in the calendar
    public static boolean isThereDateConflict(Calendar calendar, Date newDate) {
        for (Date date : calendar.getDates()) {
            if (date.getEndTime().isAfter(newDate.getStartTime()) && date.getDay().isEqual(newDate.getDay())) {
                return true;
            }
        }
        return false;
    }
}
