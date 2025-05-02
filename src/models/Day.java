package models;

import java.time.LocalDate;

public class Day {
    private LocalDate day;
    private boolean holiday;

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public Day(LocalDate day) {
        this.day = day;
        holiday = false;
    }

    public Day() {
        holiday = false;
    }
}
