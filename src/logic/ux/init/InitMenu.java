package logic.ux.init;

import logic.obj.uao.UAOAdders;
import logic.obj.uao.UAOFinders;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;

public class InitMenu extends InitHandler implements Initializer {
    @Override
    public void init() {
        initMenu();
    }

    public static void initMenu() {
        UAOAdders.menuAdder.addAllInitUAO();
        UAOHandler.currentUAO = UAOFinders.menuFinder.findUAOByName(UAONames.MENU_MAIN);
    }
}
