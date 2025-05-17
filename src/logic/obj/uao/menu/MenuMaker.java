package logic.obj.uao.menu;

import logic.obj.uao.UAOHandler;
import models.Menu;
import models.UserActionObject;

import java.util.HashMap;
import java.util.Map;

public class MenuMaker extends UAOHandler {
    public static Menu makeMenu(String name, String desc, Map<UserActionObject, String> options, UserActionObject prevUserActionObject) {
        return new Menu.Builder()
                .withName(name)
                .withDesc(desc)
                .withOptions((HashMap<UserActionObject, String>) options)
                .withPrevAction(prevUserActionObject)
                .build();
    }
}
