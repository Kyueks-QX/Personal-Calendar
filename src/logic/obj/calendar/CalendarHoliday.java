package logic.obj.calendar;

import logic.find.Finders;
import models.calendar.Day;

public class CalendarHoliday extends CalendarHandler {
    /**
     * Marks or unmarks a day as a holiday.
     * @param day
     * Which day to (un)mark as a holiday.
     * @return
     * Status of attempt to mark day as holiday.
     */
    public static int holiday(Day day) {
        int index = Finders.dayFinder.findIndex(day);
        if (index != -1) {
            Day d = CalendarHandler.calendar.getDays().get(index);
            d.setHoliday(!d.isHoliday());
            return 0;
        }
        return 1;
    }
}
