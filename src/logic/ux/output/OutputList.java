package logic.ux.output;

import models.calendar.Date;
import models.calendar.Day;

import java.util.List;
import java.util.Map;

public class OutputList {
    public static void printDateList(List<Date> dates) {
        for (Date date : dates) {
            System.out.println(date.toString());
        }
    }

    public static void printMapIntDay(Map<Integer, Day> busyDays) {
        for (Map.Entry<Integer, Day> busyDay : busyDays.entrySet()) {
            System.out.println(
                    busyDay.getValue().getLocalDateAsString()
                    + ", " + (busyDay.getKey() / 60.0f) + " hour(s)"
            );
        }
    }
}
