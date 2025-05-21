package logic.find;

import logic.obj.date.DateFinder;
import logic.obj.day.DayFinder;

/**
 * Contains every single UserActionObject finder as public static fields.
 * <p>
 * I didn't have the time to actually put the UAO finders in their separate space.
 */
public class Finders {
    /**
     * publicly available date finder.
     */
    public static DateFinder dateFinder = new DateFinder();
    /**
     * publicly available day finder.
     */
    public static DayFinder dayFinder = new DayFinder();
}
