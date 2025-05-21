package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import logic.obj.day.DayRemover;
import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;

public class DateRemover extends DateHandler {
    /**
     * Removes date from a given day.
     * @param targetDate
     * The date that is being removed.
     * @param targetDay
     * The day it's located in.
     * @return
     * Status after attempt to remove date from day.
     */
    public static int removeDateFromDay(Date targetDate, Day targetDay) {
        Day oldDay = (Day) Finders.dayFinder.find(targetDay);
        if (oldDay == null) {
            return 1;
        }

        ArrayList<Date> dates = oldDay.getDates();

        dates.remove(targetDate);

        Day newDay = new Day(oldDay);
        newDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(oldDay, newDay);

        DayRemover.removeEmptyDay(newDay);
        return 0;
    }
}
