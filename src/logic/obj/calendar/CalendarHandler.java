package logic.obj.calendar;

import models.calendar.Calendar;

/**
 * All classes which handle classes inherit this.
 */
public abstract class CalendarHandler {
    /**
     * Publicly available calendar.
     */
    public static Calendar calendar = new Calendar();
}
