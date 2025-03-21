package logic;

import models.Calendar;
import models.Date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//Responsible for manipulating the calendar.
//Has a lot of structural issues.
public class Booking {
    private Calendar calendar;
    private TimeHandler timeHandler;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public TimeHandler getTimeHandler() {
        return timeHandler;
    }

    public void setTimeHandler(TimeHandler timeHandler) {
        this.timeHandler = timeHandler;
    }

    private Date findDate(LocalDate day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDates().isEmpty()) { return null; }

        Date searchDate = new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .build();

        for (Date d : calendar.getDates()) {
            if (d.equalsDayStartEndTime(searchDate)) { return d; }
        }
        return null;
    }

    //not made to check for conflicting dates yet
    public boolean book(LocalDate day, LocalTime startTime, LocalTime endTime, String name, String note) {
        ArrayList<Date> dates = calendar.getDates();
        dates.add(new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build()
        );
        calendar.setDates(dates);
        return true;
    }

    public boolean unbook(LocalDate day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDates().isEmpty()) { return false; }
        return calendar.getDates().remove(findDate(day, startTime, endTime));
    }
}
