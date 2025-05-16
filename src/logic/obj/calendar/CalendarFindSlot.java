package logic.obj.calendar;

import logic.file_new.FileLoader;
import models.Calendar;
import models.Date;
import models.Day;

import java.time.LocalTime;
import java.util.ArrayList;

// find the next available non-holiday time slot
// has to be not earlier than 8 and not later than 17
public class CalendarFindSlot {
    public static Date findSlot(Day fromDay, int hours, String fileName) {
        //the gap between 8:00 and 17:00 is 9 hours
        if (fromDay == null || hours <= 0 || hours >= 9) {
            return null;
        }

        Calendar tempCalendar = null;
        if (fileName != null) {
            tempCalendar = FileLoader.loadCalendarFromFile(fileName);
        }
        Calendar[] twoCalendars = { CalendarHandler.calendar, tempCalendar };

        LocalTime earlyBoundary = LocalTime.of(8, 0, 0);
        LocalTime lateBoundary = LocalTime.of(17, 0, 0);

        for (Calendar c : twoCalendars) {
            if (c == null) {
                continue;
            }
            
            for (Day day : c.getDays()) {
                if (day.getLocalDate().isBefore(fromDay.getLocalDate()) || day.isHoliday()) {
                    continue;
                }

                ArrayList<Date> dates = day.getDates();

                for (int i = 0; i < dates.size() - 1; i++) {
                    Date prevDate = dates.get(i);
                    Date nextDate = dates.get(i + 1);

                    // skips all the dates that end before 8:00 or after 17:00
                    if (prevDate.getEndTime().isBefore(earlyBoundary) || prevDate.getEndTime().isAfter(lateBoundary)) {
                        continue;
                    }

                    // gets the time gap between a pair of dates
                    // if the gap is wide enough and doesn't go past 17:00, it counts as a valid time spot for a date
                    if (nextDate.getStartTimeAsInt() - prevDate.getEndTimeAsInt() >= hours * 3600 && lateBoundary.getHour() - prevDate.getEndTime().getHour() >= hours) {
                        LocalTime prevDateEndTime = prevDate.getEndTime();
                        return new Date.Builder()
                                .withStartTime(LocalTime.of(prevDateEndTime.getHour(), prevDateEndTime.getMinute(), 0))
                                .withEndTime(LocalTime.of(prevDateEndTime.getHour() + hours, prevDateEndTime.getMinute(), 0))
                                .build();
                    }
                }
            }
        }

        return null;
    }
}
