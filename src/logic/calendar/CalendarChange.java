package logic.calendar;

import logic.date.DateConflict;
import logic.date.DateFind;
import logic.date.DateMake;
import models.Calendar;
import models.Date;
import models.DateFieldNames;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//changes any value the user wants by passing the date's day, start time, which field and with what value to change
public class CalendarChange extends CalendarHandler {
    public boolean change(LocalDate day, LocalTime startTime, DateFieldNames dateFieldNames, String newValue) {
        Date d = DateMake.make(day, startTime, null, null, null);

        Date changeDate = DateFind.findDate(calendar, d);

        if (calendar.getDates().contains(changeDate) && changeDate != null) {
            try {
                switch (dateFieldNames) {
                    case DATE: {
                        changeDate.setDay(LocalDate.parse(newValue, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        if (DateConflict.isThereDateConflict(calendar, changeDate)) { return false; }
                        break;
                    }
                    case START_TIME: {
                        changeDate.setStartTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, changeDate)) { return false; }
                        break;
                    }
                    case END_TIME: {
                        changeDate.setEndTime(LocalTime.parse(newValue, DateTimeFormatter.ofPattern("HH:mm")));
                        if (DateConflict.isThereDateConflict(calendar, changeDate)) { return false; }
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
                        return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        else { return false; }

        int dateIndex = calendar.getDates().indexOf(changeDate);
        ArrayList<Date> dates = calendar.getDates();

        dates.set(dateIndex, changeDate);
        return true;
    }
}
