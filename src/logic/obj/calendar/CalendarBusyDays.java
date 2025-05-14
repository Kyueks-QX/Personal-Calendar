package logic.obj.calendar;

import logic.obj.day.DayHandler;
import models.Day;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CalendarBusyDays {
    public static Map<Integer, Day> busyDays(Day from, Day to) {
        Map<Integer, Day> bd = new TreeMap<>(
                Comparator.reverseOrder()
        );

        for (Day d : DayHandler.days) {
            if (d.getLocalDate().isBefore(from.getLocalDate()) || d.getLocalDate().isAfter(to.getLocalDate())) {
                continue;
            }

            //CAN'T DO SHIT I NEED TO REFACTOR DAY AND DATE CLASSES AGAIN AAAAAA
            //heavens help me
        }
    }
}
