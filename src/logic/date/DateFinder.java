package logic.date;

import models.Calendar;
import models.Date;

//Finds a date by its day, start and end hours
public class DateFinder extends DateHandler {
    public static Date findDate(Calendar calendar, Date searchDate) {
        if (calendar.getDates().isEmpty()) { return null; }

        for (Date d : calendar.getDates()) {
            if (d.equivalent(searchDate)) { return d; }
        }
        return null;
    }
}
