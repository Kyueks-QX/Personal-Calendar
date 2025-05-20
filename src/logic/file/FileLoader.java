package logic.file;

import models.calendar.Calendar;

public class FileLoader extends FileHandler {
    public static void loadFromFile(Calendar calendar, String fileName) {
        FileOpener.openFile(fileName);
        FileReader.readFromFile();
        FileCloser.closeFile();
    }
}
