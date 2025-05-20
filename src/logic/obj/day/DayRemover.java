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

    public static void removeEmptyDays() {
        for (Day day : CalendarHandler.calendar.getDays()) {
            if (day.getDates().isEmpty()) {
                removeDay(day);
            }
        }
    }
}
