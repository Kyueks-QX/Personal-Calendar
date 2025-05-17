package logic.obj.day;

import logic.find.Finder;
import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;
import models.Date;
import models.Day;

import java.util.List;

public class DayFinder extends DayHandler implements Finder {
    @Override
    public Object find(Object o) {
        Day searchedDay = (Day) o;
        List<Day> days = CalendarHandler.calendar.getDays();

        for (Day day : days) {
            if (day.equals(searchedDay)) {
                return searchedDay;
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Day searchedDay = (Day) o;
        List<Day> days = CalendarHandler.calendar.getDays();

        for (Day day : days) {
            if (day.equals(searchedDay)) {
                return days.indexOf(searchedDay);
            }
        }
        return -1;
    }

    public Day findFromDate(Date d) {
        List<Day> days = CalendarHandler.calendar.getDays();

        for (Day day : days) {
            for (Date date : day.getDates()) {
                if (Finders.dateFinder.find(date).equals(d)) {
                    return day;
                }
            }
        }
        return null;
    }
}
