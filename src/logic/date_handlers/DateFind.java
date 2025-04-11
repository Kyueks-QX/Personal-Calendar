package logic.date_handlers;

import logic.date_handlers.DateHandler;
import models.Calendar;
import models.Date;

//Finds a date by its day, start and end hours
public class DateFind extends DateHandler {
    public DateFind(Calendar calendar, Date date) {
        super(calendar, date);
    }

    public static Date findDate(Calendar calendar, Date searchDate) {
        if (calendar.getDates().isEmpty()) { return null; }

        for (Date d : calendar.getDates()) {
            if (d.equivalent(searchDate)) { return d; }
        }
        return null;
    }
}
