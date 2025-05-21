package logic.file;

import models.calendar.Calendar;

import java.io.*;

/**
 * Class for loading from a file.
 */
public class FileLoader extends FileHandler {
    /**
     * Loads calendar from a file.
     * @param fileName
     * Gets the calendar from the file with matching file name.
     * @return
     * Returns the calendar gotten from the file.
     */
    public static Calendar loadCalendarFromFile(String fileName) {
        Calendar calendar = null;
        if (fileName == null) { fileName = "default.txt"; }

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            calendar = (Calendar) in.readObject();

            in.close();
            file.close();
        } catch (Exception ex) {
            System.out.println("File load error: " + ex);
        }

        return calendar;
    }
}
