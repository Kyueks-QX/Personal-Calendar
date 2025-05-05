package logic.date;

import logic.calendar.CalendarHandler;
import models.Calendar;
import models.Date;

//Finds a date by its day, start and end hours
public class DateFinder extends DateHandler {
    public static Date findDate(Date searchDate) {
        if (CalendarHandler.calendar.getDates().isEmpty()) { return null; }

        for (Date d : CalendarHandler.calendar.getDates()) {
            if (d.equivalent(searchDate)) { return d; }
        }
        return null;
    }
}
