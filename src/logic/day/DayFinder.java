package logic.day;

import models.Day;

public class DayFinder {
    public static int dayIndex(Day searchedDay) {
        for (Day day : DayHandler.days) {
            if (day.getDay() == searchedDay.getDay()) {
                return DayHandler.days.indexOf(day);
            }
        }
        return -1;
    }
}
