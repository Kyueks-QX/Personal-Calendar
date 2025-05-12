package logic.menu;

import models.Menu;
import models.UserInteractive;

import java.util.HashMap;

public class MenuMaker extends MenuHandler {
    public static Menu makeMenu(String name, String desc, HashMap<UserInteractive, String> options) {
        return new Menu.Builder()
                .withName(name)
                .withDesc(desc)
                .withOptions(options)
                .build();
    }
}
