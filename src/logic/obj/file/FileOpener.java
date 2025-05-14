package logic.obj.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//Opens files.
public class FileOpener extends FileHandler {
    public static void openFile(String fileName) {
        try {
            file = new File(fileName);
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file);
        } catch (Exception e) {
            throw new RuntimeException("File open error: " + e);
        }
    }
}
