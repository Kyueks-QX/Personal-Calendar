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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    //it finds if a date exists
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

    //adds an entry to the calendar if there are no conflicting (overlapping) dates
    public boolean book(LocalDate day, LocalTime startTime, LocalTime endTime, String name, String note) {
        Date newDate = new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .withName(name)
                .withNote(note)
                .build();

        if (TimeHandler.isThereDateConflict(calendar, newDate)) {
            ArrayList<Date> dates = calendar.getDates();
            dates.add(newDate);
            calendar.setDates(dates);
            return true;
        }
        return false;
    }

    //it just unbooks by removing an entry from the list
    public boolean unbook(LocalDate day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDates().isEmpty()) { return false; }
        return calendar.getDates().remove(TimeHandler.findDate(calendar, day, startTime, endTime));
    }
}
