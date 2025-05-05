package logic.calendar;

import models.Date;

import java.util.ArrayList;
import java.util.List;

public class CalendarFind extends CalendarHandler {
    public static List<Date> find(String str) {
        List<Date> dates = new ArrayList<>();
        for (Date d : CalendarHandler.calendar.getDates()) {
            if (d.equivalent(new Date.Builder().withName(str)) || d.equivalent(new Date.Builder().withNote(str))) {
                dates.add(d);
            }
        }
        return dates;
    }
}
