package logic.obj.uao.menu;

import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Action;
import models.uao.Menu;

public class MenuTraverse extends UAOHandler {
    public static void changeMenu(String inputText) {
        Action action = null;
        try {
            action = (Action) UAOFinders.actionFinder.findUAOByName(UAONames.valueOf(
                    "ACTION_" + inputText.toUpperCase()
            ));
        } catch (Exception _) { }

        if (action != null) {
            currentUAO = action;
            return;
        } else {
            currentUAO = UAOFinders.menuFinder.findUAOByName(UAONames.MENU_MAIN);
        }

        try {
            currentUAO = UAOFinders.menuFinder.findUAOByName(UAONames.valueOf(
                    "MENU_" + inputText.toUpperCase()
                    ));
        } catch (Exception _) { }
    }
}
