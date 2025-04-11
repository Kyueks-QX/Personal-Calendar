package logic.calendar_handlers;

import models.Calendar;

public abstract class CalendarHandler {
    Calendar calendar;

    public CalendarHandler(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
