package logic.obj.menu;

import models.Menu;
import models.UserInteractive;

import java.util.HashMap;

public class MenuAdder extends MenuHandler {
    private static String name;
    private static String desc;
    private static HashMap<UserInteractive, String> options;
    private static Menu menu;

    public static void addAllMenus() {
        addMainMenu();
    }

    private static void addMenu() {
        menu = MenuMaker.makeMenu(name, desc, options);
        MenuHandler.menus.add(menu);
    }

    private static void addMainMenu() {
        name = "main menu";
        desc = "Welcome to your personal calendar!";
        options.put(null, "Make changes to the calendar");
        options.put(null, "Search in the calendar");
        options.put(null, "Files");
        options.put(null, "Exit");
        addMenu();
    }
}
