package logic.menu;

import logic.misc.Finder;
import models.Menu;

public class MenuFinder extends MenuHandler implements Finder {
    @Override
    public Object find(Object o) {
        return findMenu((Menu) o);
    }

    public static Menu findMenu(Menu searchedMenu) {
        
    }
}
