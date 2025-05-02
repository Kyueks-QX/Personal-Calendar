package logic.file;

import models.Calendar;

public class FileSaver extends FileHandler {
    public static void saveToFile(Calendar calendar, String fileName) {
        if (fileName != null) {
            FileCloser.closeFile();
            FileCreator.createFile(fileName);
            FileOpener.openFile(fileName);
        }

        // toString() may be overridden in the future, IDK
        FileText.setText(calendar.getDates().toString());
        FileWriter.writeToFile();
        FileCloser.closeFile();
    }
}
