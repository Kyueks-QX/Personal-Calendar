package logic.obj.date;

import logic.find.Finders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.menu.MenuResponse;
import models.calendar.Calendar;
import models.calendar.Date;
import models.calendar.Day;

//Makes sure the newly added date does not overlap with others in the calendar
public class DateConflict extends DateHandler {
    /**
     * Check if a date conflicts with any other date before adding it into the calendar.
     * @param calendar
     * The calendar in question.
     * @param day
     * On which day the date is being added.
     * @param date
     * The date itself.
     * @return
     * True if there's conflict, false otherwise.
     */
    public static boolean isThereDateConflict(Calendar calendar, Day day, Date date) {
        if (day.getDates().isEmpty()) {
            return false;
        }

        int index = Finders.dayFinder.findIndex(day);
        if (index == -1) {
            return false;
        }

        for (Date calDate : calendar.getDays().get(index).getDates()) {
            if (calDate.getEndTime().isAfter(date.getStartTime()) && calDate == date) {
                return true;
            }
        }
        return false;
    }
}