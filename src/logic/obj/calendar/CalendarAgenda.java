package logic.obj.calendar;

import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;
import java.util.List;

public class CalendarAgenda extends CalendarHandler {
    /**
     * Returns all dates in a given day.
     * @param agendaDay
     * The day whose dates will be extracted from.
     * @return
     * Returns an ArrayList of Dates.
     */
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
