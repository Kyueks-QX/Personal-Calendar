package logic.obj.day;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.calendar.Day;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class DayAdder extends DayHandler {
    /**
     * Adds a new day to the calendar using a LocalDate.
     * @param localDate
     * The local date.
     * @return
     * Status after attempt to add day to calendar.
     */
    public static int addDay(LocalDate localDate) {
        if (localDate == null) {
            return 1;
        }

        for (Day day : CalendarHandler.calendar.getDays()) {
            if (day.getLocalDate().isEqual(localDate)) {
                return 2;
            }
        }

        Day newDay = new Day(localDate);

        if (Finders.dayFinder.findIndex(newDay) == -1) {
            ArrayList<Day> days = CalendarHandler.calendar.getDays();
            days.add(newDay);
            days.sort(Comparator.comparing(Day::getLocalDate));
            return 0;
        }
        return 3;
    }

    /**
     * Adds a new day to the calendar.
     * @param newDay
     * The new day.
     * @return
     * Status after attempt to add day to calendar.
     */
    public static int addDay(Day newDay) {
        if (newDay == null) {
            return 1;
        }

        for (Day day : CalendarHandler.calendar.getDays()) {
            if (day.getLocalDate().isEqual(newDay.getLocalDate())) {
                return 2;
            }
        }

        if (Finders.dayFinder.findIndex(newDay) == -1) {
            ArrayList<Day> days = CalendarHandler.calendar.getDays();
            days.add(newDay);
            days.sort(Comparator.comparing(Day::getLocalDate));
            return 0;
        }
        return 3;
    }
}