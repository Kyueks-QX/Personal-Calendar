package logic.calendar;

import logic.date.DateConflict;
import logic.date.DateMake;
import models.Calendar;
import models.Date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//adds an entry to the calendar if there are no conflicting (overlapping) dates
public class CalendarBook extends CalendarHandler {
    public static boolean book(LocalDate day, LocalTime startTime, LocalTime endTime, String name, String note) {
        Date newDate = DateMake.make(day, startTime, endTime, name, note);

        if (!DateConflict.isThereDateConflict(calendar, newDate) && startTime.isBefore(endTime)) {
            ArrayList<Date> dates = calendar.getDates();
            dates.add(newDate);
            calendar.setDates(dates);
            return true;
        }
        return false;
    }
}
