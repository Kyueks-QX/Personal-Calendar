package logic.ux.output;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Action;
import models.uao.Menu;
import models.uao.Prompt;
import models.uao.UserActionObject;

import java.util.Map;

public class OutputUAO extends OutputHandler {
    public static void printUAO() {
        UserActionObject userActionObject = UAOHandler.currentUAO;

        if (userActionObject.getClass().equals(Menu.class)) { printMenu(userActionObject); }
        if (userActionObject.getClass().equals(Prompt.class)) { printPrompt(userActionObject); }
        if (userActionObject.getClass().equals(Action.class)) { printAction(userActionObject); }
    }

    private static void printMenu(UserActionObject userActionObject) {
        Menu currentMenu = (Menu) userActionObject;

        System.out.println(currentMenu.getDesc());
        for (Map.Entry<UAONames, String> option : currentMenu.getOptions().entrySet()) {
            System.out.println(option.getValue());
        }
    }

    private static void printPrompt(UserActionObject userActionObject) {
        Prompt currentPrompt = (Prompt) userActionObject;

        System.out.println(currentPrompt.getInstruction());
        System.out.println(currentPrompt.getFormat());
    }

    private static void printAction(UserActionObject userActionObject) {
        Action currentAction = (Action) userActionObject;

        status = currentAction.getFunction().apply(null);
    }
}
