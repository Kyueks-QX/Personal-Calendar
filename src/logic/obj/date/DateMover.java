package logic.obj.date;

import logic.obj.calendar.CalendarHandler;
import models.calendar.Date;
import models.calendar.Day;

// changes in which day a date is
// if a day doesn't exist for the date, make a new day
public class DateMover extends DateHandler {
    public static int changeDayOfDate(Day fromDay, Day toDay, Date targetDate) {
        if (fromDay == null || toDay == null || targetDate == null) {
            return 1;
        }
        fromDay = CalendarHandler.calendar.getSingleDay(fromDay);
        toDay = CalendarHandler.calendar.getSingleDay(toDay);
        if (fromDay.getSingleDate(targetDate) == null) {
            return 2;
        }

        Date temp = new Date(fromDay.getSingleDate(targetDate));

        DateRemover.removeDateFromDay(targetDate, fromDay);
        DateAdder.addDateToDay(temp, toDay);

        return 0;
    }
}
