package logic.file_new;

import logic.file.FileHandler;

public class FileName extends FileHandler {
    public static void setFileName(String fileName) {
        FileHandler.fileName = fileName;
    }
    public static String getFileName() {
        return FileHandler.fileName;
    }
}
