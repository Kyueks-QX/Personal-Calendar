package logic.ux.program;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import logic.obj.uao.menu.MenuTraverse;
import logic.ux.init.InitProgram;
import logic.ux.input.InputHandler;
import logic.ux.output.OutputUAO;

public class Program {
    public static void run() {
        InitProgram.initProgram();

        do {
            OutputUAO.printUAO();
            InputHandler.inputText = InputHandler.scanner.nextLine();
            MenuTraverse.changeMenu(InputHandler.inputText);

        } while (!UAOHandler.currentUAO.getName().equals(UAONames.MENU_EXIT));
    }
}
