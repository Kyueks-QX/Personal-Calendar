package logic.file;
import models.calendar.Calendar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Class for saving in a file.
 */
public class FileSaver extends FileHandler {
    /**
     * Saves the calendar to a file.
     * @param calendar
     * The calendar currently in use.
     */
    public static void saveCalendarToFile(Calendar calendar) {

        if (logic.file.FileHandler.fileName == null) { logic.file.FileHandler.fileName = "default.txt"; }

        try {
            if (calendar == null) {
                throw new RuntimeException();
            }
            FileOutputStream file = new FileOutputStream(logic.file.FileHandler.fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(calendar);

            out.close();
            file.close();
        } catch (Exception ex) {
            System.out.println("File save error: " + ex);
        }
    }
}
