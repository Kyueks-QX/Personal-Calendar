package logic.obj.uao.menu;

import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Menu;

public class MenuTraverse extends UAOHandler {
    public static void changeMenu(String inputText) {
        if (!currentUAO.getClass().equals(Menu.class)) {
            currentUAO = UAOFinders.menuFinder.findUAOByName(UAONames.MENU_MAIN);
        }


        try {
            currentUAO = UAOFinders.menuFinder.findUAOByName(UAONames.valueOf(
                    "MENU_" + inputText.toUpperCase()
                    ));
        } catch (Exception _) { }
    }
}
