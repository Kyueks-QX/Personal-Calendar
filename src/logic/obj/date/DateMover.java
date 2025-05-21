package logic.obj.date;

import logic.obj.calendar.CalendarHandler;
import models.calendar.Date;
import models.calendar.Day;

public class DateMover extends DateHandler {
    /**
     * Changes in which day a date is.
     * <p> If a day doesn't exist for the date, make a new day.
     * @param fromDay
     * Initial day.
     * @param toDay
     * Day after moving.
     * @param targetDate
     * The date that is being moved.
     * @return
     * Status after attempt to change day of date.
     */
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
