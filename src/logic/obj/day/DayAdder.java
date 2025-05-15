package logic.obj.day;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.Day;

import java.time.LocalDate;
import java.util.Comparator;

public class DayAdder extends DayHandler {
    // Makes a day if it doesn't exist
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

        if (Finders.dayFinder.findIndex(newDay) != -1) {
            days.add(newDay);
            days.sort(Comparator.comparing(Day::getLocalDate));
            return 0;
        }
        return 3;
    }

    public static int addDay(Day newDay) {
        if (newDay == null) {
            return 1;
        }

        for (Day day : CalendarHandler.calendar.getDays()) {
            if (day.getLocalDate().isEqual(newDay.getLocalDate())) {
                return 2;
            }
        }

        if (Finders.dayFinder.findIndex(newDay) != -1) {
            days.add(newDay);
            days.sort(Comparator.comparing(Day::getLocalDate));
            return 0;
        }
        return 3;
    }
}