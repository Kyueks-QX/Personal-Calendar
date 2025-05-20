package logic.obj.uao.menu;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.calendar.Date;
import models.calendar.Day;
import models.uao.Menu;
import models.uao.UserActionObject;

import java.util.HashMap;
import java.util.Map;

public class MenuResponse extends UAOHandler {
    public static Menu dateConflict(Day day, Date date1, Date date2) {
        Menu menu = new Menu.Builder().build();

        StringBuilder sb = new StringBuilder();
        sb.append("Date with hours from ").append(date1.getStartTimeAsString())
                .append(" to ").append(date1.getEndTimeAsString()).append("\n")
                .append(" conflicts with ")
                .append("Date with hours from ").append(date2.getStartTimeAsString())
                .append(" to ").append(date2.getEndTimeAsString()).append("\n")
                .append(" on ").append(day.getLocalDateAsString()).append(".\n");

        menu.setName(UAONames.MENU_DATECONF);
        menu.setDesc(sb.toString());

        HashMap<UAONames, String> options = new HashMap<>();
        options.put(null, "Keep the first date");
        options.put(null, "Keep the second date");
        options.put(null, "Move the first date to another time slot");
        options.put(null, "Move the second date to another time slot");
        menu.setOptions(options);

        return menu;
    }
}
