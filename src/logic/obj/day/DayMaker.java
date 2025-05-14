package logic.obj.day;

import logic.find.Finders;
import models.Day;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

public class DayMaker extends DayHandler {
    // Makes a day if it doesn't exist
    public static boolean makeDay(LocalDate tempDay) {
        Day newDay = new Day(tempDay);

        if (Finders.dayFinder.findIndex(newDay) != -1) {
            days.add(newDay);
            days.sort(Comparator.comparing(Day::getLocalDate));
            return true;
        }
        return false;
    }
}