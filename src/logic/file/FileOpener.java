package logic.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//Opens files.
public class FileOpener extends FileHandler {
    public static void OpenFile(String fileName) {
        try {
            FileName.setFileName(fileName);
            file = new File(fileName);
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file);
        } catch (Exception e) {
            throw new RuntimeException("Error with file opening");
        }
    }
}
