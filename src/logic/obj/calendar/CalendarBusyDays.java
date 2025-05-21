package logic.obj.calendar;

import models.calendar.Day;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CalendarBusyDays {
    /**
     * Returns a list of busy days from a range of days with how many hours are occupied.
     * @param from
     * From this day.
     * @param to
     * To this day.
     * @return
     * Returns all relevant days as a map of their hours and the days themselves.
     */
    public static Map<Integer, Day> busyDays(Day from, Day to) {
        if (from == null || to == null) {
            return null;
        }

        if (from.getLocalDate().isAfter(to.getLocalDate())) {
            return null;
        }

        Map<Day, Integer> hashDays = new HashMap<>();

        for (Day d : CalendarHandler.calendar.getDays()) {
            if (d.getLocalDate().isBefore(from.getLocalDate())) {
                continue;
            }

            if (d.getLocalDate().isAfter(to.getLocalDate())) {
                break;
            }

            if (hashDays.containsKey(d)) {
                hashDays.put(d, hashDays.get(d) + d.getAllOccupiedMinutes());
            } else {
                hashDays.put(d, d.getAllOccupiedMinutes());
            }
        }

        Map<Integer, Day> bd = new TreeMap<>(
                Comparator.reverseOrder()
        );

        for (Map.Entry<Day, Integer> diPair : hashDays.entrySet()) {
            bd.put(diPair.getValue(), diPair.getKey());
        }

        return bd;
    }
}
