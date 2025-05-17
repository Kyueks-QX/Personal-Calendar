package logic.obj.uao.menu;

import logic.find.Finders;
import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOHandler;
import models.*;

import java.util.HashMap;
import java.util.Map;

// Adds all userActionObjects to the list of userActionObjects the program has
public class MenuAdder extends UAOHandler implements UAOAdder {
    private static Menu menu;
    private static String name;
    private static String desc;
    private static Map<UserActionObject, String> options;

    @Override
    public void addAllInitUAO() {
        addAllInitMenus();
    }

    private static void addAllInitMenus() {
        mainMenu();
        exit();
        calendarChangeMenu();
        calendarViewMenu();
    }

    @Override
    public void addUAO() {
        addMenu();
    }

    private static void addMenu() {
        menu = MenuMaker.makeMenu(name, desc, options, null);
        UAOHandler.userActionObjects.add(menu);
    }

    // this just shortens the call, so I don't have to copy-paste the whole thing every time
    private static Menu getMenu(String menuName) {
        return Finders.menuFinder.findMenuByName(menuName);
    }

    private static void mainMenu() {
        name = "mainMenu";
        desc = "Welcome to your personal calendar!";

        options = new HashMap<>();
        options.put(getMenu("calendarChangeMenu"), "Make changes to the calendar");
        options.put(getMenu("calendarViewMenu"), "View calendar content");
        options.put(null, "Files");
        options.put(getMenu("exit"), "Exit program");

        addMenu();
    }

    private static void exit() {
        name = "exit";
        desc = "See you next time!";

        addMenu();
    }

    private static void calendarChangeMenu() {
        name = "calendarChangeMenu";
        desc = "What would you like to do with your calendar?";

        options = new HashMap<>();
        options.put(null, "Book a date");
        options.put(null, "Change a date");
        options.put(null, "Remove a date");
        options.put(null, "(Un)mark day as holiday");
        options.put(null, "Merge saved calendar into current calendar");
        options.put(getMenu("mainMenu"), "Back to main menu");

        addMenu();
    }

    private static void calendarViewMenu() {
        name = "calendarViewMenu";
        desc = "What would you like to view from your calendar?";

        options = new HashMap<>();
        options.put(null, "See all dates in a given day");
        options.put(null, "See all days with dates");
        options.put(null, "Find all dates with a name/note");
        options.put(null, "Find the earliest spot available for a given date");
        options.put(getMenu("mainMenu"), "Back to main menu");

        addMenu();
    }

    private static void dateConflict() {
        Day day = (Day) menuArgs.get(0);
        Date date1 = (Date) menuArgs.get(1);
        Date date2 = (Date) menuArgs.get(2);

        StringBuilder sb = new StringBuilder();
        sb.append("Date with hours from ").append(date1.getStartTimeAsString())
                .append(" to ").append(date1.getEndTimeAsString()).append("\n")
                .append(" conflicts with ")
                .append("Date with hours from ").append(date2.getStartTimeAsString())
                .append(" to ").append(date2.getEndTimeAsString()).append("\n")
                .append(" on ").append(day.getLocalDateAsString()).append(".\n");

        name = "dateConflict";
        desc = sb.toString();

        options = new HashMap<>();
        options.put(null, "Keep the first date");
        options.put(null, "Keep the second date");
        options.put(null, "Move the first date to another time slot");
        options.put(null, "Move the second date to another time slot");

        addMenu();
    }
}
