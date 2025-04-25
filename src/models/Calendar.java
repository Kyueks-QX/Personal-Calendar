package models;

import java.util.ArrayList;
import java.util.List;

// A single calendar containing all days.
// Has only one instance, since only one calendar will be loaded at any time.
// Lazy singleton used.
public class Calendar {
    private static Calendar singletonInstance;
    private List<Date> dates;

    public ArrayList<Date> getDates() {
        return (ArrayList<Date>) dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    private Calendar() {}

    public Calendar getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Calendar();
            this.dates = new ArrayList<>();
        }
        return singletonInstance;
    }
}
