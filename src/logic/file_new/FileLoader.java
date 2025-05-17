package logic.file_new;

import logic.file.FileHandler;
import models.Calendar;

import java.io.*;

public class FileLoader extends FileHandler {
    public static Calendar loadCalendarFromFile(String fileName) {
        Calendar calendar = null;

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
