package logic.day;

import models.Day;

import java.time.LocalDate;

public class DayMaker extends DayHandler {
    public static boolean makeDay(LocalDate tempDay) {
        Day newDay = new Day(tempDay);
        if (DayFinder.findDay(newDay) == null) {
            days.add(days.size() / 2, newDay);
            return true;
        }
        return false;
    }
}