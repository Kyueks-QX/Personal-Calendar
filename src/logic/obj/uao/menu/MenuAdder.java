package logic.obj.uao.menu;

import logic.file_new.FileName;
import logic.obj.uao.UAOAdder;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.prompt.PromptChainMaker;
import models.uao.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Adds all menus to the list of userActionObjects the program has
public class MenuAdder extends UAOHandler implements UAOAdder {
    private Menu menu;
    private UAONames name;
    private String desc;
    private Map<UAONames, String> options;

    @Override
    public void addAllInitUAO() {
        mainMenu();
        exit();
        calendarChangeMenu();
        calendarViewMenu();
        filesMenu();
    }

    @Override
    public void addUAO() {
        menu = MenuMaker.makeMenu(name, desc, options);
        UAOHandler.userActionObjects.add(menu);
    }

    // the four functions below just shortens the call, so I don't have to copy-paste the whole thing every time
    private Menu getMenu(UAONames name) {
        return (Menu) UAOFinders.menuFinder.findUAOByName(name);
    }

    private Prompt getPrompt(UAONames name) {
        return (Prompt) UAOFinders.promptFinder.findUAOByName(name);
    }

    private Action getAction(UAONames name) {
        return (Action) UAOFinders.actionFinder.findUAOByName(name);
    }

    private ArrayList<Prompt> getPromptChain(Prompt... prompts) {
        return (ArrayList<Prompt>) PromptChainMaker.makePromptChain(prompts);
    }

    private void mainMenu() {
        name = UAONames.MENU_MAIN;
        desc = "Welcome to your personal calendar!";

        options = new HashMap<>();
        options.put(UAONames.MENU_CALCHANGE, "(calchange) Make changes to the calendar");
        options.put(UAONames.MENU_CALVIEW, "(calview) View calendar content");
        options.put(UAONames.MENU_FILES, "(files) Files");
        options.put(UAONames.MENU_EXIT, "(exit) Exit program");

        addUAO();
    }

    private void exit() {
        name = UAONames.MENU_EXIT;
        desc = "See you next time!";

        addUAO();
    }

    private void calendarChangeMenu() {
        name = UAONames.MENU_CALCHANGE;
        desc = "What would you like to do with your calendar?";

        options = new HashMap<>();
        options.put(UAONames.ACTION_BOOK, "(1) Book a date");
        options.put(UAONames.ACTION_CHANGE, "(2) Change a date");
        options.put(UAONames.ACTION_UNBOOK, "(3) Remove a date");
        options.put(UAONames.ACTION_HOLIDAY, "(4) (Un)mark day as holiday");
        options.put(UAONames.ACTION_MERGE, "(5) Merge saved calendar into current calendar");
        options.put(UAONames.MENU_MAIN, "(0) Back to main menu");

        addUAO();
    }

    private void calendarViewMenu() {
        name = UAONames.MENU_CALVIEW;
        desc = "What would you like to view from your calendar?";

        options = new HashMap<>();
        options.put(UAONames.ACTION_AGENDA, "(1) See all dates in a given day");
        options.put(UAONames.ACTION_BUSYDAYS, "(2) See all days with dates");
        options.put(UAONames.ACTION_FIND, "(3) Find all dates with a name/note");
        options.put(UAONames.ACTION_FINDSLOT, "(4) Find the earliest spot available for a given date");
        options.put(UAONames.MENU_MAIN, "(0) Back to main menu");

        addUAO();
    }

    private void filesMenu() {
        name = UAONames.MENU_FILES;
        desc = new StringBuilder("Would you like to save, load or change working file?")
                .append("\n").append("Current file: ")
                .append(FileName.getFileName()).toString();

        options = new HashMap<>();
        options.put(UAONames.ACTION_FILE_SAVE, "(1) Save");
        options.put(UAONames.ACTION_FILE_LOAD, "(2) Load");
        options.put(UAONames.ACTION_FILE_CHANGE, "(3) Change file");
        options.put(UAONames.MENU_FILES, "(0) Back to main menu");

        addUAO();
    }
}
