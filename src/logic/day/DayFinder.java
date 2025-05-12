package logic.day;

import logic.misc.Finder;
import models.Day;

public class DayFinder extends DayHandler implements Finder {
    @Override
    public Object find(Object o) {
        return findDay((Day) o);
    }

    public static Day findDay(Day searchedDay) {
        for (Day day : days) {
            if (day.getDay() == searchedDay.getDay()) {
                return days.get(days.indexOf(day));
            }
        }

        return null;
    }

    @Override
    public int findIndex(Object o) {
        return findDayIndex((Day) o);
    }

    public static int findDayIndex(Day searchedDay) {
        for (Day day : days) {
            if (day.getDay() == searchedDay.getDay()) {
                return days.indexOf(day);
            }
        }
        return -1;
    }
}
