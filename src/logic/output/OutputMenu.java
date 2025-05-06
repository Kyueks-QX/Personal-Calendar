package logic.output;

import logic.menu.MenuHandler;
import models.Menu;

public class OutputMenu extends OutputHandler {
    public static void printMenu() {
        Menu currentMenu = MenuHandler.menuStack.peek();

        System.out.println(currentMenu.getDesc());
        for (String option : currentMenu.getOptions()) {
            System.out.println("(" + (currentMenu.getOptions().indexOf(option) + 1) + ") " + option);
        }
        System.out.println("(0) Exit");
    }
}
