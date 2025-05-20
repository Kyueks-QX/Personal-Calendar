package logic.obj.uao.action;

import logic.obj.uao.UAOFinder;
import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Action;
import models.uao.UserActionObject;

public class ActionFinder extends UAOHandler implements UAOFinder {
    @Override
    public Object find(Object o) {
        Action searchedAction = (Action) o;
        for (UserActionObject action : userActionObjects) {
            if (action.equals(searchedAction)) {
                return userActionObjects.get(userActionObjects.indexOf(action));
            }
        }
        return null;
    }

    @Override
    public int findIndex(Object o) {
        Action searchedMenu = (Action) o;
        for (UserActionObject action : userActionObjects) {
            if (action.equals(searchedMenu)) {
                return userActionObjects.indexOf(action);
            }
        }
        return -1;
    }

    @Override
    public UserActionObject findUAOByName(UAONames name) {
        for (UserActionObject action : userActionObjects) {
            if (!action.getClass().equals(Action.class)) {
                continue;
            }
            Action tempMenu = (Action) action;
            if (tempMenu.getName().equals(name)) {
                return tempMenu;
            }
        }
        return null;
    }
}
