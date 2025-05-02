package logic.calendar;

import models.Calendar;
import models.Date;
import models.Day;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//returns all dates in a given day
public class CalendarAgenda extends CalendarHandler {
    public static List<Date> agenda(Day day) {
        List<Date> todayDates = new ArrayList<>();

        for (Date date : calendar.getDates()) {
            if (date.getDay() == day) { todayDates.add(date); }
        }
        return todayDates;
    }
}
