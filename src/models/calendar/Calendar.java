package models.calendar;

import logic.find.Finders;

import java.io.Serializable;
import java.util.*;

// A single calendar containing all days.
// --Has only one instance, since only one calendar will be loaded at any time.--
// Nevermind, I found a reason to have multiple calendars loaded at once.
public class Calendar implements Serializable {
    private List<Day> days;

    public ArrayList<Day> getDays() {
        return (ArrayList<Day>) days;
    }

    public Day getSingleDay(Day day) {
        int index = Finders.dayFinder.findIndex(day);
        if (index == -1) {
            return null;
        }
        return days.get(index);
    }

    public void setDays(ArrayList<Day> days) {
        this.days = days;
    }

    public void setSingleDay(Day targetDay, Day newDay) {
        int index = Finders.dayFinder.findIndex(targetDay);
        if (index == -1) {
            return;
        }
        days.set(index, newDay);
    }

    public Calendar() {
        days = new ArrayList<>();
    }
}
