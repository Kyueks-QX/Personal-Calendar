package logic.init;

import logic.menu.MenuAdder;

public class InitMenu extends InitHandler implements Initializer {
    @Override
    public void init() {
        initMenu();
    }

    public static void initMenu() {
        MenuAdder.addAllMenus();
        MenuAdder.menuStack.push();
        //need findmenu implement here
    }
}
