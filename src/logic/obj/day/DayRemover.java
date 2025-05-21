package logic.obj.day;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.calendar.Day;

import java.util.ArrayList;

public class DayRemover extends DayHandler {
    /**
     * Removes a day from a calendar.
     * @param targetDay
     * The day to be removed.
     * @return
     * Status after attempt to remove day from calendar.
     */
    public static int removeDay(Day targetDay) {
        Day day = (Day) Finders.dayFinder.find(targetDay);
        if (day == null) {
            return 1;
        }

        ArrayList<Day> days = CalendarHandler.calendar.getDays();
        days.remove(day);
        CalendarHandler.calendar.setDays(days);
        return 0;
    }

    /**
     * Removes an empty day.
     * @param targetDay
     * The day to be removed.
     */
    public static void removeEmptyDay(Day targetDay) {
        if (targetDay == null) {
            return;
        }
        targetDay = (Day) Finders.dayFinder.find(targetDay);
        ArrayList<Day> days = CalendarHandler.calendar.getDays();
        days.remove(targetDay);
        CalendarHandler.calendar.setDays(days);
    }
}
