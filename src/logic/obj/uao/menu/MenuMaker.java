package logic.obj.uao.menu;

import logic.obj.uao.UAOHandler;
import logic.obj.uao.UAONames;
import models.uao.Menu;
import models.uao.UserActionObject;

import java.util.HashMap;
import java.util.Map;

public class MenuMaker extends UAOHandler {
    public static Menu makeMenu(UAONames name, String desc, Map<UAONames, String> options) {
        return new Menu.Builder()
                .withName(name)
                .withDesc(desc)
                .withOptions((HashMap<UAONames, String>) options)
                .build();
    }
}
