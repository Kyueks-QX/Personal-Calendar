package logic.calendar_handlers;

import models.Calendar;
import models.Date;

import java.time.LocalDate;
import java.util.ArrayList;

//returns all dates in a given day
public class CalendarAgenda extends CalendarHandler {
    public CalendarAgenda(Calendar calendar) {
        super(calendar);
    }

    public ArrayList<Date> agenda(LocalDate day) {
        ArrayList<Date> todayDates = new ArrayList<>();

        for (Date date : calendar.getDates()) {
            if (date.getDay() == day) { todayDates.add(date); }
        }
        return todayDates;
    }
}
