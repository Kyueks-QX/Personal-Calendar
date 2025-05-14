package logic.obj.calendar;

import models.Date;
import models.Day;

import java.util.ArrayList;
import java.util.List;

public class CalendarFind extends CalendarHandler {
    public static List<Date> find(String str) {
        List<Date> dates = new ArrayList<>();

        for (Day day : CalendarHandler.calendar.getDays()) {
            for (Date d : day.getDates()) {
                if (d.equivalent(new Date.Builder().withName(str)) || d.equivalent(new Date.Builder().withNote(str))) {
                    dates.add(d);
                }
            }
        }
        return dates;
    }
}