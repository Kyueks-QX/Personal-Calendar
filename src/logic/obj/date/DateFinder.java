package logic.obj.date;

import logic.obj.calendar.CalendarHandler;
import logic.find.Finder;
import models.Date;
import models.Day;

import java.util.List;

//Finds a date by its day, start and end hours
public class DateFinder extends DateHandler implements Finder {
    @Override
    public Object find(Object o) {
        Date searchDate = (Date) o;
        List<Day> days = CalendarHandler.calendar.getDays();

        if (days.isEmpty()) { return null; }

        for (Day day : days) {
            for (Date d : day.getDates()) {
                if (d.equivalent(searchDate)) {
                    return d;
                }
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Date searchDate = (Date) o;
        List<Day> days = CalendarHandler.calendar.getDays();

        if (days.isEmpty()) { return -1; }

        for (Day day : days) {
            for (Date d : day.getDates()) {
                if (d.equivalent(searchDate)) {
                    return day.getDates().indexOf(d);
                }
            }
        }
        return -1;
    }
}
