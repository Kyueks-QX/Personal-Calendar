package logic.date_handlers;

import models.Calendar;
import models.Date;

public class DateConflict extends DateHandler {
    public DateConflict(Calendar calendar, Date date) {
        super(calendar, date);
    }

    //Makes sure the newly added date does not overlap with others in the calendar
    public static boolean isThereDateConflict() {
        for (Date calDate : calendar.getDates()) {
            if (calDate.getEndTime().isAfter(date.getStartTime()) && calDate.getDay().isEqual(date.getDay())) {
                return true;
            }
        }
        return false;
    }
}
