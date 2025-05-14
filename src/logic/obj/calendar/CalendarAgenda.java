package logic.obj.calendar;

import logic.obj.day.DayHandler;
import logic.find.Finders;
import models.Date;
import models.Day;

import java.util.ArrayList;
import java.util.List;

//returns all dates in a given day
public class CalendarAgenda extends CalendarHandler {
    public static List<Date> agenda(Day agendaDay) {
        if (agendaDay == null) { return null; }

        List<Date> todayDates = new ArrayList<>();

        Day day = CalendarHandler.calendar.getSingleDay(agendaDay);
        if (day == null) { return null; }

        for (Date date : day.getDates()) {
            if (day.getDates().contains(date) && !day.isHoliday()) { todayDates.add(date); }
        }
        return todayDates;
    }
}
