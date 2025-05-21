package logic.ux.program;

import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.menu.MenuTraverse;
import logic.ux.init.InitProgram;
import logic.ux.input.InputHandler;
import logic.ux.output.OutputUAO;
import models.uao.Action;
import models.uao.Menu;

public class Program {
    public static void run() {
        InitProgram.initProgram();

        do {
            if (UAOHandler.currentUAO.getClass().equals(Menu.class)) {
                OutputUAO.printUAO();
                InputHandler.inputMenuText = InputHandler.scanner.nextLine();
            } else {
                Action action = (Action) UAOHandler.currentUAO;
                action.getFunction().apply(null);
            }

            MenuTraverse.changeMenu(InputHandler.inputMenuText);
            InputHandler.inputMenuText = null;

        } while (!UAOHandler.currentUAO.getName().equals(UAONames.MENU_EXIT));
    }
}
