package logic.day;

import models.Day;

import java.time.LocalDate;

public class DayFinder {
    public static Day findDay(Day searchedDay) {
        for (Day day : DayHandler.days) {
            if (day.getDay() == searchedDay.getDay()) {
                return day;
            }
        }
        return null;
    }
}
