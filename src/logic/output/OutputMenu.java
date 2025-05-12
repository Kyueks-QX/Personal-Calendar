package logic.output;

import logic.menu.MenuHandler;
import models.Menu;
import models.UserInteractive;

import java.util.HashMap;
import java.util.Map;

public class OutputMenu extends OutputHandler {
    public static void printMenu() {
        Menu currentMenu = MenuHandler.menuStack.peek();

        System.out.println(currentMenu.getDesc());
        for (Map.Entry<UserInteractive, String> option : currentMenu.getOptions().entrySet()) {
            System.out.println(option.getValue());
        }
    }
}
