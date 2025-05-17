package logic.obj.uao.menu;

import logic.find.Finder;
import logic.obj.uao.UAOHandler;
import models.Menu;
import models.UserActionObject;

public class MenuFinder extends UAOHandler implements Finder {
    @Override
    public Object find(Object o) {
        Menu searchedMenu = (Menu) o;
        for (UserActionObject menu : userActionObjects) {
            if (menu.equals(searchedMenu)) {
                return userActionObjects.get(userActionObjects.indexOf(menu));
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Menu searchedMenu = (Menu) o;
        for (UserActionObject menu : userActionObjects) {
            if (menu.equals(searchedMenu)) {
                return userActionObjects.indexOf(menu);
            }
        }
        return -1;
    }

    public Menu findMenuByName(String name) {
        for (UserActionObject menu : userActionObjects) {
            if (!menu.getClass().equals(Menu.class)) {
                continue;
            }
            Menu tempMenu = (Menu) menu;
            if (tempMenu.getName().equals(name)) {
                return tempMenu;
            }
        }
        return null;
    }
}
