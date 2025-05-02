package logic.date;

import models.Date;
import models.Day;

import java.time.LocalDate;
import java.time.LocalTime;

//Uses the Date class' builder to make a new date, makes code look less bulky
public class DateMaker {
    public static Date make(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        return new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();
    }
}
