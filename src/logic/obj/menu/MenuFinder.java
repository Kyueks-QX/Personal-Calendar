package logic.obj.menu;

import logic.find.Finder;
import models.Menu;

public class MenuFinder extends MenuHandler implements Finder {
    @Override
    public Object find(Object o) {
        Menu searchedMenu = (Menu) o;
        for (Menu menu : menus) {
            if (menu == searchedMenu) {
                return menus.get(menus.indexOf(menu));
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Menu searchedMenu = (Menu) o;
        for (Menu menu : menus) {
            if (menu == searchedMenu) {
                return menus.indexOf(menu);
            }
        }
        return -1;
    }

    public Menu findMenuByName(String name) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                return menus.get(menus.indexOf(menu));
            }
        }
        return null;
    }
}
