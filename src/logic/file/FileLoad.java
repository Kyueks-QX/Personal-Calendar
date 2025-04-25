package logic.file;

import models.Calendar;

public class FileLoad extends FileHandler {
    public static void loadFromFile(Calendar calendar, String fileName) {
        FileOpener.openFile(fileName);
        FileReader.readFromFile();
        FileCloser.closeFile();
    }
}
