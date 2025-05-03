package logic.day;

import models.Day;

public class DaySorter {
    // inserts into the Day array using binary search
    // all elements should be sorted for the search to work
    // returns null if it finds the date already in the array
    // otherwise returns the day itself
    public static Day insertWithBinary(Day day) {
        int left = 0, right = DayHandler.days.size() - 1, mid = (right - left) / 2;

        while (left <= right) {
            mid = (right - left) / 2;

            if (day.getDay().isBefore(DayHandler.days.get(mid).getDay())) {
                right = mid;
                continue;
            }

            if (day.getDay().isAfter(DayHandler.days.get(mid).getDay())) {
                left = mid;
                continue;
            }

            return null;
        }

        DayHandler.days.add(mid, day);
        return day;
    }
}
