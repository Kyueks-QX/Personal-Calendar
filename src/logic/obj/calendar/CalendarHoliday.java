package logic.obj.calendar;

import logic.obj.day.DayHandler;
import logic.find.Finders;
import models.Day;

public class CalendarHoliday extends CalendarHandler {
    public static boolean holiday(Day day) {
        int index = Finders.dayFinder.findIndex(day);
        if (index != -1) {
            DayHandler.days.get(index).setHoliday(!DayHandler.days.get(index).isHoliday());
            //day clear is necessary! Either here or somewhere else, IDK
            return true;
        }
        return false;
    }
}
