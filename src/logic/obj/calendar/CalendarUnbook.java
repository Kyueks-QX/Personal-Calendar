package logic.obj.calendar;

import logic.obj.date.DateMaker;
import logic.find.Finders;
import logic.obj.date.DateRemover;
import models.calendar.Date;
import models.calendar.Day;

import java.time.LocalTime;
import java.util.ArrayList;

//it just unbooks by removing an entry from the list
public class CalendarUnbook extends CalendarHandler {
    public static int unbook(Day targetDay, LocalTime startTime, LocalTime endTime) {
        if (targetDay == null || startTime == null || endTime == null) {
            return 1;
        }

        if (Finders.dayFinder.find(targetDay) == null) { return 2; }
        Day day = new Day((Day) Finders.dayFinder.find(targetDay));

        Date undate = DateMaker.makeDate(day, startTime, endTime, null, null);
        undate = (Date) Finders.dateFinder.find(undate);
        if (undate == null) { return 3; }

        DateRemover.removeDateFromDay(undate, day);

        return 0;
    }
}
