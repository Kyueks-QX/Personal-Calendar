package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.Date;
import models.Day;

import java.util.ArrayList;

//adds date to a day
public class DateAdder {
    public static int addDateToDay(Day targetDay, Date date) {
        if (DateConflict.isThereDateConflict(CalendarHandler.calendar, targetDay, date)) {
            return 3;
        }

        Day updatedDay = targetDay;
        ArrayList<Date> dates = targetDay.getDates();
        dates.add(date);
        targetDay.setDates(dates);
        CalendarHandler.calendar.setSingleDay(targetDay, updatedDay);
    }
}
