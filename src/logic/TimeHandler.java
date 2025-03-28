package logic;

import models.Calendar;
import models.Date;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeHandler {
    public static Date findDate(Calendar calendar, LocalDate day, LocalTime startTime, LocalTime endTime) {
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

    public static boolean isThereDateConflict(Calendar calendar, Date newDate) {
        for (Date date : calendar.getDates()) {
            if (date.getEndTime().isAfter(newDate.getStartTime()) && date.getDay().isEqual(newDate.getDay())) {
                return false;
            }
        }
        return true;
    }
}
