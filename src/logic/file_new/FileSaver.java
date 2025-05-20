package logic.file_new;

import logic.file.FileHandler;
import models.calendar.Calendar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileSaver extends FileHandler {
    public static void saveCalendarToFile(Calendar calendar) {
        if (fileName == null) { fileName = "default.txt"; }

        try {
            if (calendar == null) {
                throw new RuntimeException();
            }
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(calendar);

            out.close();
            file.close();
        } catch (Exception ex) {
            System.out.println("File save error: " + ex);
        }
    }
}
