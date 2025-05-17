package logic.find;

import logic.obj.date.DateFinder;
import logic.obj.day.DayFinder;
import logic.obj.uao.menu.MenuFinder;

//contains every single finder as public static fields
public class Finders {
    public static DateFinder dateFinder = new DateFinder();
    public static DayFinder dayFinder = new DayFinder();
    public static MenuFinder menuFinder = new MenuFinder();
}
