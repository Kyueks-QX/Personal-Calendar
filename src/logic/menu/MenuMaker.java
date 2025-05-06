package logic.menu;

import models.Menu;

import java.util.List;

public class MenuMaker extends MenuHandler {
    public static Menu makeMenu(String name, String desc, List<String> options) {
        return new Menu.Builder()
                .withName(name)
                .withDesc(desc)
                .withOptions(options)
                .build();
    }
}
