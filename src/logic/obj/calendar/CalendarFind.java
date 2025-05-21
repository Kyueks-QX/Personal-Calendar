package logic.obj.calendar;

import models.calendar.Date;
import models.calendar.Day;

import java.util.ArrayList;
import java.util.List;

public class CalendarFind extends CalendarHandler {
    public static List<Date> find(String str) {
        List<Date> dates = new ArrayList<>();

        for (Day day : CalendarHandler.calendar.getDays()) {
            for (Date d : day.getDates()) {
                if (d.getName().contains(str) || d.getNote().contains(str)) {
                    dates.add(d);
                }
            }
        }
        return dates;
    }
}