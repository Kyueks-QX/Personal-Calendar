package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.Date;
import models.Day;

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
        return 0;
    }
}
