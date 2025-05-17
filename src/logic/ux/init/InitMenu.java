package logic.ux.init;

import logic.find.Finders;
import logic.obj.uao.UAOAdders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.menu.MenuAdder;

public class InitMenu extends InitHandler implements Initializer {
    @Override
    public void init() {
        initMenu();
    }

    public static void initMenu() {
        UAOAdders.menuAdder.addAllInitUAO();
        UAOHandler.UAOStack.push(Finders.menuFinder.findMenuByName("mainMenu"));
    }
}
