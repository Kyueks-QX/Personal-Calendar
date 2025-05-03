package logic.day;

import models.Day;

import java.time.LocalDate;

public class DayMaker extends DayHandler {
    // Makes a day if it doesn't exist
    public static boolean makeDay(LocalDate tempDay) {
        Day newDay = new Day(tempDay);
        if (DayFinder.dayIndex(newDay) != -1) {
            DaySorter.insertWithBinary(newDay);
            return true;
        }
        return false;
    }
}