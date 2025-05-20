package logic.find;

import logic.obj.date.DateFinder;
import logic.obj.day.DayFinder;

//contains every single finder as public static fields
public class Finders {
    public static DateFinder dateFinder = new DateFinder();
    public static DayFinder dayFinder = new DayFinder();
}
