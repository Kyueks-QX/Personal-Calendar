package logic.menu;

import models.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class MenuHandler {
    public static List<Menu> menus = new ArrayList<>();
    public static Stack<Menu> menuStack = new Stack<>();
}
