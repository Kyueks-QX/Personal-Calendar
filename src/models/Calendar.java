package models;

import logic.find.Finders;
import logic.obj.calendar.CalendarHandler;

import java.util.*;

// A single calendar containing all days.
// Has only one instance, since only one calendar will be loaded at any time.
// Lazy singleton used.
public class Calendar {
    private static Calendar singletonInstance;
    private List<Day> days;

    public ArrayList<Day> getDays() {
        return (ArrayList<Day>) days;
    }

    public Day getSingleDay(Day day) {
        return days.get(Finders.dayFinder.findIndex(day));
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    public void setSingleDay(Day targetDay, Day newDay) {
        days.set(Finders.dayFinder.findIndex(targetDay), newDay);
    }

    private Calendar() {}

    public Calendar getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Calendar();
            this.days = new ArrayList<>();
        }
        return singletonInstance;
    }
}
