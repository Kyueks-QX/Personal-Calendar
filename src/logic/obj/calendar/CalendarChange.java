package logic.obj.calendar;

import logic.obj.date.DateAdder;
import logic.obj.date.DateChanger;
import logic.obj.date.DateConflict;
import logic.obj.date.DateMaker;
import logic.find.Finders;
import logic.obj.day.DayAdder;
import models.Date;
import models.DateFieldNames;
import models.Day;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//changes any value the user wants by passing the date's day, start time, which field and with what value to change

// return statuses:
// 0 (OK): Successfully booked
// 1 (ERROR): date field error (how did this happen)
// 2 (ERROR): unknown error
// 3 (ERROR): conflicts with another date
// 4 (ERROR): changed date conflicts with other dates
// 5 (ERROR): null argument(s) given

public class CalendarChange extends CalendarHandler {
    public int change(Day day, LocalTime startTime, DateFieldNames dateFieldNames, String newValue) {
        if (calendar.getSingleDay(day) == null || startTime == null || dateFieldNames == null || newValue == null) {
            return 5;
        }

        Date d = DateMaker.makeDate(day, startTime, null, null, null);
        day = calendar.getSingleDay(day);
        Date changeDate = (Date) Finders.dateFinder.find(d);

        if (day.getDates().contains(changeDate) && changeDate != null) {
            try {
                switch (dateFieldNames) {
                    case DATE: {
                        Day newDay = new Day(LocalDate.parse(newValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        DayAdder.addDay(newDay);
                        if (DateChanger.changeDayOfDate(day, newDay, changeDate) != 0) { return 4; }
                        return 0;
                    }
                    case START_TIME: {
                        changeDate.setStartTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, day, changeDate)) { return 4; }
                        break;
                    }
                    case END_TIME: {
                        changeDate.setEndTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, day, changeDate)) { return 4; }
                        break;
                    }
                    case NAME: {
                        changeDate.setName(newValue);
                        break;
                    }
                    case NOTE: {
                        changeDate.setNote(newValue);
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

        day.setSingleDate((Date) Finders.dateFinder.find(d), changeDate);

        return 0;
    }
}
