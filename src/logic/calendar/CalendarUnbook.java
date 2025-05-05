package logic.calendar;

import logic.date.DateFinder;
import logic.date.DateMaker;
import models.Date;
import models.Day;

import java.time.LocalTime;

//it just unbooks by removing an entry from the list
public class CalendarUnbook extends CalendarHandler {
    public static boolean unbook(Day day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDates().isEmpty()) { return false; }

        Date undate = DateMaker.makeDate(day, startTime, endTime, null, null);

        return calendar.getDates().remove(DateFinder.findDate(calendar, undate));
    }
}
