package logic.obj.date;

import logic.obj.calendar.CalendarHandler;
import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;
import java.util.Comparator;

//adds date to a day
public class DateAdder {
    /**
     * Adds a date to a day.
     * @param date
     * The date that will be added.
     * @param targetDay
     * Which day to add it to.
     * @return
     * Status of attempt to add date to day.
     */
    public static int addDateToDay(Date date, Day targetDay) {
        if (DateConflict.isThereDateConflict(CalendarHandler.calendar, targetDay, date)) {
            return 3;
        }

        Day updatedDay = new Day(targetDay);
        ArrayList<Date> dates = targetDay.getDates();
        dates.add(date);
        dates.sort(Comparator.comparing(Date::getStartTimeAsInt));
        targetDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(targetDay, updatedDay);

        return 0;
    }
}
