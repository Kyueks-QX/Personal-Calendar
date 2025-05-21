package logic.obj.day;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.calendar.Day;

import java.util.ArrayList;

public class DayRemover extends DayHandler {
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
