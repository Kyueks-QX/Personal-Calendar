package logic.obj.calendar;

import logic.file.FileLoader;
import models.calendar.Calendar;
import models.calendar.Date;
import models.calendar.Day;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

// find the next available non-holiday time slot
// has to be not earlier than 8 and not later than 17
// findslot merged with findslotwith

public class CalendarFindSlot {
    /**
     * Finds an available hour in a day from 8:00 to 17:00.
     * @param fromDay
     * Chosen day.
     * @param hours
     * How many hours the free slot should be.
     * @param fileName
     * Whether to also search from the currently selected file and its name.
     * @return
     * Returns a temporary date that contains the free hours if they're found.
     */
    public static Date findSlot(Day fromDay, int hours, String fileName) {
        //the gap between 8:00 and 17:00 is 9 hours
        if (fromDay == null || hours <= 0 || hours >= 9) {
            return null;
        }

        Calendar tempCalendar = null;
        if (fileName != null) {
            tempCalendar = FileLoader.loadCalendarFromFile(fileName);
        }
        if (Objects.equals(fileName, "*")) {
            tempCalendar = null;
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

                for (int i = -1; i < dates.size(); i++) {
                    Date prevDate = null;
                    Date nextDate;
                    int leftHour;
                    int rightHour;
                    if (i != -1) {
                        prevDate = dates.get(i);
                        leftHour = prevDate.getEndTimeAsInt();
                    } else {
                        leftHour = earlyBoundary.getHour() * 60;
                    }
                    if (i != dates.size() - 1) {
                        nextDate = dates.get(i + 1);
                        rightHour = nextDate.getStartTimeAsInt();
                    } else {
                        rightHour = lateBoundary.getHour() * 60;
                    }

                    // skips all the dates that end before 8:00 or after 17:00
                    if (prevDate != null) {
                        if (prevDate.getEndTime().isBefore(earlyBoundary) || prevDate.getEndTime().isAfter(lateBoundary)) {
                            continue;
                        }
                    }

                    // gets the time gap between a pair of dates
                    // if the gap is wide enough and doesn't go past 17:00, it counts as a valid time spot for a date
                    if (rightHour - leftHour >= hours * 60 && lateBoundary.getHour() - leftHour / 60 >= hours) {
                        LocalTime prevDateEndTime = LocalTime.of(leftHour / 60, leftHour % 60);
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
