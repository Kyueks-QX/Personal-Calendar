package logic.ux.output;

import logic.obj.uao.UAOHandler;
import models.Menu;
import models.UserActionObject;

import java.util.Map;

public class OutputMenu extends OutputHandler {
    public static void printMenu() {
        Menu currentMenu = (Menu) UAOHandler.UAOStack.peek();

        System.out.println(currentMenu.getDesc());
        for (Map.Entry<UserActionObject, String> option : currentMenu.getOptions().entrySet()) {
            System.out.println(option.getValue());
        }
    }
}
