package logic.obj.date;

import logic.obj.day.DayHandler;
import logic.obj.day.DayAdder;
import logic.find.Finders;
import models.Date;
import models.Day;

import java.time.LocalTime;
import java.util.ArrayList;

//Uses the Date class' builder to makeDate a new date, makes code look less bulky
public class DateMaker {
    public static Date makeDate(Day day, LocalTime startTime, LocalTime endTime, String name, String note) {
        if (Finders.dayFinder.findIndex(day) == -1) {
            DayAdder.addDay(day.getLocalDate());
        }

        if (startTime.isAfter(endTime)) {
            return null;
        }

        Date newDate = new Date.Builder()
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();

        ArrayList<Date> dates = day.getDates();
        dates.add(newDate);
        DateAdder.addDateToDay(newDate, day);
        DayAdder.addDay(day);

        return new Date.Builder()
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();
    }
}
