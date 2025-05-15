package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import logic.obj.day.DayAdder;
import models.Date;
import models.Day;

import java.util.ArrayList;

// changes in which day a date is
// if a day doesn't exist for the date, make a new day
public class DateChanger extends DateHandler {
    public static int changeDayOfDate(Day fromDay, Day toDay, Date targetDate) {
        if (fromDay == null || toDay == null || targetDate == null) {
            return 1;
        }
        fromDay = CalendarHandler.calendar.getSingleDay(fromDay);
        toDay = CalendarHandler.calendar.getSingleDay(toDay);
        if (fromDay.getSingleDate(targetDate) == null) {
            return 2;
        }

        Date temp = new Date(fromDay.getSingleDate(targetDate));

        DateRemover.removeDateFromDay(targetDate, fromDay);
        DateAdder.addDateToDay(temp, toDay);

        return 0;
    }
}
