package logic.obj.calendar;

import logic.file.FileLoader;
import logic.obj.date.DateAdder;
import logic.obj.day.DayAdder;
import models.calendar.Calendar;
import models.calendar.Date;
import models.calendar.Day;

public class CalendarMerge {
    /**
     * Merges all dates from file into the current calendar.
     * @param fileName
     * The name of the file whose data will be pulled from.
     */
    public static void merge(String fileName) {
        Calendar tempCalendar = FileLoader.loadCalendarFromFile(fileName);
        if (tempCalendar == null) {
            return;
        }

        for (Day day : tempCalendar.getDays()) {
            DayAdder.addDay(day);
            for (Date date : day.getDates()) {
                DateAdder.addDateToDay(date, day);
            }
        }
    }
}
