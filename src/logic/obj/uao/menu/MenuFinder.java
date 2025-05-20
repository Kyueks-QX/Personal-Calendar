package logic.obj.uao.menu;

import logic.obj.uao.UAOFinder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Menu;
import models.uao.UserActionObject;

public class MenuFinder extends UAOHandler implements UAOFinder {
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

    @Override
    public UserActionObject findUAOByName(UAONames name) {
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
