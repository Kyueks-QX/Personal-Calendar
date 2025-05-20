package logic.obj.calendar;

import logic.file_new.FileLoader;
import logic.find.Finders;
import logic.obj.day.DayAdder;
import models.calendar.Calendar;
import models.calendar.Date;
import models.calendar.Day;

public class CalendarMerge {
    public static void merge(String fileName) {
        Calendar tempCalendar = FileLoader.loadCalendarFromFile(fileName);
        Day calDay;

        for (Day day : tempCalendar.getDays()) {
            DayAdder.addDay(day);
            calDay = (Day) Finders.dayFinder.find(day);

            for (Date date : day.getDates()) {
                if (CalendarBook.book(calDay, date.getStartTime(), date.getEndTime(), date.getName(), date.getNote()) == 3) {

                }
            }
        }
    }
}
