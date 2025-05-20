package logic.obj.date;

import logic.obj.calendar.CalendarHandler;
import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;
import java.util.Comparator;

//adds date to a day
public class DateAdder {
    public static int addDateToDay(Date date, Day targetDay) {
        if (DateConflict.isThereDateConflict(CalendarHandler.calendar, targetDay, date)) {
            return 3;
        }

        Day updatedDay = new Day(targetDay);
        ArrayList<Date> dates = targetDay.getDates();
        dates.add(date);
        dates.sort(Comparator.comparing(Date::getStartTimeAsInt));
        targetDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(targetDay, updatedDay);

        return 0;
    }
}
