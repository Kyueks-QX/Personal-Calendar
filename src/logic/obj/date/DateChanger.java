package logic.obj.date;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.Date;
import models.Day;

import java.util.ArrayList;

// changes in which day a date is
// if a day doesn't exist for the date, make a new day
public class DateChanger extends DateHandler {
    public static int changeDayOfDate(Day targetDay, Date targetDate) {
        targetDay = CalendarHandler.calendar.getSingleDay(targetDay);
        Date temp = new Date(targetDay.getSingleDate(targetDate));

        DateRemover.removeDate(targetDate);



        return 0;
    }
}
