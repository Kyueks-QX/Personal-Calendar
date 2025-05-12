package logic.date;

import logic.calendar.CalendarHandler;
import logic.misc.Finder;
import models.Calendar;
import models.Date;

//Finds a date by its day, start and end hours
public class DateFinder extends DateHandler implements Finder {
    @Override
    public Object find(Object o) {
        return findDate((Date) o);
    }

    public static Date findDate(Date searchDate) {
        if (CalendarHandler.calendar.getDates().isEmpty()) { return null; }

        for (Date d : CalendarHandler.calendar.getDates()) {
            if (d.equivalent(searchDate)) { return d; }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        return findDateIndex((Date) o);
    }

    public static int findDateIndex(Date searchDate) {
        if (CalendarHandler.calendar.getDates().isEmpty()) { return -1; }

        for (Date d : CalendarHandler.calendar.getDates()) {
            if (d.equivalent(searchDate)) {
                return CalendarHandler.calendar.getDates().indexOf(d);
            }
        }
        return -1;
    }
}
