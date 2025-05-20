package logic.obj.calendar;

import logic.find.Finders;
import models.calendar.Day;

public class CalendarHoliday extends CalendarHandler {
    public static boolean holiday(Day day) {
        int index = Finders.dayFinder.findIndex(day);
        if (index != -1) {
            Day d = CalendarHandler.calendar.getDays().get(index);
            d.setHoliday(!d.isHoliday());
            return true;
        }
        return false;
    }
}
