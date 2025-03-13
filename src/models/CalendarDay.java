package models;

import java.time.LocalDate;
import java.util.ArrayList;

// Each individual day has multiple dates.
// This assumes nobody would have a date that spans multiple days...
public class CalendarDay {
    private ArrayList<Date> dates;
    private LocalDate day;

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    private CalendarDay() {}

    private CalendarDay(Builder builder) {
        this.dates = builder.dates;
        this.day = builder.day;
    }

    public static class Builder {
        private ArrayList<Date> dates;
        private LocalDate day;

        public Builder() {}

        public Builder withDates(ArrayList<Date> dates) {
            this.dates = dates;
            return this;
        }

        public Builder withDay(LocalDate day) {
            this.day = day;
            return this;
        }

        public CalendarDay build() {
            return new CalendarDay(this);
        }
    }
}
