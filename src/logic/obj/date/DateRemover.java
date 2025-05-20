package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import logic.obj.day.DayRemover;
import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;

public class DateRemover extends DateHandler {
    public static int removeDate(Date targetDate) {
        Day oldDay = Finders.dayFinder.findFromDate(targetDate);
        if (oldDay == null) {
            return 1;
        }

        ArrayList<Date> dates = oldDay.getDates();

        dates.remove(targetDate);

        Day newDay = new Day(oldDay);
        newDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(oldDay, newDay);

        DayRemover.removeEmptyDays();
        return 0;
    }

    public static int removeDateFromDay(Date targetDate, Day targetDay) {
        Day oldDay = (Day) Finders.dayFinder.find(targetDay);
        if (oldDay == null) {
            return 1;
        }

        ArrayList<Date> dates = oldDay.getDates();

        dates.remove(targetDate);

        Day newDay = new Day(oldDay);
        newDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(oldDay, newDay);

        DayRemover.removeEmptyDays();
        return 0;
    }
}
