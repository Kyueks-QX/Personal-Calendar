package logic.calendar;

import logic.date.DateConflict;
import logic.date.DateMaker;
import models.Date;
import models.Day;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//adds an entry to the calendar if there are no conflicting (overlapping) dates
public class CalendarBook extends CalendarHandler {
    public static boolean book(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
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
