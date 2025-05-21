package logic.obj.calendar;

import logic.obj.date.DateMover;
import logic.obj.date.DateConflict;
import logic.obj.date.DateMaker;
import logic.find.Finders;
import logic.obj.day.DayAdder;
import models.calendar.Date;
import models.calendar.DateFieldNames;
import models.calendar.Day;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//changes any value the user wants by passing the date's day, start time, which field and with what value to change

// return statuses:
// 0 (OK): Successfully booked
// 1 (ERROR): date field error (how did this happen)
// 2 (ERROR): unknown error
// 3 (ERROR): date doesn't exist in calendar
// 4 (ERROR): changed date conflicts with other dates
// 5 (ERROR): null argument(s) given

public class CalendarChange extends CalendarHandler {
    /**
     * Changes any value the user wants by passing the date's day, start time, which field and with what value to change.
     * @param day
     * Date's day.
     * @param startTime
     * Date's start time.
     * @param dateFieldNames
     * Date's field.
     * @param newValue
     * New value to be entered into the field.
     * @return
     * Returns status after attempting to change the day.
     */
    public static int change(Day day, LocalTime startTime, DateFieldNames dateFieldNames, String newValue) {
        if (calendar.getSingleDay(day) == null || startTime == null || dateFieldNames == null || newValue == null) {
            return 5;
        }

        Date d = DateMaker.makeDate(day, startTime, null, null, null);
        Date changeDate = (Date) Finders.dateFinder.find(d);
        day = calendar.getSingleDay(day);
        Date oldDate = day.getSingleDate(changeDate);

        if (day.getDates().contains(oldDate) && oldDate != null) {
            try {
                switch (dateFieldNames) {
                    case DAY: {
                        Day newDay = new Day(LocalDate.parse(newValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        DayAdder.addDay(newDay);
                        if (DateMover.changeDayOfDate(day, newDay, oldDate) != 0) { return 4; }
                        return 0;
                    }
                    case STARTTIME: {
                        changeDate.setStartTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, day, oldDate)) { return 4; }
                        break;
                    }
                    case ENDTIME: {
                        changeDate.setEndTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, day, oldDate)) { return 4; }
                        break;
                    }
                    case NAME: {
                        oldDate.setName(newValue);
                        break;
                    }
                    case NOTE: {
                        oldDate.setNote(newValue);
                        break;
                    }
                    default:
                        return 1;
                }
            } catch (Exception e) {
                return 2;
            }
        }
        else { return 3; }

        return 0;
    }
}
