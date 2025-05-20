package logic.obj.date;

import logic.find.Finders;
import models.calendar.Calendar;
import models.calendar.Date;
import models.calendar.Day;

//Makes sure the newly added date does not overlap with others in the calendar
public class DateConflict extends DateHandler {
    public static boolean isThereDateConflict(Calendar calendar, Day day, Date date) {
        for (Date calDate : calendar.getDays().get(Finders.dayFinder.findIndex(day)).getDates()) {
            if (calDate.getEndTime().isAfter(date.getStartTime()) && calDate == date) {
                return true;
            }
        }
        return false;
    }
}
