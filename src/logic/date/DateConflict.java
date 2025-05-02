package logic.date;

import models.Calendar;
import models.Date;

//Makes sure the newly added date does not overlap with others in the calendar
public class DateConflict extends DateHandler {
    public static boolean isThereDateConflict(Calendar calendar, Date date) {
        for (Date calDate : calendar.getDates()) {
            if (calDate.getEndTime().isAfter(date.getStartTime()) && calDate.getDay().equals(date.getDay())) {
                return true;
            }
        }
        return false;
    }
}
