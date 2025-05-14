package logic.obj.calendar;

import logic.obj.date.DateMaker;
import logic.find.Finders;
import models.Date;
import models.Day;

import java.time.LocalTime;

//it just unbooks by removing an entry from the list
public class CalendarUnbook extends CalendarHandler {
    public static boolean unbook(Day day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDays().isEmpty()) { return false; }

        Date undate = DateMaker.makeDate(day, startTime, endTime, null, null);

        return calendar.getDays().remove((Date) Finders.dateFinder.find(undate));
    }
}
