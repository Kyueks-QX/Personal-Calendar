package logic.date_handlers;

import models.Calendar;
import models.Date;

public abstract class DateHandler {
    Calendar calendar;
    Date date;

    public DateHandler(Calendar calendar, Date date) {
        this.calendar = calendar;
        this.date = date;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
