package logic.obj.date;

import logic.obj.day.DayAdder;
import logic.find.Finders;
import models.calendar.Date;
import models.calendar.Day;

import java.time.LocalTime;
import java.util.ArrayList;

//Uses the Date class' builder to makeDate a new date, makes code look less bulky
public class DateMaker {
    /**
     * Uses the Date class' builder to makeDate a new date, makes code look less bulky.
     * @param day
     * Which day the date belongs to.
     * @param startTime
     * Date start time.
     * @param endTime
     * Date end time.
     * @param name
     * Date name.
     * @param note
     * Date note.
     * @return
     * The new Date object made with those params.
     */
    public static Date makeDate(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        if (Finders.dayFinder.findIndex(day) == -1) {
            DayAdder.addDay(day.getLocalDate());
        }

        if (endTime != null) {
            if (startTime.isAfter(endTime)) {
                return null;
            }
        }

        return new Date.Builder()
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();
    }
}
