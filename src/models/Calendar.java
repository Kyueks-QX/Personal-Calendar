package models;

import java.util.ArrayList;

// A single calendar containing all days.
// Has only one instance, since only one calendar will be loaded at any time.
// Lazy singleton used.
public class Calendar {
    private static Calendar singletonInstance;
    private ArrayList<CalendarDay> calendarDays;

    public ArrayList<CalendarDay> getCalendarDays() {
        return calendarDays;
    }

    public void setCalendarDays(ArrayList<CalendarDay> calendarDays) {
        this.calendarDays = calendarDays;
    }

    private Calendar() {}

    public static Calendar getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Calendar();
        }
        return singletonInstance;
    }
}
