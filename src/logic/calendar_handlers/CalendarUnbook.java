package logic.calendar_handlers;

import logic.DateHandler;
import logic.date_handlers.DateMake;
import models.Calendar;
import models.Date;

import java.time.LocalDate;
import java.time.LocalTime;

//it just unbooks by removing an entry from the list
public class CalendarUnbook extends CalendarHandler {
    public CalendarUnbook(Calendar calendar) {
        super(calendar);
    }

    public boolean unbook(LocalDate day, LocalTime startTime, LocalTime endTime) {
        if (calendar.getDates().isEmpty()) { return false; }

        Date undate = DateMake.make(day, startTime, endTime, null, null);

        return calendar.getDates().remove(DateHandler.findDate(calendar, undate));
    }
}
