package logic.calendar;

import logic.day.DayFinder;
import logic.day.DayHandler;
import models.Day;

public class CalendarHoliday extends CalendarHandler {
    public static boolean holiday(Day day) {
        int index = DayFinder.findDayIndex(day);
        if (index != -1) {
            DayHandler.days.get(index).setHoliday(!DayHandler.days.get(index).isHoliday());
            return true;
        }
        return false;
    }
}
