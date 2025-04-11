package logic.date_handlers;

import models.Date;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateMake {
    public static Date make(LocalDate day, LocalTime startTime, LocalTime endTime, String name, String note) {
        return new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();
    }
}
