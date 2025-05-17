package logic.file_new;

import logic.file.FileHandler;
import models.Calendar;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileSaver extends FileHandler {
    public static void saveCalendarToFile(Calendar calendar, String fileName) {
        try {
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
