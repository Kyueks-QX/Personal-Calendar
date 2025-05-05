package logic.date;

import logic.day.DayFinder;
import logic.day.DayHandler;
import logic.day.DayMaker;
import models.Date;
import models.Day;

import java.time.LocalTime;

//Uses the Date class' builder to makeDate a new date, makes code look less bulky
public class DateMaker {
    public static Date makeDate(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        if (DayFinder.dayIndex(day) == -1) {
            DayMaker.makeDay(day.getDay());
        }

        return new Date.Builder()
                .withDay(DayHandler.days.get(DayFinder.dayIndex(day)))
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();
    }
}
