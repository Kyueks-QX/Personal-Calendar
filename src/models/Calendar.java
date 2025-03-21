package models;

import java.util.ArrayList;

// A single calendar containing all days.
// Has only one instance, since only one calendar will be loaded at any time.
// Lazy singleton used.
public class Calendar {
    private static Calendar singletonInstance;
    private ArrayList<Date> dates;

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    private Calendar() {}

    public static Calendar getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Calendar();
        }
        return singletonInstance;
    }
}
