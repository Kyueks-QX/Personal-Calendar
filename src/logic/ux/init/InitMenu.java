package logic.ux.init;

import logic.find.Finders;
import logic.obj.menu.MenuAdder;

public class InitMenu extends InitHandler implements Initializer {
    @Override
    public void init() {
        initMenu();
    }

    public static void initMenu() {
        MenuAdder.addAllMenus();
        MenuAdder.menuStack.push(Finders.menuFinder.findMenuByName("main menu"));
    }
}
