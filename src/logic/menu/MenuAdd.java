package logic.menu;

import models.Menu;

import java.util.List;

public class MenuAdd extends MenuHandler {
    private String name;
    private String desc;
    private List<String> options;
    private Menu menu;

    protected void addAllMenus() {
        addMainMenu();
    }

    private void addMenu() {
        menu = MenuMaker.makeMenu(name, desc, options);
        MenuHandler.menus.add(menu);
    }

    private void addMainMenu() {
        name = "main menu";
        desc = "Welcome to your personal calendar!";
        options.add("Make changes to the calendar");
        options.add("Search in the calendar");
        options.add("Files");
        //no need to add the 'exit menu' line manually, it's there by default
        addMenu();
    }
}
