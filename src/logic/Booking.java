package logic;

import models.Calendar;
import models.Date;
import models.DateFieldNames;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            if (d.equivalent(searchDate)) { return d; }
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

        if (!TimeHandler.isThereDateConflict(calendar, newDate) && startTime.isBefore(endTime)) {
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

        Date undate = new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .withEndTime(endTime)
                .build();

        return calendar.getDates().remove(TimeHandler.findDate(calendar, undate));
    }

    //changes any value the user wants by passing the date's day, start time, which field and with what value to change
    public boolean change(LocalDate day, LocalTime startTime, DateFieldNames dateFieldNames, String newValue) {
        Date d = new Date.Builder()
                .withDay(day)
                .withStartTime(startTime)
                .build();

        Date changeDate = TimeHandler.findDate(calendar, d);

        if (calendar.getDates().contains(changeDate) && changeDate != null) {
            try {
                switch (dateFieldNames) {
                    case DATE: {
                        changeDate.setDay(LocalDate.parse(newValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        if (TimeHandler.isThereDateConflict(calendar, changeDate)) { return false; }
                        break;
                    }
                    case START_TIME: {
                        changeDate.setStartTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (TimeHandler.isThereDateConflict(calendar, changeDate)) { return false; }
                        break;
                    }
                    case END_TIME: {
                        changeDate.setEndTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (TimeHandler.isThereDateConflict(calendar, changeDate)) { return false; }
                        break;
                    }
                    case NAME: {
                        changeDate.setName(newValue);
                        break;
                    }
                    case NOTE: {
                        changeDate.setNote(newValue);
                        break;
                    }
                    default:
                        return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        else { return false; }

        int dateIndex = calendar.getDates().indexOf(changeDate);
        ArrayList<Date> dates = calendar.getDates();

        dates.set(dateIndex, changeDate);
        return true;
    }

    //returns all dates in a given day
    public ArrayList<Date> agenda(LocalDate day) {
        ArrayList<Date> todayDates = new ArrayList<>();

        for (Date date : calendar.getDates()) {
            if (date.getDay() == day) { todayDates.add(date); }
        }
        return todayDates;
    }
}
