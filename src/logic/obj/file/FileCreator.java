package logic.obj.file;

import java.io.File;

// Makes a file.
public class FileCreator extends FileHandler {
    public static boolean createFile(String fileName) {
        if (fileName == null) {
            fileName = "default.txt";
        }
        try {
            FileName.setFileName(fileName);
            file = new File(fileName);
            return file.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException("File create error: " + FileHandler.file + ", " + e);
        }
    }
}