package logic.calendar;

import logic.date.DateConflict;
import logic.date.DateMaker;
import logic.day.DayFinder;
import logic.day.DayHandler;
import logic.day.DayMaker;
import models.Date;
import models.Day;

import java.time.LocalTime;
import java.util.ArrayList;

//adds an entry to the calendar if there are no conflicting (overlapping) dates
//also adds a day if it doesn't already exist
public class CalendarBook extends CalendarHandler {
    public static boolean book(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        DayMaker.makeDay(day.getDay());
        if (DayHandler.days.get(DayFinder.dayIndex(day)).isHoliday()) {
            return false;
        }

        Date newDate = DateMaker.make(day, startTime, endTime, name, note);

        if (!DateConflict.isThereDateConflict(calendar, newDate) && startTime.isBefore(endTime)) {
            ArrayList<Date> dates = calendar.getDates();
            dates.add(newDate);
            calendar.setDates(dates);
            return true;
        }
        return false;
    }
}
