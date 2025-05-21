package models.calendar;

import logic.find.Finders;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Day implements Serializable {
    private LocalDate localDate;
    private boolean holiday;
    private List<Date> dates;
    //I have to refactor a lot of stuff to work with this...

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getLocalDateAsString() {
        return localDate.getDayOfMonth() + "-"
                + localDate.getMonthValue() + "-"
                + localDate.getYear();
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public ArrayList<Date> getDates() {
        return (ArrayList<Date>) dates;
    }

    public int getAllOccupiedMinutes() {
        int sum = 0;
        for (Date d : dates) {
            sum += d.getEndTimeAsInt() - d.getStartTimeAsInt();
        }
        return sum;
    }

    public Date getSingleDate(Date date) {
        int index = Finders.dateFinder.findIndex(date);
        if (index == -1) {
            return null;
        }
        return dates.get(index);
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }

    public void setSingleDate(Date targetDate, Date newDate) {
        dates.set(Finders.dateFinder.findIndex(targetDate), newDate);
    }

    public Day(LocalDate day) {
        this.localDate = day;
        holiday = false;
        dates = new ArrayList<>();
    }

    public Day() {
        localDate = null;
        holiday = false;
        dates = new ArrayList<>();
    }

    //this is for making an identical object in a different instance
    public Day(Day day) {
        this.localDate = day.localDate;
        this.holiday = day.holiday;
        this.dates = day.dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day = (Day) o;
        return isHoliday() == day.isHoliday() && Objects.equals(getLocalDate(), day.getLocalDate()) && Objects.equals(getDates(), day.getDates());
    }
}
