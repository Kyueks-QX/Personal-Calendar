package logic.obj.calendar;

import logic.obj.date.DateConflict;
import logic.obj.date.DateMaker;
import logic.obj.day.DayAdder;
import models.Date;
import models.Day;

import java.time.LocalTime;
import java.util.ArrayList;

// adds an entry to the calendar if there are no conflicting (overlapping) dates
// also adds a day if it doesn't already exist

// return statuses:
// 0 (OK): Successfully booked
// 1 (ERROR): null argument(s) given
// 2 (ERROR): can't book on holidays
// 3 (ERROR): conflicts with another date
// 4 (ERROR): events ends before it starts

public class CalendarBook extends CalendarHandler {
    public static int book(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        if (day == null || startTime == null || endTime == null || name == null || note == null) {
            return 1;
        }

        DayAdder.addDay(day.getLocalDate());
        day = calendar.getSingleDay(day);

        if (day.isHoliday()) {
            return 2;
        }

        Date newDate = DateMaker.makeDate(day, startTime, endTime, name, note);


        if (DateConflict.isThereDateConflict(calendar, day, newDate)) {
            return 3;
        }

        if (!startTime.isBefore(endTime)) {
            return 4;
        }

        Day updatedDay = day;
        ArrayList<Date> dates = day.getDates();
        dates.add(newDate);
        day.setDates(dates);
        calendar.setSingleDay(day, updatedDay);
        return 0;
    }
}
